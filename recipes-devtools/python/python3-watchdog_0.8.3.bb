SUMMARY = "Filesystem events monitoring"
SECTION = "devel/python"

HOMEPAGE = "http://werkzeug.pocoo.org/"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "${PYTHON_PN}-argh"

SRC_URI = "https://pypi.python.org/packages/source/w/watchdog/watchdog-${PV}.tar.gz"
SRC_URI[md5sum] = "bb16926bccc98eae2a04535e4512ddf1"
SRC_URI[sha256sum] = "7e65882adb7746039b6f3876ee174952f8eaaa34491ba34333ddf1fe35de4162"

S = "${WORKDIR}/watchdog-${PV}"

inherit setuptools

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

RDEPENDS_${PN} = "${PYTHON_PN}-argh"

BBCLASSEXTEND = "native"
