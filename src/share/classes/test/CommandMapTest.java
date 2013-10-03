package	test;

import	java.beans.*;
import	java.io.*;
import	java.net.*;
import  javax.activation.*;
public class	CommandMapTest
{

public static void	main(String[] inArguments) throws MalformedURLException, IOException
{
	CommandMap lCommandMap = CommandMap.getDefaultCommandMap();
	
	if(inArguments.length >= 2)
	{
		if(inArguments[0].equals("file"))
		{
			for(int lIndex = 1; lIndex < inArguments.length; ++lIndex)
			{
				File lFile = new File(inArguments[lIndex]);
				FileDataSource lFileSource = new FileDataSource(lFile);
				DataHandler ldh = new DataHandler(lFileSource);
				
				System.out.println("Name: " + lFileSource.getName());
				
				String lMIMEType = lFileSource.getContentType();
				System.out.println("Type: " + lFileSource.getContentType());
				
				processType(lCommandMap, lMIMEType, ldh);
				
				System.out.println("");
			}
		}
		else if(inArguments[0].equals("url"))
		{

		    System.out.println("URL not supported...");
// 			for(int lIndex = 1; lIndex < inArguments.length; ++lIndex)
// 			{
// 				URL lURL = new URL(inArguments[lIndex]);
// 				URLConnection lURLSource = lURL.openConnection();
				
// 				lURLSource.connect();
// 				System.out.println("Name: " + lURLSource.getName());
				
// 				String lMIMEType = lURLSource.getContentType();
// 				System.out.println("Type: " + lURLSource.getContentType());
				
// 				processType(lCommandMap, lMIMEType);
				
// 				System.out.println("");
// 			}
		}
	}
	else
	{
		System.out.println("usage: CommandMapTest <sourcetype> <sources>");
	}
}

// MH we now passed in a dh, currently there's no acccessor for CommandInfo.className. 
// so use dh.getBean().getClass().getClassName().  if/when there is an accessor just do:
// System.out.println("    " + lPreferredCmds[lCmdIndex].getClassName());
private static void	processType(CommandMap inCmdMap, String inType, DataHandler dh)
{
	Object lBean;
	Class lBeanClass;
	
	//	grab the preferred commands and enumerate them
	System.out.println("Preferred commands:");
	CommandInfo[] lPreferredCmds = inCmdMap.getPreferredCommands(inType);
	for(int lCmdIndex = 0; lCmdIndex < lPreferredCmds.length; ++lCmdIndex)
	{
		lBean = dh.getBean(lPreferredCmds[lCmdIndex]);
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
	CommandInfo[] lAllCmds = inCmdMap.getAllCommands(inType);
	for(int lCmdIndex = 0; lCmdIndex < lAllCmds.length; ++lCmdIndex)
	{
		lBean = dh.getBean(lAllCmds[lCmdIndex]);
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
	CommandInfo lCmd = inCmdMap.getCommand(inType, "view");
	if(lCmd != null)
	{
		lBean = dh.getBean(lCmd);
		lBeanClass = lBean.getClass();
		System.out.println("    " + lBeanClass.getName());
	}
	else
	{
		System.out.println("    None");
	}
	
	System.out.println("Edit:");
	lCmd = inCmdMap.getCommand(inType, "edit");
	if(lCmd != null)
	{
		lBean = dh.getBean(lCmd);
		lBeanClass = lBean.getClass();
		System.out.println("    " + lBeanClass.getName());
	}
	else
	{
		System.out.println("    None");
	}
	
	System.out.println("Print:");
	lCmd = inCmdMap.getCommand(inType, "print");
	if(lCmd != null)
	{
		lBean = dh.getBean(lCmd);
		lBeanClass = lBean.getClass();
		System.out.println("    " + lBeanClass.getName());
	}
	else
	{
		System.out.println("    None");
	}
}

}
