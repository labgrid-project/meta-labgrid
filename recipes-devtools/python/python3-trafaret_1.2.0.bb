SUMMARY = "Ultimate transformation library that supports validation, contexts and aiohttp."
HOMEPAGE = "https://github.com/Deepwalker/trafaret/"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=21ecc7aa8f699874e706fc1354903437"

SRC_URI = "https://pypi.python.org/packages/source/t/trafaret/trafaret-${PV}.tar.gz"

SRC_URI[md5sum] = "4b6cf4c7a128e999b636ac24f4b267f9"
SRC_URI[sha256sum] = "3045f5b4f9634928e7dd66db0ce9fcfef5a075935bb54c6a1f476b62c62abdb4"

inherit pypi setuptools3
