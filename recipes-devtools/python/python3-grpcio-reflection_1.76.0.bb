DESCRIPTION = "Google gRPC reflection"
HOMEPAGE = "http://www.grpc.io/"
SECTION = "devel/python"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=7145f7cdd263359b62d342a02f005515"

PYPI_PACKAGE = "grpcio_reflection"

inherit pypi setuptools3

DEPENDS += "python3-grpcio"

SRC_URI[sha256sum] = "e0e7e49921c2ee951e5ddff0bdbacbd1ac1a70888beb61d567f3d01b799decb1"

RDEPENDS:${PN} = "python3-grpcio"

BBCLASSEXTEND = "native nativesdk"
