DESCRIPTION = "Daemon which interfaces IOBus-devices from Linux Automation GmbH with test-automation tools like labgrid."
HOMEPAGE = "https://github.com/linux-automation/lxa-iobus"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=0674f4b6076ccd96a8b400a746f71dd3"

RDEPENDS:${PN} = " \
    python3-aiohttp \
    python3-aiohttp-json-rpc \
    python3-can \
    python3-janus \
"

SRC_URI = " \
    git://github.com/linux-automation/lxa-iobus.git;protocol=https;branch=master \
    file://environment \
    "

DEPENDS += "python3-setuptools-scm-native"

inherit python_setuptools_build_meta systemd

do_install:append() {
    # CAN interface setup is handled by systemd service instead of this script
    rm -f ${D}${bindir}/lxa-iobus-can-setup
    install -D -m0644 ${UNPACKDIR}/environment ${D}${sysconfdir}/lxa-iobus/environment
    install -D -m0644 ${S}/contrib/systemd/lxa-iobus.service ${D}${systemd_system_unitdir}/lxa-iobus.service
}

FILES:${PN} += "${libdir}"

SYSTEMD_SERVICE:${PN} = "lxa-iobus.service"
