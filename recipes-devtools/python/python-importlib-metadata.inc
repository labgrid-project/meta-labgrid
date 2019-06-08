DESCRIPTION = "A library which provides an API for accessing an installed \
package’s metadata, such as its entry points or its top-level name"
HOMEPAGE = "https://importlib-metadata.readthedocs.io/en/latest/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e88ae122f3925d8bde8319060f2ddb8e"

FILESEXTRAPATHS_prepend := "${THISDIR}/python-importlib-metadata:"

SRC_URI += "file://0001-setup.cfg-Use-a-hardcoded-version-number.patch"

SRC_URI[md5sum] = "dda7b351e8fa12e169ce0b67bfe0be05"
SRC_URI[sha256sum] = "a9f185022cfa69e9ca5f7eabfd5a58b689894cb78a11e3c8c89398a8ccbb8e7f"

inherit pypi

PYPI_PACKAGE = "importlib_metadata"

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-zipp \
"

BBCLASSEXTEND = "native nativesdk"
