require python3-labgrid.inc

SRC_URI += "git://github.com/labgrid-project/labgrid.git;protocol=https;branch=${SRCBRANCH}"

SRCBRANCH = "master"
SRCREV = "bf387497f73b8bd1bc6a35b52a5c7443468ff21f"

PV = "25.0+git"

LABGRID_USE_DEVEL_VERSION[doc] = "Global switch to enable labgrid development (git) version"
LABGRID_USE_DEVEL_VERSION ??= "-1"
DEFAULT_PREFERENCE ??= "${LABGRID_USE_DEVEL_VERSION}"
