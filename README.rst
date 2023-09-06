|MIT| |Matrix|

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


I. Adding the labgrid Layer to Your Build
=========================================

Run ``bitbake-layers add-layer meta-labgrid``.


II. Adding the labgrid exporter to Your Device
==============================================

To prepare your device for using the labgrid exporter,
you have to follow at least the following steps:

1. Add the `labgrid` package to your systems image recipe::

    IMAGE_INSTALL:append = " python3-labgrid"

2. Build the rootfs for your device::

    bitbake my-machine-recipe

III. Contributing
=================

To contribute to labgrid itself or to report bugs in labgrid, see
`<https://labgrid.readthedocs.io/en/latest/development.html#contributing>`_.

To report meta-labgrid bugs, file a new `issue
<https://github.com/labgrid-project/meta-labgrid/issues>`_ on GitHub.

To fix meta-labgrid bugs, bump recipes or to add new features, open a `pull
request <https://github.com/labgrid-project/meta-labgrid/pulls>`_ on
GitHub.

Add a ``Signed-off-by`` line to your commits according to labgrid's
`Developer’s Certificate of Origin
<https://labgrid.readthedocs.io/en/latest/development.html#developer-s-certificate-of-origin>`_.


IV. References
==============

[1] Labgrid documentation http://labgrid.readthedocs.io/en/latest/

.. |MIT| image:: https://img.shields.io/badge/license-MIT-blue.svg
   :target: https://raw.githubusercontent.com/labgrid-project/meta-labgrid/master/COPYING.MIT
.. |Matrix| image:: https://img.shields.io/matrix/labgrid:matrix.org?label=matrix%20chat
   :target: https://app.element.io/#/room/#labgrid:matrix.org
