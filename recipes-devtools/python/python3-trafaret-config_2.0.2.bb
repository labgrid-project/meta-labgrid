SUMMARY = "This is a wrapper that loads yaml and checks config using trafaret while keeping track of actual lines of file where error has happened."
HOMEPAGE = "https://github.com/tailhook/trafaret-config"
LICENSE = "Apache-2.0 & MIT"
LIC_FILES_CHKSUM = "file://README.rst;beginline=98;endline=106;md5=a15308789c3b7d0f3ef36b69048423e4"

SRC_URI = "https://pypi.python.org/packages/source/t/trafaret-config/trafaret-config-${PV}.tar.gz"

SRC_URI[md5sum] = "b5991b1753e605d786cfecb03b087908"
SRC_URI[sha256sum] = "440b6b49e5e975f9a640a2519abb2feddd96eb2aeb1715f87f947a7a079f20be"

inherit pypi setuptools3

