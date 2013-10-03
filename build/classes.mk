#
# VERSION: @(#)classes.mk	1.12 97/12/02
# this file defines the following Makefile variables:
# SRCS == a space separated list of full pathes to the source files
# CLASSES == a space separated list of the full pathes to the class files
#

JAVAX_SRCS = \
$(SRC_DIR)/javax/activation/MailcapCommandMap.java \
$(SRC_DIR)/javax/activation/CommandMap.java \
$(SRC_DIR)/javax/activation/CommandObject.java \
$(SRC_DIR)/javax/activation/CommandInfo.java \
$(SRC_DIR)/javax/activation/MimeType.java \
$(SRC_DIR)/javax/activation/MimeTypeParameterList.java \
$(SRC_DIR)/javax/activation/MimeTypeParseException.java \
$(SRC_DIR)/javax/activation/ActivationDataFlavor.java \
$(SRC_DIR)/javax/activation/DataContentHandler.java \
$(SRC_DIR)/javax/activation/DataContentHandlerFactory.java \
$(SRC_DIR)/javax/activation/UnsupportedDataTypeException.java \
$(SRC_DIR)/javax/activation/DataHandler.java \
$(SRC_DIR)/javax/activation/DataSource.java \
$(SRC_DIR)/javax/activation/URLDataSource.java \
$(SRC_DIR)/javax/activation/FileTypeMap.java \
$(SRC_DIR)/javax/activation/MimetypesFileTypeMap.java \
$(SRC_DIR)/javax/activation/FileDataSource.java 

COM_SUN_SRCS = \
$(SRC_DIR)/com/sun/activation/registries/MailcapEntry.java \
$(SRC_DIR)/com/sun/activation/registries/MailcapFile.java  \
$(SRC_DIR)/com/sun/activation/registries/MimeTypeEntry.java \
$(SRC_DIR)/com/sun/activation/registries/MimeTypeFile.java \
$(SRC_DIR)/com/sun/activation/viewers/ImageViewer.java \
$(SRC_DIR)/com/sun/activation/viewers/ImageViewerCanvas.java \
$(SRC_DIR)/com/sun/activation/viewers/TextEditor.java \
$(SRC_DIR)/com/sun/activation/viewers/TextViewer.java \
$(SRC_DIR)/com/sun/activation/registries/MailcapTokenizer.java \
$(SRC_DIR)/com/sun/activation/registries/MailcapParseException.java

TEST_SRCS = \
$(SRC_DIR)/test/AppletTest.java \
$(SRC_DIR)/test/CLTest.java \
$(SRC_DIR)/test/CommandMapTest.java \
$(SRC_DIR)/test/DHTransferableTest.java \
$(SRC_DIR)/test/DSWriteTest.java \
$(SRC_DIR)/test/DataHandlerTest.java \
$(SRC_DIR)/test/DataSourceTest.java \
$(SRC_DIR)/test/SerMaker.java \
$(SRC_DIR)/test/SerMaker11.java \
$(SRC_DIR)/test/SerReader.java \
$(SRC_DIR)/test/SerReader11.java 

DEMO_SRCS = \
$(SRC_DIR)/demo/PrefTest.java \
$(SRC_DIR)/demo/MikeTest.java \
$(SRC_DIR)/demo/FileView.java \
$(SRC_DIR)/demo/MCTest.java \
$(SRC_DIR)/demo/CompViewer.java \
$(SRC_DIR)/demo/JAFApp.java \
$(SRC_DIR)/demo/SimpleDCH.java \
$(SRC_DIR)/demo/MTest.java \
$(SRC_DIR)/demo/PlainDCH.java \
$(SRC_DIR)/demo/DHURL.java \
$(SRC_DIR)/demo/TextInternalizer.java \
$(SRC_DIR)/demo/DCHTest2.java \
$(SRC_DIR)/demo/ODCHTest.java \
$(SRC_DIR)/demo/DCHTest.java

JAVAX_CLASSES_LIST = \
$(CLASS_DIR)/javax/activation/DataSource.class \
$(CLASS_DIR)/javax/activation/URLDataSource.class \
$(CLASS_DIR)/javax/activation/MailcapCommandMap.class \
$(CLASS_DIR)/javax/activation/CommandMap.class \
$(CLASS_DIR)/javax/activation/CommandObject.class \
$(CLASS_DIR)/javax/activation/CommandInfo.class \
$(CLASS_DIR)/javax/activation/MimeType.class \
$(CLASS_DIR)/javax/activation/MimeTypeParameterList.class \
$(CLASS_DIR)/javax/activation/MimeTypeParseException.class \
$(CLASS_DIR)/javax/activation/ActivationDataFlavor.class \
$(CLASS_DIR)/javax/activation/DataContentHandler.class \
$(CLASS_DIR)/javax/activation/DataContentHandlerFactory.class \
$(CLASS_DIR)/javax/activation/UnsupportedDataTypeException.class \
$(CLASS_DIR)/javax/activation/DataHandler.class \
$(CLASS_DIR)/javax/activation/FileTypeMap.class \
$(CLASS_DIR)/javax/activation/MimetypesFileTypeMap.class \
$(CLASS_DIR)/javax/activation/FileDataSource.class 

COM_SUN_CLASSES_LIST = \
$(CLASS_DIR)/com/sun/activation/registries/MailcapEntry.class \
$(CLASS_DIR)/com/sun/activation/registries/MailcapFile.class  \
$(CLASS_DIR)/com/sun/activation/registries/MimeTypeEntry.class \
$(CLASS_DIR)/com/sun/activation/registries/MimeTypeFile.class \
$(CLASS_DIR)/com/sun/activation/viewers/ImageViewer.class \
$(CLASS_DIR)/com/sun/activation/viewers/ImageViewerCanvas.class \
$(CLASS_DIR)/com/sun/activation/viewers/TextEditor.class \
$(CLASS_DIR)/com/sun/activation/viewers/TextViewer.class \
$(CLASS_DIR)/com/sun/activation/registries/MailcapTokenizer.class \
$(CLASS_DIR)/com/sun/activation/registries/MailcapParseException.class

# Tests that only work on JDK 1.2...
# $(CLASS_DIR)/test/CLTest.class \

TEST_CLASSES_LIST = \
$(CLASS_DIR)/test/AppletTest.class \
$(CLASS_DIR)/test/CommandMapTest.class \
$(CLASS_DIR)/test/DHTransferableTest.class \
$(CLASS_DIR)/test/DSWriteTest.class \
$(CLASS_DIR)/test/DataHandlerTest.class \
$(CLASS_DIR)/test/DataSourceTest.class \
$(CLASS_DIR)/test/SerMaker.class \
$(CLASS_DIR)/test/SerMaker11.class \
$(CLASS_DIR)/test/SerReader.class \
$(CLASS_DIR)/test/SerReader11.class 

DEMO_CLASSES_LIST = \
$(CLASS_DIR)/demo/MikeTest.class \
$(CLASS_DIR)/demo/PrefTest.class \
$(CLASS_DIR)/demo/FileView.class \
$(CLASS_DIR)/demo/MCTest.class \
$(CLASS_DIR)/demo/CompViewer.class \
$(CLASS_DIR)/demo/JAFApp.class \
$(CLASS_DIR)/demo/SimpleDCF.class \
$(CLASS_DIR)/demo/TextInternalizer.class \
$(CLASS_DIR)/demo/MTest.class \
$(CLASS_DIR)/demo/DHURL.class \
$(CLASS_DIR)/demo/PlainDCH.class \
$(CLASS_DIR)/demo/DCHTest2.class \
$(CLASS_DIR)/demo/ODCHTest.class \
$(CLASS_DIR)/demo/DCHTest.class
