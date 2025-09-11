require python3-lxa-iobus.inc

SRCREV = "1d90a81eef5a61fd0d2bfdcd72a7a1e98cbf1290"
SRCBRANCH = "master"
PV = "0.5.1+git${SRCPV}"

LXA_IOBUS_USE_DEVEL_VERSION[doc] = "Global switch to enable lxa-iobus development (git) version"
LXA_IOBUS_USE_DEVEL_VERSION ??= "-1"
DEFAULT_PREFERENCE ??= "${LXA_IOBUS_USE_DEVEL_VERSION}"
