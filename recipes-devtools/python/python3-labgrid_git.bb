require python3-labgrid.inc

SRC_URI += "git://github.com/labgrid-project/labgrid.git;protocol=https;branch=stable-23.0"

SRCREV = "ba15037ff7fb2cd0748aa404c6cf6dcff6c3b143"

LABGRID_USE_DEVEL_VERSION[doc] = "Global switch to enable labgrid development (git) version"
LABGRID_USE_DEVEL_VERSION ??= "-1"
DEFAULT_PREFERENCE ??= "${LABGRID_USE_DEVEL_VERSION}"
