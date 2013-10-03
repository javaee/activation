#
# @(#)GNUmakefile	1.24 12/05/02
#
# Makefile for building all of JAF
#
# Targets and their description:
#
#	all
#		builds everything, javax, com, demo
#
#	jar
#		creates the activation.jar file
#
#	jar_all
#		first makes "all", then makes "jar" of *all* class files
#
#	install
#		creates a jar file that contains only
#		the packages we ship.
#
#	project
#		creates all the JavaWorkShop project files
#
#	release
#		removes everything (realclean) then
#		creates the release zip file that includes everything
#		that is shipped in the jaf.zip file
#	
#	docs
#		builds javadocs
#
#	clean
#		removes all the class files and binaries
#	
#	realclean
#		clean + removes activation.jar & jaf.zip

BUILDDIR = .
include $(BUILDDIR)/Platform.gmk

PRODUCT = sun

include $(TOPDIR)/build/$(PLATFORM)/makefiles/Defs.gmk

ZIP = zip

LIBSRC = $(TOPDIR)/src/share/lib

JAF_RELEASE = 1.1.1
JAF_RELEASEB = $(shell echo $(JAF_RELEASE) | tr '.' '_')
#JAF_RELEASEDIR  = $(BUILDDIR)/jaf-$(JAF_RELEASE)
JAF_RELEASEDIR  = jaf-$(JAF_RELEASE)
JAF_RELEASEFILE = $(RELEASEDIR)/jaf$(JAF_RELEASEB).zip

# specs
SPEC_DIR = $(TOPDIR)/src/share/doc/spec
RELEASE_SPECS = $(SPEC_DIR)/JAF-1.1.ps $(SPEC_DIR)/JAF-1.1.pdf \
	$(SPEC_DIR)/JAF-1.1-changes.txt

SUBDIRS = javax com demo META-INF

include $(TOPDIR)/build/$(PLATFORM)/makefiles/Subdirs.gmk

include $(TOPDIR)/build/$(PLATFORM)/makefiles/Project.gmk

jar ::
	@echo Jarring ...
	@sed -e 's"%RELEASE%"$(JAF_RELEASE)"' < $(LIBSRC)/jaf.mf \
							> classes/jaf.mf
	@cd classes; $(JAR) cfm ../activation.jar jaf.mf META-INF javax com

jar_all :: all jar

install :: jar sigtest

# generate a new signature file
siggen ::
	sh siggen -in activation.jar -package javax -out activation.sig

# test that API hasn't changed
sigtest ::
	sh sigtest -base activation.sig -test activation.jar -package javax \
		-out report.out -check bincomp

# Javadoc defines
DOCDIR = $(TOPDIR)/src/share/doc/api/javadocs
DOCPACKAGES =	javax.activation
DOCFILES = \
	src/share/classes/javax/activation
DOCFILESEX = \
	src/share/classes/javax/activation/SecuritySupport.java

JAVADOC_OPTS=	-J-Xmx32m
TITLE="JavaBeans Activation Framework API documentation"

# XXX - Would like to use standard "docs" rule but we need to do
#	some special things here.  In order to generate javadocs
#	for only the limited set of classes listed in DOCFILES,
#	we have to copy all those files to a temporary directory
#	and run javadoc against that directory.

JAVADOC_OPTS += -use -splitIndex -windowtitle $(TITLE) -doctitle $(TITLE)

docs:
	rm -rf $(DOCDIR)
	mkdir -p $(DOCDIR)
	mkdir $(DOCDIR)/tmp
	(cd $(TOPDIR); tar cFFf - $(DOCFILES)) | (cd $(DOCDIR)/tmp; tar xf -)
	(cd $(DOCDIR)/tmp; rm -f $(DOCFILESEX))
	$(JAVADOC) $(JAVADOC_OPTS) -d $(DOCDIR) \
		-sourcepath $(DOCDIR)/tmp/src/share/classes \
		-classpath $(CLASSBINDIR):$(DEPENDS) $(DOCPACKAGES)
	rm -rf $(DOCDIR)/tmp

realclean :: clean
	@rm -f activation.jar $(JAF_RELEASEFILE)

# The "release" target is ugly-ish. Should clean up later.
release :: realclean all install docs releasezip

releasezip:
	@echo Making release ...
	@rm -rf $(JAF_RELEASEFILE) $(JAF_RELEASEDIR)
	@[ -d $(RELEASEDIR) ] || mkdir $(RELEASEDIR)
	@mkdir $(JAF_RELEASEDIR)
	@mkdir $(JAF_RELEASEDIR)/docs
	@mkdir $(JAF_RELEASEDIR)/docs/javadocs
	@mkdir -p $(JAF_RELEASEDIR)/demo
	@cp activation.jar $(JAF_RELEASEDIR)
	@#cp $(TOPDIR)/src/share/doc/release/CHANGES.txt $(RELEASEDIR)
	@rm -f $(RELEASEDIR)/README.txt
	@cp $(TOPDIR)/src/share/doc/release/README.txt $(RELEASEDIR)
	@rm -f $(RELEASEDIR)/LICENSE.txt
	@cp $(TOPDIR)/src/share/doc/release/LICENSE.txt $(RELEASEDIR)
	@rm -f $(RELEASEDIR)/distributionREADME.txt
	@cp $(TOPDIR)/src/share/doc/release/distributionREADME.txt $(RELEASEDIR)
	@rm -f $(RELEASEDIR)/RELNOTES.txt
	@cp -r $(TOPDIR)/src/share/doc/api/javadocs $(RELEASEDIR)
	@#cp $(TOPDIR)/src/share/doc/release/CHANGES.txt $(JAF_RELEASEDIR)
	@cp $(TOPDIR)/src/share/doc/release/README.txt $(JAF_RELEASEDIR)
	@cp $(TOPDIR)/src/share/doc/release/LICENSE.txt $(JAF_RELEASEDIR)
	@cp $(TOPDIR)/src/share/doc/release/distributionREADME.txt $(JAF_RELEASEDIR)
	@cp $(TOPDIR)/src/share/doc/release/RELNOTES.txt $(JAF_RELEASEDIR)
	@cp $(TOPDIR)/src/share/classes/demo/*.java $(JAF_RELEASEDIR)/demo
	@#cp $(TOPDIR)/src/share/classes/demo/README.txt $(JAF_RELEASEDIR)/demo
	@cp -r $(TOPDIR)/src/share/doc/api/javadocs $(JAF_RELEASEDIR)/docs/
	@for i in $(RELEASE_SPECS); do \
		if [ -f $$i ]; then \
			file=`basename $$i`; \
			rm -f $(RELEASEDIR)/$$file; \
			cp $$i $(RELEASEDIR); \
			cp $$i $(JAF_RELEASEDIR)/docs; \
		fi \
	done
	@$(ZIP) -r $(JAF_RELEASEFILE) $(JAF_RELEASEDIR)
	@rm -rf $(JAF_RELEASEDIR)
	@echo Done Making release
