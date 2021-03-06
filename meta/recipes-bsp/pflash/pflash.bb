SUMMARY = "pflash firmware programming tool for OpenPower machines"
HOMEPAGE = "https://github.com/open-power"
SECTION = ""

LICENSE = "Apache-2.0"

SRCREV = "aa57046e6c908fdd87cf7a24239f33996c2df51f"
PV = "5.1.12+git${SRCPV}"
SRC_URI = "git://github.com/open-power/skiboot.git"
LIC_FILES_CHKSUM = "file://LICENCE;md5sum=3b83ef96387f14655fc854ddc3c6bd57"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} PFLASH_VERSION=${PV} V=1'

do_compile () {
        oe_runmake -C external/pflash all
}

do_install () {
        oe_runmake -C external/pflash install DESTDIR=${D}
}
