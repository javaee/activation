#
# @(#)GNUmakefile	1.1 99/03/06
#
# Makefile for building all of com.sun.activation
#

BUILDDIR = ../../..
include $(BUILDDIR)/Platform.gmk

PRODUCT = sun

include $(TOPDIR)/build/$(PLATFORM)/makefiles/Defs.gmk

SUBDIRS = registries viewers

include $(TOPDIR)/build/$(PLATFORM)/makefiles/Subdirs.gmk

include $(TOPDIR)/build/$(PLATFORM)/makefiles/Project.gmk

clean ::
	rm -fr $(LIBDIR) $(BINDIR) $(CLASSBINDIR)
