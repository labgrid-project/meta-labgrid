require python3-labgrid.inc

SRCBRANCH = "master"
SRCREV = "4398da7728675bc1a594284d75785590fb496660"

PV = "25.0+git"

LABGRID_USE_DEVEL_VERSION[doc] = "Global switch to enable labgrid development (git) version"
LABGRID_USE_DEVEL_VERSION ??= "-1"
DEFAULT_PREFERENCE ??= "${LABGRID_USE_DEVEL_VERSION}"
