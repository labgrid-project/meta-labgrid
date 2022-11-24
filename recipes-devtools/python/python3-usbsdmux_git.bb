DESCRIPTION = "Control software for usb-sd-mux that switches a SD-Card between a Device Under Test (DUT) and a host PC."
HOMEPAGE = "https://github.com/linux-automation/usbsdmux"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = " \
    git://github.com/linux-automation/usbsdmux.git;protocol=https;branch=master \
    file://99-usbsdmux.rules \
    "

PV = "0.2.1+git${SRCPV}"
SRCREV = "c3eea7d86e8d0e9a43e36e55e7a175aa7736b8ea"

S = "${WORKDIR}/git"

DEPENDS += "python3-setuptools-scm-native"

inherit setuptools3

do_install:append() {
    install -D -m0644 ${WORKDIR}/99-usbsdmux.rules ${D}${sysconfdir}/udev/rules.d/99-usbsdmux.rules
}

FILES:${PN} += "${sysconfdir}"
