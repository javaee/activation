#
# VERSION @(#)Makefile	1.6 97/10/28
#

PLATFORM = win32
PACKAGE = javax.activation
PRODUCT = sun

#
# important locations
#
TOPDIR = ..\..
BUILD_DIR = $(TOPDIR)\build
PLATFORM_DIR = $(BUILD_DIR)\$(PLATFORM)
CLASS_DIR = $(PLATFORM_DIR)\classes
SRC_DIR = $(TOPDIR)\src\classes
LIB_DIR = $(PLATFORM_DIR)\lib
META_INF_DIR = $(PLATFORM_DIR)\classes\META-INF
SRC_LIB_DIR = $(TOPDIR)\src\lib

#
# Set JAVA_HOME to _JAVA_HOME if JDK_HOME isn't set. Otherwise, set
# it to JDK_HOME
#
_JAVA_HOME = C:\jdk
!IF "$(JDK_HOME)" == ""
JAVA_HOME = $(_JAVA_HOME)
!ELSE
JAVA_HOME = $(JDK_HOME)
!ENDIF

!if "$(OS)" == "Windows_NT"
DEL = del/f/q
DELTREE = rmdir/s/q
!else
DEL = deltree/y
DELTREE = deltree/y
!endif

#
# the commands to build with
#
JAVA = $(JAVA_HOME)\bin\java
JAVAC = $(JAVA_HOME)\bin\javac -J-mx32m
JAVADOC = $(JAVA_HOME)\bin\javadoc
STDCLASSPATH = $(JAVA_HOME)\classes;$(JAVA_HOME)\lib\classes.zip

#
# define the variables that specify the source files and class files
#
!include $(BUILD_DIR)\classes.mk

#
# the targets
#
jaf: classesdir $(JAVAX_CLASSES_LIST) $(COM_SUN_CLASSES_LIST)
	@echo Jarring...
	@md $(LIB_DIR)
	@md $(META_INF_DIR)
	@xcopy /f $(SRC_LIB_DIR)\mailcap $(META_INF_DIR)
	@xcopy /f $(SRC_LIB_DIR)\mimetypes $(META_INF_DIR)
	@cd $(CLASS_DIR)

	@jar cf ..\lib\jaf.jar javax com META-INF
	@cd ..

test: classesdir $(TEST_CLASSES_LIST)

classesdir:
	@md $(CLASS_DIR)

all: jaf test

demo: jaf $(DEMO_CLASSES_LIST)

javahome: 
	@echo JAVA_HOME is $(JAVA_HOME)
	@$(JAVA) -fullversion

clean:
	@echo Cleaning...
	@$(DELTREE) $(CLASS_DIR)
	@$(DELTREE) $(LIB_DIR)

#
# Build rules for converting .java files into .class files
# we have to define implicit rules for each directory since boneheaded
# nmake doesn't support static pattern rules =(
#
.SUFFIXES: .java .class

{$(SRC_DIR)\javax\activation}.java{$(CLASS_DIR)\javax\activation}.class :
	@echo Compiling $<...
	@$(JAVAC) -d $(CLASS_DIR) -classpath $(CLASS_DIR);$(STDCLASSPATH);$(SRC_DIR) $<
	@echo -----------------------

{$(SRC_DIR)\com\sun\activation\registries}.java{$(CLASS_DIR)\com\sun\activation\registries}.class :
	@echo Compiling $<...
	@$(JAVAC) -d $(CLASS_DIR) -classpath $(CLASS_DIR);$(STDCLASSPATH);$(SRC_DIR) $<
	@echo -----------------------

{$(SRC_DIR)\com\sun\activation\viewers}.java{$(CLASS_DIR)\com\sun\activation\viewers}.class :
	@echo Compiling $<...
	@$(JAVAC) -d $(CLASS_DIR) -classpath $(CLASS_DIR);$(STDCLASSPATH);$(SRC_DIR) $<
	@echo -----------------------

{$(SRC_DIR)\com\sun\activation\mime}.java{$(CLASS_DIR)\com\sun\activation\mime}.class :
	@echo Compiling $<...
	@$(JAVAC) -d $(CLASS_DIR) -classpath $(CLASS_DIR);$(STDCLASSPATH);$(SRC_DIR) $<
	@echo -----------------------

{$(SRC_DIR)\test}.java{$(CLASS_DIR)\test}.class :
	@echo Compiling $<...
	@$(JAVAC) -d $(CLASS_DIR) -classpath $(CLASS_DIR);$(STDCLASSPATH);$(SRC_DIR) $<
	@echo -----------------------
