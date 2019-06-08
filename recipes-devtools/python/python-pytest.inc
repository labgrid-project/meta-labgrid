SUMMARY = "Simple powerful teting with python"
HOMEPAGE = "http://pytest.org"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=640061b8cee64b308a4d2f9f556c12f2"

SRC_URI[md5sum] = "0768a0a73ffd65b1a49f4a8f6cb461c5"
SRC_URI[sha256sum] = "bea27a646a3d74cbbcf8d3d4a06b2dfc336baf3dc2cc85cf70ad0157e73e8322"

FILESEXTRAPATHS_prepend := "${THISDIR}/python-pytest:"

SRC_URI += " \
    file://0001-setup.py-remove-the-setup_requires-for-setuptools-sc.patch \
    file://0002-setup.cfg-Use-a-hardcoded-version-number.patch \
"

inherit update-alternatives

RDEPENDS_${PN}_class-target += " \
    ${PYTHON_PN}-atomicwrites \
    ${PYTHON_PN}-attrs \
    ${PYTHON_PN}-debugger \
    ${PYTHON_PN}-doctest \
    ${PYTHON_PN}-importlib-metadata \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-more-itertools \
    ${PYTHON_PN}-packaging \
    ${PYTHON_PN}-pluggy \
    ${PYTHON_PN}-py \
    ${PYTHON_PN}-setuptools \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-wcwidth \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/python-pytest:"

ALTERNATIVE_${PN} += "py.test pytest"

NATIVE_LINK_NAME[pytest] = "${bindir}/pytest"
ALTERNATIVE_TARGET[pytest] = "${bindir}/pytest"

ALTERNATIVE_LINK_NAME[py.test] = "${bindir}/py.test"
ALTERNATIVE_TARGET[py.test] = "${bindir}/py.test"

BBCLASSEXTEND = "native nativesdk"
