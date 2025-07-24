DESCRIPTION = "Control Gembird SIS-PM programmable power outlet strips"
HOMEPAGE = "http://sispmctl.sourceforge.net/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
DEPENDS = "libusb"

inherit autotools pkgconfig

PACKAGECONFIG[web] = "--disable-webless,--enable-webless,"

SRC_URI = "https://sourceforge.net/projects/sispmctl/files/sispmctl/sispmctl-${PV}/sispmctl-${PV}.tar.gz"

SRC_URI[sha256sum] = "e757863a4838da6e1ca72a57adc5aca6fc47ffbddc72a69052d8abd743d57082"
