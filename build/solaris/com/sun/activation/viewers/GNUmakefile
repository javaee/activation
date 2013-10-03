#
# @(#)GNUmakefile	1.1 99/03/06
#
# Makefile for building all of com.sun.activation.viewers
#

BUILDDIR = ../../../..
include $(BUILDDIR)/Platform.gmk

PRODUCT = sun
PACKAGE = com.sun.activation.viewers

include $(TOPDIR)/build/$(PLATFORM)/makefiles/Defs.gmk

default: all

include $(MINCLUDES)com_sun_activation_viewers.jmk
include $(BUILDDIR)/makefiles/Classes.gmk

all: classes

clean clobber :: classes.clean


