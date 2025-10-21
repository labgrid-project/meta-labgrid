DESCRIPTION = "Google gRPC channelz"
HOMEPAGE = "http://www.grpc.io/"
SECTION = "devel/python"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=7145f7cdd263359b62d342a02f005515"

PYPI_PACKAGE = "grpcio_channelz"

inherit pypi setuptools3

DEPENDS += "python3-grpcio"

SRC_URI[sha256sum] = "e0caa06d4de3eb62d3fdc54e5c9dc9003aa3ee21e9c50f5d3538aea854d276f2"

RDEPENDS:${PN} = "python3-grpcio"

BBCLASSEXTEND = "native nativesdk"
