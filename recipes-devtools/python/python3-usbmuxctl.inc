DESCRIPTION = "Control software for Linux Automation GmbH USB-Mux that enables automated testing of embedded USB devices."
HOMEPAGE = "https://github.com/linux-automation/usbmuxctl"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} = " \
    python3-pyusb \
    python3-termcolor \
"

inherit python_setuptools_build_meta pypi

do_install:append() {
    install -D -m0644 ${S}/contrib/udev/99-usbmux.rules ${D}${sysconfdir}/udev/rules.d/99-usbmux.rules
}

FILES:${PN} += "${sysconfdir}"
