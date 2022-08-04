SECTION = "kernel"
LICENSE = "GPLv2"

inherit kernel

DESCRIPTION = "Linux kernel for Allwinner H616 processor"

COMPATIBLE_MACHINE = "(sun50i-h616)"

SRCREV = "c465e81f8859832ee06c97d1b8f70dbfdced1c23"

SRC_URI += "git://github.com/apritzel/linux.git;branch=h616-v13;protocol=https \
        "
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

S = "${WORKDIR}/git"

KMACHINE ?= "${MACHINE}"
KCONFIG_MODE ?= "alldefconfig"

