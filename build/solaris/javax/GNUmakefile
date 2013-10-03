#
# @(#)GNUmakefile	1.1 99/03/06
#
# Makefile for building all of javax
#

BUILDDIR = ..
include $(BUILDDIR)/Platform.gmk

PRODUCT = sun

# Javadoc defines
DOCDIR = $(TOPDIR)/src/share/doc/api/javadocs
DOCPACKAGES =	javax.activation

include $(TOPDIR)/build/$(PLATFORM)/makefiles/Defs.gmk

SUBDIRS = activation

include $(TOPDIR)/build/$(PLATFORM)/makefiles/Subdirs.gmk

include $(TOPDIR)/build/$(PLATFORM)/makefiles/Project.gmk

clean ::
	rm -fr $(LIBDIR) $(BINDIR) $(CLASSBINDIR)

# for "docs" target (hack: set JDK to 1.2 so that newer javadoc is used)
JDK = /usr/local/java/jdk1.2/solaris/
JAVADOC_OPTS=	-J-Xmx32m
include $(TOPDIR)/build/$(PLATFORM)/makefiles/Docs.gmk

