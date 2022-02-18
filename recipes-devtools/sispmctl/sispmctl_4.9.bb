DESCRIPTION = "Control Gembird SIS-PM programmable power outlet strips"
HOMEPAGE = "http://sispmctl.sourceforge.net/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
DEPENDS = "libusb"

inherit autotools pkgconfig

PACKAGECONFIG[web] = "--disable-webless,--enable-webless,"

SRC_URI = "https://sourceforge.net/projects/sispmctl/files/sispmctl/sispmctl-${PV}/sispmctl-${PV}.tar.gz"

SRC_URI[sha256sum] = "6a9ec7125e8c01bb45d4a3b56f07fb41fc437020c8dcd8c0f29ebb98dc55a647"
