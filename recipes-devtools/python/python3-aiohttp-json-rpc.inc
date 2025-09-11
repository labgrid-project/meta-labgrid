SUMMARY = "json rpc for asyncio"
HOMEPAGE = "https://github.com/pengutronix/aiohttp-json-rpc/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=500d879cf7db09f86dc29654f8488e30"

RDEPENDS:${PN} = " \
    ${PYTHON_PN}-aiohttp \
"

inherit pypi setuptools3
