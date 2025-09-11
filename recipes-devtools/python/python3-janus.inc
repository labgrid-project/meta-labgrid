SUMMARY = "Mixed sync-async queue to interoperate between asyncio tasks and classic threads"
HOMEPAGE = "https://pypi.org/project/janus/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=23878c357ebb4c8ce1109be365043349"

inherit python_setuptools_build_meta pypi

RDEPENDS:${PN} += "python3-asyncio python3-core python3-threading"
