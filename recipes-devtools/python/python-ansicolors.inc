SUMMARY = "ANSI colors for Python"
HOMEPAGE = "https://github.com/jonathaneunice/colors/"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=aef5566ac4fede9815eccf124c281317"

SRC_URI[md5sum] = "9ca7e2396ffa2e20af023c6b83ab7b14"
SRC_URI[sha256sum] = "99f94f5e3348a0bcd43c82e5fc4414013ccc19d70bd939ad71e0133ce9c372e0"

inherit pypi

PYPI_PACKAGE_EXT = "zip"

BBCLASSEXTEND = "native nativesdk"
