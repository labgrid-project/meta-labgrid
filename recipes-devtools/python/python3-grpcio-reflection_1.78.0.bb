DESCRIPTION = "Google gRPC reflection"
HOMEPAGE = "http://www.grpc.io/"
SECTION = "devel/python"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=6;endline=6;md5=0bcf70029ff7f40a132bf95381ee0b2d"

PYPI_PACKAGE = "grpcio_reflection"

inherit pypi setuptools3

DEPENDS += "python3-grpcio"

SRC_URI[sha256sum] = "e6e60c0b85dbcdf963b4d4d150c0f1d238ba891d805b575c52c0365d07fc0c40"

RDEPENDS:${PN} = "python3-grpcio"

BBCLASSEXTEND = "native nativesdk"
