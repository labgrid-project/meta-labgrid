require python3-labgrid.inc

SRC_URI += "git://github.com/labgrid-project/labgrid.git;protocol=https;branch=${SRCBRANCH}"

SRCBRANCH = "master"
SRCREV = "5f0ae27f62692cd703052a3c649f19d2f9abed0c"

PV = "24.0+git"

RDEPENDS:${PN} += " \
    python3-grpcio \
    python3-grpcio-reflection \
    python3-grpcio-channelz \
"
RDEPENDS:${PN}:remove = "python3-autobahn"

LABGRID_USE_DEVEL_VERSION[doc] = "Global switch to enable labgrid development (git) version"
LABGRID_USE_DEVEL_VERSION ??= "-1"
DEFAULT_PREFERENCE ??= "${LABGRID_USE_DEVEL_VERSION}"
