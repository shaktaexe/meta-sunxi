DESCRIPTION = "ARM Trusted Firmware Allwinner"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://docs/license.rst;md5=b2c740efedc159745b9b31f88ff03dde"

SRC_URI = " \
    git://github.com/ARM-software/arm-trusted-firmware;nobranch=1;protocol=https \
    file://Makefile-link-with-z-noexecstack-no-warn-rwx-segment.patch \
"

SRCREV = "ba12668a65f9b10bc18f3b49a71999ed5d32714a"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

COMPATIBLE_MACHINE = "(sun50i|sun50i-h616)"

PLATFORM:sun50i = "sun50i_a64"
PLATFORM:sun50i-h616 = "sun50i_h616"

LDFLAGS[unexport] = "1"

do_compile() {
    oe_runmake -C ${S} BUILD_BASE=${B} \
      CROSS_COMPILE=${TARGET_PREFIX} \
      PLAT=${PLATFORM} \
      bl31 \
      all
}

do_install() {
    install -D -p -m 0644 ${B}/${PLATFORM}/release/bl31.bin ${DEPLOY_DIR_IMAGE}/bl31.bin
}
