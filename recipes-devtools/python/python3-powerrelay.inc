DESCRIPTION = "REST API to control GPIO chips"
HOMEPAGE = "https://github.com/prevas-dk/labgrid-powerrelay"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=20796caa814f193af92c180d146bb7ec"

RDEPENDS:${PN} = " \
    python3-click \
    python3-aiohttp \
    python3-trafaret \
    python3-trafaret-config \
    python3-aiohttp-jinja2 \
    python3-yarl \
    python3-multidict \
"

SRC_URI = " \
    git://github.com/prevas-dk/labgrid-powerrelay.git;protocol=https;branch=${SRCBRANCH} \
    file://labgrid-powerrelay.service \
    "

DEPENDS += "${PYTHON_PN}-pytest-runner-native"

inherit setuptools3 systemd

SYSTEMD_SERVICE:${PN} = "labgrid-powerrelay.service"

do_install:append() {
    rm -rf "${D}${datadir}"
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/labgrid-powerrelay.service ${D}${systemd_system_unitdir}/
}

FILES:${PN} += "${systemd_system_unitdir}"
