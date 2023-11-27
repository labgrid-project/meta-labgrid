DESCRIPTION = "Control software for Linux Automation GmbH USB-Mux that enables automated testing of embedded USB devices."
HOMEPAGE = "https://github.com/linux-automation/usbmuxctl"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI[sha256sum] = "b7a9c7bf0645e0d2026fc63307a6724c24be6a33961f0f65cc313be7c8d45feb"

SRC_URI += " \
    file://99-usbmux.rules \
    "

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} = " \
    python3-pyusb \
    python3-termcolor \
"

inherit setuptools3 pypi

do_install:append() {
    install -D -m0644 ${WORKDIR}/99-usbmux.rules ${D}${sysconfdir}/udev/rules.d/99-usbmux.rules
}

FILES:${PN} += "${sysconfdir}"
