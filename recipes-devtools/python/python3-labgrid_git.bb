DESCRIPTION = "Embedded systems control library for development, testing and installation"
HOMEPAGE = "https://github.com/labgrid-project"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c0e9407a08421b8c72f578433434f0bd"

RDEPENDS_${PN} = " \
    coreutils \
    ser2net \
    libgpiod \
    python3-ansicolors \
    python3-attrs \
    python3-asyncio \
    python3-autobahn \
    python3-jinja2 \
    python3-multiprocessing \
    python3-pexpect \
    python3-pyserial \
    python3-pytest \
    python3-pyudev \
    python3-pyusb \
    python3-pyyaml \
    python3-requests \
    python3-xmodem \
    python3-graphviz \
"

SRC_URI = " \
    git://github.com/labgrid-project/labgrid.git;branch=master \
    file://configuration.yaml \
    file://labgrid-exporter.service \
    file://environment \
    "

SRCREV = "7d1ded46aaf1dd13f159645cc5c9f31f7837489d"
S = "${WORKDIR}/git"

DEPENDS += "python3-setuptools-scm-native"
DEPENDS += "python3-pytest-runner-native"

inherit setuptools3 systemd

SYSTEMD_SERVICE_${PN} = "labgrid-exporter.service"

do_install_append() {
    install -d ${D}${sysconfdir}/labgrid
    install -m 0644 ${WORKDIR}/configuration.yaml ${D}${sysconfdir}/labgrid
    install -m 0644 ${WORKDIR}/environment ${D}${sysconfdir}/labgrid
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/labgrid-exporter.service ${D}${systemd_system_unitdir}/
}

FILES_${PN} += "${sysconfdir} ${systemd_system_unitdir}"
