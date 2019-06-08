SUMMARY = "https://github.com/jaraco/zipp"
HOMEPAGE = "A pathlib-compatible Zipfile object wrapper. A backport of the Path object."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a33f38bbf47d48c70fe0d40e5f77498e"

SRC_URI[md5sum] = "45286cd2f2e0c3423b4e18a863d3b84d"
SRC_URI[sha256sum] = "ca943a7e809cc12257001ccfb99e3563da9af99d52f261725e96dfe0f9275bc3"

FILESEXTRAPATHS_prepend := "${THISDIR}/python-zipp:"

SRC_URI += " \
    file://0001-setup.py-remove-the-setup_requires-for-setuptools-sc.patch \
    file://0002-setup.cfg-Use-a-hardcoded-version-number.patch \
"

inherit pypi

BBCLASSEXTEND = "native nativesdk"
