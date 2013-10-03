package	test;

import	java.beans.*;
import	java.io.*;
import	java.net.*;
import  javax.activation.*;

public class	DataHandlerTest
{

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
		else if(inArguments[0].equals("url"))
		{
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
				
	Object lBean;
	Class lBeanClass;
	String lType = inDataHandler.getContentType();
	
	//	grab the preferred commands and enumerate them
	System.out.println("Preferred commands:");
	CommandInfo[] lPreferredCmds = inDataHandler.getPreferredCommands();
	for(int lCmdIndex = 0; lCmdIndex < lPreferredCmds.length; ++lCmdIndex)
	{
		lBean = inDataHandler.getBean(lPreferredCmds[lCmdIndex]);
		if (lBean != null)
		{
		    lBeanClass = lBean.getClass();
		    System.out.println("    " + lBeanClass.getName());
		}
		else
		{
		    System.out.print("No Bean for command " + lPreferredCmds[lCmdIndex].getCommandName());
		}
	}

	//	grab all commands and enumerate them
	System.out.println("All commands:");
	CommandInfo[] lAllCmds = inDataHandler.getAllCommands();
	for(int lCmdIndex = 0; lCmdIndex < lAllCmds.length; ++lCmdIndex)
	{
		lBean = inDataHandler.getBean(lAllCmds[lCmdIndex]);
		if (lBean != null)
		{
		    lBeanClass = lBean.getClass();
		    System.out.println("    " + lBeanClass.getName());
		}
		else
		{
		    System.out.print("No Bean for command " + lAllCmds[lCmdIndex].getCommandName());
		}
	}
	
	//	grab the commands for the default three verbs view, edit & print
	System.out.println("View:");
	CommandInfo lCmd = inDataHandler.getCommand("view");
	if(lCmd != null)
	{
		lBean = inDataHandler.getBean(lCmd);
		if (lBean != null)
		{
		    lBeanClass = lBean.getClass();
		    System.out.println("    " + lBeanClass.getName());
		}
		else
		{
		    System.out.print("No Bean for command " + lCmd.getCommandName());
		}
	}
	else
	{
		System.out.println("    None");
	}
	
	System.out.println("Edit:");
	lCmd = inDataHandler.getCommand("edit");
	if(lCmd != null)
	{
		lBean = inDataHandler.getBean(lCmd);
		if (lBean != null)
		{
		    lBeanClass = lBean.getClass();
		    System.out.println("    " + lBeanClass.getName());
		}
		else
		{
		    System.out.print("No Bean for command " + lCmd.getCommandName());
		}
	}
	else
	{
		System.out.println("    None");
	}
	
	System.out.println("Print:");
	lCmd = inDataHandler.getCommand("print");
	if(lCmd != null)
	{
		lBean = inDataHandler.getBean(lCmd);
		if (lBean != null)
		{
		    lBeanClass = lBean.getClass();
		    System.out.println("    " + lBeanClass.getName());
		}
		else
		{
		    System.out.print("No Bean for command " + lCmd.getCommandName());
		}
	}
	else
	{
		System.out.println("    None");
	}
	
	//	read some data

	InputStream lInputStream = null;
	try {
	    lInputStream= inDataHandler.getInputStream();
	} catch (Exception e) {
	    System.out.println("ERROR: Caught an exception: " + e);
	}
	System.out.print("Byte 0: ");
	System.out.println(lInputStream.read());
	System.out.print("Byte 1: ");
	System.out.println(lInputStream.read());
	System.out.print("Byte 2: ");
	System.out.println(lInputStream.read());
	System.out.print("Byte 3: ");
	System.out.println(lInputStream.read());
	
	System.out.println("");
}

}
