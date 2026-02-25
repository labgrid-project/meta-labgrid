DESCRIPTION = "Google gRPC channelz"
HOMEPAGE = "http://www.grpc.io/"
SECTION = "devel/python"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=6;endline=6;md5=0bcf70029ff7f40a132bf95381ee0b2d"

PYPI_PACKAGE = "grpcio_channelz"

inherit python_setuptools_build_meta pypi

DEPENDS += "python3-grpcio"

SRC_URI[sha256sum] = "e44fe0478d78b29075c6d258b8c5107619c06465c013ab1849e5bef493af153e"

RDEPENDS:${PN} = "python3-grpcio"

BBCLASSEXTEND = "native nativesdk"
