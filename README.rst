The meta-labgrid layer provides support for integrating the labgrid exporter
into your device.

Please see the corresponding sections below for details.


Dependencies
============

This layer depends on::

  URI: git://git.openembedded.org/bitbake
  branch: master

  URI: git://git.openembedded.org/openembedded-core
  layers: meta
  branch: master

  URI: git://git.openembedded.org/meta-openembedded
  layers: meta-python
  branch: master


Patches
=======

Please submit patches via GitHub pull request on:
https://github.com/labgrid-project/meta-labgrid

Maintainers:

- Enrico Jörns <e.joerns@pengutronix.de>
- Rouven Czerwinski <r.czerwinski@pengutronix.de>


Table of Contents
=================

 I. Adding the labgrid layer to your build
 II. Building labgrid exporter
 III. References


I. Adding the labgrid Layer to Your Build
=========================================

In order to use this layer, you need to make the build system aware of
it.

Assuming the labgrid layer exists at the top-level of your
yocto build tree, you can add it to the build system by adding the
location of the labgrid layer to bblayers.conf, along with any
other layers needed. e.g.::

  BBLAYERS ?= " \
    /path/to/yocto/meta \
    /path/to/yocto/meta-poky \
    /path/to/yocto/meta-yocto-bsp \
    /path/to/yocto/meta-openembedded/meta-python \
    /path/to/yocto/meta-labgrid \
    "



II. Adding the labgrid exporter to Your Device
==============================================

To prepare your device for using the labgrid exporter,
you have to follow at least the following steps:

1. Add the `labgrid` package to your systems image recipe::

    IMAGE_INSTALL:append = " python3-labgrid"

2. Build the rootfs for your device::

    bitbake my-machine-recipe


III. References
===============

[1] Labgrid documentation http://labgrid.readthedocs.io/en/latest/
