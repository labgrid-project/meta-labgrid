DESCRIPTION = "Embedded systems control library for development, testing and installation"
HOMEPAGE = "https://github.com/labgrid-project"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c0e9407a08421b8c72f578433434f0bd"

RDEPENDS:${PN} = " \
    coreutils \
    libgpiod \
    python3-ansicolors \
    python3-asyncio \
    python3-attrs \
    python3-graphviz \
    python3-grpcio \
    python3-grpcio-channelz \
    python3-grpcio-reflection \
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
    ser2net \
    sudo \
"

RRECOMMENDS:${PN} = " \
    ethtool \
    iproute2-ip \
    rsync \
    socat \
"

SRC_URI = " \
    file://configuration.yaml \
    file://helpers.yaml \
    file://labgrid-exporter.service \
    file://labgrid-coordinator.service \
    file://environment \
    "

DEPENDS += "python3-setuptools-scm-native"
DEPENDS += "python3-pytest-runner-native"

inherit python_setuptools_build_meta systemd

SYSTEMD_SERVICE:${PN} = "labgrid-exporter.service"
SYSTEMD_SERVICE:${PN}-coordinator = "labgrid-coordinator.service"

# Client/library access to the device via SSH as "root" user is assumed.
# Additional configuration (dedicated user and related sudoers config for
# password-less helpers usage) shall be done separately.
do_install:append() {
    install -d ${D}${sbindir}
    install -m 0755 ${S}/helpers/labgrid-* ${D}${sbindir}

    install -d ${D}${sysconfdir}/labgrid
    install -m 0644 ${UNPACKDIR}/configuration.yaml ${D}${sysconfdir}/labgrid
    install -m 0644 ${UNPACKDIR}/helpers.yaml ${D}${sysconfdir}/labgrid
    install -m 0644 ${UNPACKDIR}/environment ${D}${sysconfdir}/labgrid
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/labgrid-exporter.service ${D}${systemd_system_unitdir}/
    install -m 0644 ${UNPACKDIR}/labgrid-coordinator.service ${D}${systemd_system_unitdir}/
}

PACKAGES += "${PN}-coordinator"
RDEPENDS:${PN}-coordinator = "${PN}"

FILES:${PN}-coordinator += "${systemd_system_unitdir}/labgrid-coordinator.service /usr/bin/labgrid-coordinator"
FILES:${PN} += "${sysconfdir} ${systemd_system_unitdir}"
