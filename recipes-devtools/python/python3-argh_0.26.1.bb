SUMMARY = "Pattern matching and various utilities for file systems paths."
SECTION = "devel/python"

HOMEPAGE = "https://pypi.python.org/pypi/argh/"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=cede70b648dcc81baf5b431d38905bad"

SRC_URI = "https://pypi.python.org/packages/source/a/argh/argh-${PV}.tar.gz"
SRC_URI[md5sum] = "5a97ce2ae74bbe3b63194906213f1184"
SRC_URI[sha256sum] = "06a7442cb9130fb8806fe336000fcf20edf1f2f8ad205e7b62cec118505510db"

S = "${WORKDIR}/argh-${PV}"

inherit setuptools

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"
