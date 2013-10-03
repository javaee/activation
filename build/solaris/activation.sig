//Java signature file
//date: Thu Apr 07 22:16:00 PDT 2005
//classpath: activation.jar
//package: javax


package javax.activation;

public class ActivationDataFlavor extends java.awt.datatransfer.DataFlavor {
	public ActivationDataFlavor(Class, String);
	public ActivationDataFlavor(Class, String, String);
	public ActivationDataFlavor(String, String);
	public boolean equals(java.awt.datatransfer.DataFlavor);
	public String getHumanPresentableName();
	public String getMimeType();
	public Class getRepresentationClass();
	public boolean isMimeTypeEqual(String);
	protected String normalizeMimeType(String);
	protected String normalizeMimeTypeParameter(String, String);
	public void setHumanPresentableName(String);
}

public class CommandInfo {
	public CommandInfo(String, String);
	public String getCommandClass();
	public String getCommandName();
	public Object getCommandObject(javax.activation.DataHandler, ClassLoader) throws java.io.IOException, ClassNotFoundException;
}

public abstract class CommandMap {
	public CommandMap();
	public abstract javax.activation.DataContentHandler createDataContentHandler(String);
	public javax.activation.DataContentHandler createDataContentHandler(String, javax.activation.DataSource);
	public abstract javax.activation.CommandInfo[] getAllCommands(String);
	public javax.activation.CommandInfo[] getAllCommands(String, javax.activation.DataSource);
	public abstract javax.activation.CommandInfo getCommand(String, String);
	public javax.activation.CommandInfo getCommand(String, String, javax.activation.DataSource);
	public static javax.activation.CommandMap getDefaultCommandMap();
	public String[] getMimeTypes();
	public abstract javax.activation.CommandInfo[] getPreferredCommands(String);
	public javax.activation.CommandInfo[] getPreferredCommands(String, javax.activation.DataSource);
	public static void setDefaultCommandMap(javax.activation.CommandMap);
}

public abstract interface CommandObject {
	public abstract void setCommandContext(String, javax.activation.DataHandler) throws java.io.IOException;
}

public abstract interface DataContentHandler {
	public abstract Object getContent(javax.activation.DataSource) throws java.io.IOException;
	public abstract Object getTransferData(java.awt.datatransfer.DataFlavor, javax.activation.DataSource) throws java.awt.datatransfer.UnsupportedFlavorException, java.io.IOException;
	public abstract java.awt.datatransfer.DataFlavor[] getTransferDataFlavors();
	public abstract void writeTo(Object, String, java.io.OutputStream) throws java.io.IOException;
}

public abstract interface DataContentHandlerFactory {
	public abstract javax.activation.DataContentHandler createDataContentHandler(String);
}

public class DataHandler implements java.awt.datatransfer.Transferable {
	public DataHandler(Object, String);
	public DataHandler(java.net.URL);
	public DataHandler(javax.activation.DataSource);
	public javax.activation.CommandInfo[] getAllCommands();
	public Object getBean(javax.activation.CommandInfo);
	public javax.activation.CommandInfo getCommand(String);
	public Object getContent() throws java.io.IOException;
	public String getContentType();
	public javax.activation.DataSource getDataSource();
	public java.io.InputStream getInputStream() throws java.io.IOException;
	public String getName();
	public java.io.OutputStream getOutputStream() throws java.io.IOException;
	public javax.activation.CommandInfo[] getPreferredCommands();
	public Object getTransferData(java.awt.datatransfer.DataFlavor) throws java.awt.datatransfer.UnsupportedFlavorException, java.io.IOException;
	public synchronized java.awt.datatransfer.DataFlavor[] getTransferDataFlavors();
	public boolean isDataFlavorSupported(java.awt.datatransfer.DataFlavor);
	public synchronized void setCommandMap(javax.activation.CommandMap);
	public static synchronized void setDataContentHandlerFactory(javax.activation.DataContentHandlerFactory);
	public void writeTo(java.io.OutputStream) throws java.io.IOException;
}

public abstract interface DataSource {
	public abstract String getContentType();
	public abstract java.io.InputStream getInputStream() throws java.io.IOException;
	public abstract String getName();
	public abstract java.io.OutputStream getOutputStream() throws java.io.IOException;
}

public class FileDataSource implements javax.activation.DataSource {
	public FileDataSource(java.io.File);
	public FileDataSource(String);
	public String getContentType();
	public java.io.File getFile();
	public java.io.InputStream getInputStream() throws java.io.IOException;
	public String getName();
	public java.io.OutputStream getOutputStream() throws java.io.IOException;
	public void setFileTypeMap(javax.activation.FileTypeMap);
}

public abstract class FileTypeMap {
	public FileTypeMap();
	public abstract String getContentType(java.io.File);
	public abstract String getContentType(String);
	public static javax.activation.FileTypeMap getDefaultFileTypeMap();
	public static void setDefaultFileTypeMap(javax.activation.FileTypeMap);
}

public class MailcapCommandMap extends javax.activation.CommandMap {
	public MailcapCommandMap();
	public MailcapCommandMap(java.io.InputStream);
	public MailcapCommandMap(String) throws java.io.IOException;
	public synchronized void addMailcap(String);
	public synchronized javax.activation.DataContentHandler createDataContentHandler(String);
	public synchronized javax.activation.CommandInfo[] getAllCommands(String);
	public synchronized javax.activation.CommandInfo getCommand(String, String);
	public synchronized String[] getMimeTypes();
	public synchronized String[] getNativeCommands(String);
	public synchronized javax.activation.CommandInfo[] getPreferredCommands(String);
}

public class MimeType implements java.io.Externalizable {
	public MimeType();
	public MimeType(String) throws javax.activation.MimeTypeParseException;
	public MimeType(String, String) throws javax.activation.MimeTypeParseException;
	public String getBaseType();
	public String getParameter(String);
	public javax.activation.MimeTypeParameterList getParameters();
	public String getPrimaryType();
	public String getSubType();
	public boolean match(String) throws javax.activation.MimeTypeParseException;
	public boolean match(javax.activation.MimeType);
	public void readExternal(java.io.ObjectInput) throws java.io.IOException, ClassNotFoundException;
	public void removeParameter(String);
	public void setParameter(String, String);
	public void setPrimaryType(String) throws javax.activation.MimeTypeParseException;
	public void setSubType(String) throws javax.activation.MimeTypeParseException;
	public String toString();
	public void writeExternal(java.io.ObjectOutput) throws java.io.IOException;
}

public class MimeTypeParameterList {
	public MimeTypeParameterList();
	public MimeTypeParameterList(String) throws javax.activation.MimeTypeParseException;
	public String get(String);
	public java.util.Enumeration getNames();
	public boolean isEmpty();
	protected void parse(String) throws javax.activation.MimeTypeParseException;
	public void remove(String);
	public void set(String, String);
	public int size();
	public String toString();
}

public class MimeTypeParseException extends Exception {
	public MimeTypeParseException();
	public MimeTypeParseException(String);
}

public class MimetypesFileTypeMap extends javax.activation.FileTypeMap {
	public MimetypesFileTypeMap();
	public MimetypesFileTypeMap(java.io.InputStream);
	public MimetypesFileTypeMap(String) throws java.io.IOException;
	public synchronized void addMimeTypes(String);
	public String getContentType(java.io.File);
	public synchronized String getContentType(String);
}

public class URLDataSource implements javax.activation.DataSource {
	public URLDataSource(java.net.URL);
	public String getContentType();
	public java.io.InputStream getInputStream() throws java.io.IOException;
	public String getName();
	public java.io.OutputStream getOutputStream() throws java.io.IOException;
	public java.net.URL getURL();
}

public class UnsupportedDataTypeException extends java.io.IOException {
	public UnsupportedDataTypeException();
	public UnsupportedDataTypeException(String);
}

//end of Java signature file
