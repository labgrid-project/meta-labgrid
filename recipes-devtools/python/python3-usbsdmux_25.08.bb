DESCRIPTION = "Control software for usb-sd-mux that switches a SD-Card between a Device Under Test (DUT) and a host PC."
HOMEPAGE = "https://github.com/linux-automation/usbsdmux"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "\
    file://LICENSES/CC0-1.0.txt;md5=65d3616852dbf7b1a6d4b53b00626032 \
    file://LICENSES/LGPL-2.1-or-later.txt;md5=4bf661c1e3793e55c8d1051bc5e0ae21 \
    "

SRC_URI = " \
    git://github.com/linux-automation/usbsdmux.git;protocol=https;branch=master \
    "

SRCREV = "dc8ea0ea05cd1cf02902fbfebf79061389a69097"

DEPENDS += "python3-setuptools-scm-native"

inherit python_setuptools_build_meta

do_install:append() {
    install -D -m0644 ${S}/contrib/udev/99-usbsdmux.rules ${D}${sysconfdir}/udev/rules.d/99-usbsdmux.rules
}

FILES:${PN} += "${sysconfdir}"
