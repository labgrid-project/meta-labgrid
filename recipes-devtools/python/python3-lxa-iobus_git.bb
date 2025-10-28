require python3-lxa-iobus.inc

PV = "0.5.1+git${SRCPV}"
SRCBRANCH = "master"
SRCREV = "30f376167212249e6e4e5035a902a98b647126bf"

LXA_IOBUS_USE_DEVEL_VERSION[doc] = "Global switch to enable lxa-iobus development (git) version"
LXA_IOBUS_USE_DEVEL_VERSION ??= "-1"
DEFAULT_PREFERENCE ??= "${LXA_IOBUS_USE_DEVEL_VERSION}"
