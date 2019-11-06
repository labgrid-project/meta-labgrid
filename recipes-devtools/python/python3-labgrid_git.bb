DESCRIPTION = "Embedded systems control library for development, testing and installation"
HOMEPAGE = "https://github.com/labgrid-project"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c0e9407a08421b8c72f578433434f0bd"

RDEPENDS_${PN} = " \
    ser2net \
    libgpiod \
    python3-attrs \
    python3-asyncio \
    python3-autobahn \
    python3-jinja2 \
    python3-multiprocessing \
    python3-pexpect \
    python3-pyserial \
    python3-pytest \
    python3-pyudev \
    python3-pyyaml \
    python3-requests \
    python3-xmodem \
    python3-graphviz \
"

SRC_URI = " \
    git://github.com/labgrid-project/labgrid.git;branch=master \
    "

SRCREV = "30c6cb61e6292f36847e80ec3e5f730ddc4bac72"
S = "${WORKDIR}/git"

DEPENDS += "python3-setuptools-scm-native"
DEPENDS += "python3-pytest-runner-native"

inherit setuptools3
