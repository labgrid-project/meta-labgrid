#!/usr/bin/env python3

import glob
from tempfile import TemporaryDirectory
import hashlib
import re
import os.path
import subprocess

import requests
import yaml
from jinja2 import Environment, FileSystemLoader, StrictUndefined


BRANCH_PRIORITIES = tuple(
    (re.compile(pattern), prio)
    for pattern, prio in (
        ("main", 9999),
        ("master", 9998),
        ("release.*", 9997),
        ("stable.*", 9996),
        (".*release", 9995),
        (".*stable", 9994),
        ("bugfix.*", 6001),
        ("hotfix.*", 6000),
        # The default is 5000
        ("next", 4003),
        ("develop", 4002),
        ("staging", 4001),
        ("feature.*", 4000),
        (".*/.*", 2000),
    )
)


def semver_key(pv):
    return tuple(int(n) for n in pv.split("."))


def branch_key(name):
    """Assign a priority to a branch name

    A commit will likely be contained in multiple branches and we want to use
    the most descriptive one as SRCBRANCH in the recipes.
    Assign priorities to common branch names based on how descriptive they are.
    """

    for pattern, prio in BRANCH_PRIORITIES:
        if pattern.fullmatch(name):
            return (prio, name)

    return (5000, name)


def get_json(url):
    with requests.get(url) as req:
        req.raise_for_status()
        res = req.json()

    return res


def url_hash(url):
    print(f"Hashing {url}")

    sha256 = hashlib.sha256()

    with requests.get(url, stream=True) as req:
        req.raise_for_status()

        for chunk in req.iter_content(chunk_size=8192):
            print(".", end="", flush=True)

            if chunk:
                sha256.update(chunk)

    print(" done.")

    return sha256.hexdigest()


def run(cmd, capture=True):
    stdout = subprocess.PIPE if capture else None
    return subprocess.run(cmd, stdout=stdout, check=True, text=True).stdout


def fetch_pypi(info):
    name = info["name"]
    version_pattern = re.compile(info["version_pattern"])

    project = get_json(f"https://pypi.org/pypi/{name}/json")

    packages = dict()

    for version, release_packages in project["releases"].items():
        version_match = version_pattern.match(version)

        if version_match is None:
            continue

        pv = version_match[1]

        for package in release_packages:
            if package["packagetype"] != "sdist":
                continue

            packages[pv] = package
            newest = pv

    if info["version_order"] == "semver":
        newest = max(packages, key=semver_key)

    info["pv"] = newest
    info["package"] = packages[newest]


def fetch_github_release(info):
    project = info["project"]
    version_pattern = re.compile(info["version_pattern"])

    github_releases = get_json(f"https://api.github.com/repos/{project}/releases")

    releases = dict()

    for release in github_releases:
        name_match = version_pattern.match(release.get("name", ""))
        name_match = name_match or version_pattern.match(release["tag_name"])

        if name_match is None:
            continue

        pv = name_match[1]

        releases[pv] = release
        newest = pv

    if info["version_order"] == "semver":
        newest = max(releases, key=semver_key)

    info["pv"] = newest
    info["release"] = releases[newest]

    tag_name = info["release"]["tag_name"]

    try:
        info["release"]["tar_url"] = info["release"]["assets"][0][
            "browser_download_url"
        ]
    except (IndexError, KeyError):
        info["release"]["tar_url"] = (
            f"https://github.com/{project}/archive/refs/tags/{tag_name}.tar.gz"
        )

    info["release"]["tar_sha256"] = url_hash(info["release"]["tar_url"])

    if "downloadfilename" in info:
        tar_url = info["release"]["tar_url"]
        dfn = info["downloadfilename"].replace("$PV", info["pv"])

        info["release"]["tar_url"] = f"{tar_url};downloadfilename={dfn}"


def fetch_git_branch(info):
    url = info["url"]
    branch = info["branch"]

    with TemporaryDirectory() as dir:
        git_dir = os.path.join(dir, "repo.git")
        git = ["git", "-C", git_dir]

        run(["git", "clone", "--bare", "--filter=blob:none", url, git_dir], False)

        commit_hash = run([*git, "rev-parse", f"refs/heads/{branch}"]).strip()
        commit_date = run([*git, "log", "-1", "--format=%ci", commit_hash]).strip()

        try:
            info["describe"] = run([*git, "describe", "--tags", branch]).strip()
        except subprocess.CalledProcessError:
            pass

    version_pattern = info.get("version_pattern")
    version = re.match(version_pattern, info["describe"])[1] if version_pattern else ""

    info["pv"] = f"{version}+git" if version else ""
    info["commit_hash"] = commit_hash
    info["commit_date"] = commit_date


def fetch_git_tag(info):
    url = info["url"]
    version_pattern = re.compile(info["version_pattern"])

    versions = dict()

    with TemporaryDirectory() as dir:
        git_dir = os.path.join(dir, "repo.git")
        git = ["git", "-C", git_dir]

        run(["git", "clone", "--bare", "--filter=blob:none", url, git_dir], False)

        tags = run([*git, "tag", "--list"]).strip()

        for tag in tags.split("\n"):
            version_match = version_pattern.match(tag)

            if version_match is not None:
                pv = version_match[1]
                versions[pv] = {"name": tag}

        if info["version_order"] == "semver":
            # When sorting by semver we do not need to get all commit dates,
            # only the one for the newest commit by semver in the tag name.
            # We can thus reduce the versions dict to only one entry.
            pv = max(versions, key=semver_key)
            versions = {pv: versions[pv]}

        for tag in versions.values():
            name = tag["name"]

            tag["hash"] = run(
                [*git, "rev-parse", f"refs/tags/{name}^{{commit}}"]
            ).strip()
            tag["date"] = run([*git, "log", "-1", "--format=%ci", tag["hash"]]).strip()
            tag["timestamp"] = int(
                run([*git, "log", "-1", "--format=%ct", tag["hash"]]).strip()
            )

            branches = run(
                [
                    *git,
                    "branch",
                    "--format=%(refname:lstrip=2)",
                    "--contains",
                    tag["hash"],
                ]
            ).strip()

            tag["branches"] = list(branch.strip() for branch in branches.split("\n"))
            tag["branch"] = max(tag["branches"], key=branch_key)

    # Sort the remaining candidates by date.
    # If the version_order is semver the dict will only have one element
    # at this point in time.
    newest = max(versions, key=lambda v: versions[v]["timestamp"])

    info["tag"] = versions[newest]
    info["pv"] = newest


def fetch_sourceforge(info):
    project = info["project"]
    version_pattern = re.compile(info["version_pattern"])

    best_release = get_json(
        f"https://sourceforge.net/projects/{project}/best_release.json"
    )

    info["release"] = best_release["release"]
    info["pv"] = version_pattern.match(info["release"]["filename"])[1]
    info["tar_sha256"] = url_hash(info["release"]["url"])


def fetch_info(recipe_info):
    if "pypi" in recipe_info:
        fetch_pypi(recipe_info["pypi"])
        recipe_info["source"] = recipe_info["pypi"]

    elif "github_release" in recipe_info:
        fetch_github_release(recipe_info["github_release"])
        recipe_info["source"] = recipe_info["github_release"]

    elif "git_branch" in recipe_info:
        fetch_git_branch(recipe_info["git_branch"])
        recipe_info["source"] = recipe_info["git_branch"]

    elif "git_tag" in recipe_info:
        fetch_git_tag(recipe_info["git_tag"])
        recipe_info["source"] = recipe_info["git_tag"]

    elif "sourceforge" in recipe_info:
        fetch_sourceforge(recipe_info["sourceforge"])
        recipe_info["source"] = recipe_info["sourceforge"]


def write_recipe(recipe_info, jinja_env):
    # Generate new recipe content
    template = jinja_env.get_template(recipe_info["template"])
    recipe_bb = template.render(info=recipe_info)

    # Delete old recipes
    old_recipes = glob.glob(glob.escape(recipe_info["recipe"]).replace("$PV", "*"))
    for old_recipe in old_recipes:
        os.remove(old_recipe)
        print(f"Removed {old_recipe}")

    # Write new recipe to disk
    recipe_path = recipe_info["recipe"].replace("$PV", recipe_info["source"]["pv"])
    recipe_dir = os.path.dirname(recipe_path)

    os.makedirs(recipe_dir, exist_ok=True)

    with open(recipe_path, "w") as fd:
        fd.write(recipe_bb)
        print(f"Wrote {recipe_path}")


def main(argv):
    config_path = argv[1]
    config_dir = os.path.dirname(config_path)

    with open(argv[1]) as fd:
        config = yaml.safe_load(fd)

    jinja_env = Environment(
        loader=FileSystemLoader(config_dir),
        undefined=StrictUndefined,
        trim_blocks=True,
        lstrip_blocks=True,
    )

    for recipe in config["recipes"]:
        print(f"\n\nGenerate: {recipe['recipe']}")

        fetch_info(recipe)
        write_recipe(recipe, jinja_env)

        print("done")


if __name__ == "__main__":
    import sys

    main(sys.argv)
