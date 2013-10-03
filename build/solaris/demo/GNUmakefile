#
# @(#)GNUmakefile	1.2 07/05/15
#
# Makefile for building all of demo
#

BUILDDIR = ..
include $(BUILDDIR)/Platform.gmk

PRODUCT = sun

ALT_SRCDIR = demo
ALT_CLASSBINDIR = $(BUILDDIR)/demo_classes
DEPENDS = $(CLASSDIR)

include $(TOPDIR)/build/$(PLATFORM)/makefiles/Defs.gmk

include $(MINCLUDES)demo.jmk

all :: classes

clean clobber :: classes.clean

include $(BUILDDIR)/makefiles/Classes.gmk
