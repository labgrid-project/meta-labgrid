require python3-lxa-iobus.inc

PV = "0.6.1+git${SRCPV}"
SRCBRANCH = "master"
SRCREV = "8f7c26c1b376d1664c7fb22472c7ff3ea2a0f010"

LXA_IOBUS_USE_DEVEL_VERSION[doc] = "Global switch to enable lxa-iobus development (git) version"
LXA_IOBUS_USE_DEVEL_VERSION ??= "-1"
DEFAULT_PREFERENCE ??= "${LXA_IOBUS_USE_DEVEL_VERSION}"
