require python3-labgrid.inc

inherit pypi

SRC_URI[sha256sum] = "330e54c49f7660619ecaccbe72576ca548643fea1312d0f538fdedd73671c1b5"

SRC_URI += "file://0001-remote-client-Drop-exceptiongroup.patch"
