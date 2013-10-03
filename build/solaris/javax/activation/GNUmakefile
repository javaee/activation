#
# @(#)GNUmakefile	1.6 05/04/07
#
# Makefile for building all of javax.activation.*
#

BUILDDIR = ../..
include $(BUILDDIR)/Platform.gmk

PRODUCT = sun
PACKAGE = javax.activation

include $(TOPDIR)/build/$(PLATFORM)/makefiles/Defs.gmk

include $(MINCLUDES)javax_activation.jmk

all :: classes

clean clobber :: classes.clean

include $(BUILDDIR)/makefiles/Classes.gmk
