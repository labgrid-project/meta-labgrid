require python3-labgrid.inc

inherit pypi

SRC_URI[sha256sum] = "686695d3fa8c0ac0c9a6e6b42f9c8e9e92a9363c9d4945718e5fc21e431bd3d8"

SRC_URI += "file://0001-remote-client-Drop-exceptiongroup.patch"
