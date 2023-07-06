DESCRIPTION = "Control Gembird SIS-PM programmable power outlet strips"
HOMEPAGE = "http://sispmctl.sourceforge.net/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
DEPENDS = "libusb"

inherit autotools pkgconfig

PACKAGECONFIG[web] = "--disable-webless,--enable-webless,"

SRC_URI = "https://sourceforge.net/projects/sispmctl/files/sispmctl/sispmctl-${PV}/sispmctl-${PV}.tar.gz"

SRC_URI[sha256sum] = "74b94a3710046b15070c7311f0cacb81554c86b4227719cc2733cb96c7052578"
