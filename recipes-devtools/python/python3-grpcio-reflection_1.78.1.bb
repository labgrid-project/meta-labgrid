DESCRIPTION = "Google gRPC reflection"
HOMEPAGE = "http://www.grpc.io/"
SECTION = "devel/python"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=6;endline=6;md5=0bcf70029ff7f40a132bf95381ee0b2d"

PYPI_PACKAGE = "grpcio_reflection"

inherit python_setuptools_build_meta pypi

DEPENDS += "python3-grpcio"

SRC_URI[sha256sum] = "224c0d604207954923fd6f8dbec541e0976a64ab1be65d2ee40844ce16c762ab"

RDEPENDS:${PN} = "python3-grpcio"

BBCLASSEXTEND = "native nativesdk"
