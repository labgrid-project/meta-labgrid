SUMMARY = "jinja2 template renderer for aiohttp.web (http server for asyncio)"
HOMEPAGE = "https://github.com/aio-libs/aiohttp_jinja2/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=511145a8d0be7810f7edde87ec055a9b"

inherit pypi

RDEPENDS_${PN} = " \
    ${PYTHON_PN}-jinja2 (>=2.7) \
    ${PYTHON_PN}-aiohttp (>=0.20) \
"

