require python3-labgrid.inc

SRC_URI += "git://github.com/labgrid-project/labgrid.git;protocol=https;branch=${SRCBRANCH}"

SRCBRANCH = "master"
SRCREV = "f63dfd70a5da2c7007ee8c320fa969df2c0bf16e"

PV = "25.0+git"

LABGRID_USE_DEVEL_VERSION[doc] = "Global switch to enable labgrid development (git) version"
LABGRID_USE_DEVEL_VERSION ??= "-1"
DEFAULT_PREFERENCE ??= "${LABGRID_USE_DEVEL_VERSION}"
