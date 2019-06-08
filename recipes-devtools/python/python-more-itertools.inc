DESCRIPTION = "More routines for operating on iterables, beyond itertools"
AUTHOR = "Erik Rose"
HOMEPAGE = "https://github.com/erikrose/more-itertools"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3396ea30f9d21389d7857719816f83b5"

SRC_URI[md5sum] = "c5a9cf0d9c3cfe952a4ed9b3175dae0d"
SRC_URI[sha256sum] = "c3e4748ba1aad8dba30a4886b0b1a2004f9a863837b8654e7059eebf727afa5a"

inherit pypi

BBCLASSEXTEND = "native nativesdk"
