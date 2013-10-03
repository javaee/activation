#
# @(#)GNUmakefile	1.4 05/04/07
#
# Makefile for building all of com.sun.mail.registries
#

BUILDDIR = ../../../..
include $(BUILDDIR)/Platform.gmk

PRODUCT = sun
PACKAGE = com.sun.activation.registries

include $(TOPDIR)/build/$(PLATFORM)/makefiles/Defs.gmk

default: all

include $(MINCLUDES)com_sun_activation_registries.jmk
include $(BUILDDIR)/makefiles/Classes.gmk

all: classes

clean clobber :: classes.clean


