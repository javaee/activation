package	test;

import	java.beans.*;
import	java.io.*;
import	java.net.*;
import	java.awt.datatransfer.*;
import  javax.activation.*;

public class	DHTransferableTest
{

public static final DataFlavor	sImageJPEGFlavor = new DataFlavor("image/jpeg", "JPEG image");
public static final DataFlavor	sImageGIFFlavor = new DataFlavor("image/gif", "GIF image");
public static final DataFlavor	sTextFlavor = new DataFlavor("text/*", "text");
public static final DataFlavor	sTextPlainFlavor = new DataFlavor("text/plain", "plain text");
public static final DataFlavor	sTextHTMLFlavor = new DataFlavor("text/html", "HTML document");

public static void	main(String[] inArguments) throws MalformedURLException, IOException
{
	DataHandler lDataHandler;
	
	if(inArguments.length >= 2)
	{
		if(inArguments[0].equals("file"))
		{
			for(int lIndex = 1; lIndex < inArguments.length; ++lIndex)
			{
				processDataHandler(new DataHandler(new FileDataSource(new File(inArguments[lIndex]))));
			}
		}
		else if(inArguments[0].equals("url")) {
		    System.out.println("URL not supported...");
		    // 			for(int lIndex = 1; lIndex < inArguments.length; ++lIndex)
		    // 			{
		    // 				processDataHandler(new URL(inArguments[lIndex]));
		    // 			}
		}
	}
	else
	{
		System.out.println("usage: DataHandlerTest <sourcetype> <sources>");
	}
}

private static void	processDataHandler(DataHandler inDataHandler) throws IOException
{
	System.out.println("Name: " + inDataHandler.getName());
	System.out.println("Type: " + inDataHandler.getContentType());
	
	//	find out what flavors the handler thinks are supported
	System.out.println("Says it supports:");
	DataFlavor[] lFlavors = inDataHandler.getTransferDataFlavors();
	for(int lIndex = 0; lIndex < lFlavors.length; ++lIndex)
	{
		System.out.println("    " + lFlavors[lIndex].getHumanPresentableName() + " (" + lFlavors[lIndex].getMimeType() + ")");
	}
	
	//	now query to see what of our basic flavors are supported
	queryFlavor(inDataHandler, DataFlavor.plainTextFlavor);
	queryFlavor(inDataHandler, DataFlavor.stringFlavor);
	queryFlavor(inDataHandler, sImageJPEGFlavor);
	queryFlavor(inDataHandler, sImageGIFFlavor);
	queryFlavor(inDataHandler, sTextFlavor);
	queryFlavor(inDataHandler, sTextPlainFlavor);
	queryFlavor(inDataHandler, sTextHTMLFlavor);
	
	System.out.println("");
}

private static void	queryFlavor(DataHandler inDataHandler, DataFlavor inFlavor)
{
	
	if(inDataHandler.isDataFlavorSupported(inFlavor))
	{
		System.out.print("Supports ");
	}
	else
	{
		System.out.print("Doesn't support ");
	}
	System.out.println(inFlavor.getHumanPresentableName() + " (" + inFlavor.getMimeType() + ")");
}

}
