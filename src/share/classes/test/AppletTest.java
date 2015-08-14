/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2015 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package	test;

import	java.applet.*;
import	java.awt.*;
import	java.beans.*;
import	java.io.*;
import	java.net.*;
import  javax.activation.*;

public class	AppletTest
	extends		Applet
{

public	AppletTest()
{
	
	mTextArea = new TextArea(10, 40);
	mTextArea.setEditable(false);
	
	add(mTextArea);
}

public void	init()
{
	StringWriter lWriter = new StringWriter();
	try
	{
		String lTest = getParameter("test");
		
		String[] lArgs = { "file", "" };
		lArgs[1] = getParameter(lArgs[0]);
		
		if(lArgs[1] == null)
		{
			lArgs[0] = "url";
			lArgs[1] = getParameter(lArgs[0]);
		}
		
		lWriter.write("Test: " + lTest + " " + lArgs[0] + " " + lArgs[1] + "\n\n");
		
		if(lTest.equals("CommandMapTest"))
		{
			doCommandMapTest(lWriter, lArgs);
		}
		else if(lTest.equals("RelCommandMapTest"))
		{
			doRelCommandMapTest(lWriter, lArgs);
		}
		else if(lTest.equals("DSWriteTest"))
		{
			doDSWriteTest(lWriter, lArgs);
		}
		else if(lTest.equals("RelDSWriteTest"))
		{
			doRelDSWriteTest(lWriter, lArgs);
		}
	}
	catch(Exception inException)
	{
		lWriter.write(inException.toString() + "\n");
	}
	
	mTextArea.setText(lWriter.toString());
	mTextArea.repaint();
}

private void	doCommandMapTest(Writer outWriter, String[] inArguments) throws MalformedURLException, IOException
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
				DataHandler ldh = new DataHandler (lFileSource);

				outWriter.write("Name: " + lFileSource.getName() + "\n");
				
				String lMIMEType = lFileSource.getContentType();
				outWriter.write("Type: " + lFileSource.getContentType() + "\n");
				
				processType(outWriter, lCommandMap, lMIMEType, ldh);
				
				outWriter.write("\n");
			}
		}
		else if(inArguments[0].equals("url")) {
		    System.out.println("url option not supported!!");

		    //    for(int lIndex = 1; lIndex < inArguments.length; ++lIndex){
		    // 	 URL lURL = new URL(inArguments[lIndex]);
		    //  URLConnection lURLSource = lURL.openConnection();
			
		    // lURLSource.connect();
		    // outWriter.write("Name: " + lURLSource.getName() + "\n");
			
		    // String lMIMEType = lURLSource.getContentType();
		    // outWriter.write("Type: " + lURLSource.getContentType() + "\n");
			
		    // processType(outWriter, lCommandMap, lMIMEType);
			
		    //  outWriter.write("\n");
		    // }
		}
	}
	else
	{
		outWriter.write("usage: CommandMapTest <sourcetype> <sources>\n");
	}
}

private void	doRelCommandMapTest(Writer outWriter, String[] inArguments) throws MalformedURLException, IOException
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
				DataHandler ldh = new DataHandler (lFileSource);
				
				outWriter.write("Name: " + lFileSource.getName() + "\n");
				
				String lMIMEType = lFileSource.getContentType();
				outWriter.write("Type: " + lFileSource.getContentType() + "\n");
				
				processType(outWriter, lCommandMap, lMIMEType, ldh);
				
				outWriter.write("\n");
			}
		}
		else if(inArguments[0].equals("url")) {
		   //  for(int lIndex = 1; lIndex < inArguments.length; ++lIndex){
// 			URL lDoc = getDocumentBase();
// 			URL lURL = new URL(lDoc, inArguments[lIndex]);
// 			URLConnection lURLSource = lURL.openConnection();
			
// 			lURLSource.connect();
// 			outWriter.write("Name: " + lURLSource.getName() + "\n");
			
// 			String lMIMEType = lURLSource.getContentType();
// 			outWriter.write("Type: " + lURLSource.getContentType() + "\n");
			
// 			processType(outWriter, lCommandMap, lMIMEType);
			
// 			outWriter.write("\n");
// 		    }
		}
	}
	else
	{
		outWriter.write("usage: CommandMapTest <sourcetype> <sources>\n");
	}
}

private static void	processType(Writer outWriter, CommandMap inCmdMap, String inType, DataHandler dh) throws IOException
{
	Object lBean;
	Class lBeanClass;
	
	//	grab the preferred commands and enumerate them
	outWriter.write("Preferred commands:\n");
	CommandInfo[] lPreferredCmds = inCmdMap.getPreferredCommands(inType);
	for(int lCmdIndex = 0; lCmdIndex < lPreferredCmds.length; ++lCmdIndex)
	{
		lBean = dh.getBean(lPreferredCmds[lCmdIndex]);
		if (lBean != null)
		{
		    lBeanClass = lBean.getClass();
		    outWriter.write("    " + lBeanClass.getName() + "\n");
		}
		else
		{
		    outWriter.write("No Bean for command " + lPreferredCmds[lCmdIndex].getCommandName());
		}
	}

	//	grab all commands and enumerate them
	outWriter.write("All commands:\n");
	CommandInfo[] lAllCmds = inCmdMap.getAllCommands(inType);
	for(int lCmdIndex = 0; lCmdIndex < lAllCmds.length; ++lCmdIndex)
	{
		lBean = dh.getBean(lAllCmds[lCmdIndex]);
		if (lBean != null)
		{
		    lBeanClass = lBean.getClass();
		    outWriter.write("    " + lBeanClass.getName() + "\n");
		}
		else
		{
		    outWriter.write("No Bean for command " + lAllCmds[lCmdIndex].getCommandName());
		}
	}
	
	//	grab the commands for the default three verbs view, edit & print
	outWriter.write("View:\n");
	CommandInfo lCmd = inCmdMap.getCommand(inType, "view");
	if(lCmd != null)
	{
		lBean = dh.getBean(lCmd);
		if (lBean != null)
		{
		    lBeanClass = lBean.getClass();
		    outWriter.write("    " + lBeanClass.getName() + "\n");
		}
		else
		{
		    outWriter.write("No Bean for command " + lCmd.getCommandName());
		}
	}
	else
	{
		outWriter.write("    None\n");
	}
	
	outWriter.write("Edit:\n");
	lCmd = inCmdMap.getCommand(inType, "edit");
	if(lCmd != null)
	{
		lBean = dh.getBean(lCmd);
		if (lBean != null)
		{
		    lBeanClass = lBean.getClass();
		    outWriter.write("    " + lBeanClass.getName() + "\n");
		}
		else
		{
		    outWriter.write("No Bean for command " + lCmd.getCommandName());
		}
	}
	else
	{
		outWriter.write("    None\n");
	}
	
	outWriter.write("Print:\n");
	lCmd = inCmdMap.getCommand(inType, "print");
	if(lCmd != null)
	{
		lBean = dh.getBean(lCmd);
		if (lBean != null)
		{
		    lBeanClass = lBean.getClass();
		    outWriter.write("    " + lBeanClass.getName() + "\n");
		}
		else
		{
		    outWriter.write("No Bean for command " + lCmd.getCommandName());
		}
	}
	else
	{
		outWriter.write("    None\n");
	}
}

private void	doRelDSWriteTest(Writer outWriter, String[] inArguments) throws Exception, MalformedURLException, IOException
{
	if(inArguments.length >= 2)
	{
		if(inArguments[0].equals("file"))
		{
			for(int lFileIndex = 1; lFileIndex < inArguments.length; ++lFileIndex)
			{
				File lFile = new File(inArguments[lFileIndex]);
				FileDataSource lFileSource = new FileDataSource(lFile);
				
				String lName = lFileSource.getName();
				outWriter.write("Name: " + lName + "\n");
				outWriter.write("Type: " + lFileSource.getContentType() + "\n");
				
				//	write some data
				OutputStream lFileOStream = lFileSource.getOutputStream();
				if(lFileOStream != null)
				{
					byte[] lFileBuffer = { 34, 35, 36, 37 };
					lFileOStream.write(lFileBuffer);
					lFileOStream.flush();
					lFileOStream.close();
					lFileOStream = null;
					
					//	read the same data
					InputStream lFileIStream = lFileSource.getInputStream();
					lFileIStream.read(lFileBuffer);
					if((lFileBuffer[0] == 34) && (lFileBuffer[1] == 35) && (lFileBuffer[2] == 36) &&(lFileBuffer[3] == 37))
					{
						outWriter.write("Test Succeeded\n");
					}
					else
					{
						outWriter.write("Test Failed\n");
					}
					lFileIStream = null;
					
					if(!lFile.delete())
					{
						outWriter.write("couldn't delete " + lName + "\n");
					}
				}
				else
				{
					outWriter.write("Test Failed because an OutputStream couldn't be created.\n");
				}
			}
		}
		else if(inArguments[0].equals("url")) {
		   //  URL lDoc = getDocumentBase();
// 		    for(int lURLIndex = 1; lURLIndex < inArguments.length; ++lURLIndex)
// 			{
// 			    URL lURL = new URL(lDoc, inArguments[lURLIndex]);
			    
// 			    outWriter.write("Name: " + lURL.getName() + "\n");
// 			    outWriter.write("Type: " + lURL.getContentType() + "\n");
			    
// 				//	write some data
// 			    OutputStream lURLOStream = lURL.getOutputStream();
// 			    if(lURLOStream != null)	{
// 				byte[] lURLBuffer = { 34, 35, 36, 37 };
// 				lURLOStream.write(lURLBuffer);
// 				lURLOStream.flush();
// 				lURLOStream.close();
				
// 				//	read the same data
// 				InputStream lURLIStream = lURL.getInputStream();
// 				lURLIStream.read(lURLBuffer);
// 				if((lURLBuffer[0] == 34) && (lURLBuffer[1] == 35) && (lURLBuffer[2] == 36) &&(lURLBuffer[3] == 37)) {
// 				    outWriter.write("Test Succeeded\n");
// 				}
// 				else {
// 				    outWriter.write("Test Failed\n");
// 				}
// 			    }
// 			    else {
// 				outWriter.write("Test Failed because an OutputStream couldn't be created.\n");
// 			    }
// 			}
		}
	}
	else
	{
		outWriter.write("usage: DataSourceTest <kind of source> <name of source>\n");
	}
}

private void	doDSWriteTest(Writer outWriter, String[] inArguments) throws Exception, MalformedURLException, IOException
{
	if(inArguments.length >= 2)
	{
		if(inArguments[0].equals("file"))
		{
			for(int lFileIndex = 1; lFileIndex < inArguments.length; ++lFileIndex)
			{
				File lFile = new File(inArguments[lFileIndex]);
				FileDataSource lFileSource = new FileDataSource(lFile);
				
				String lName = lFileSource.getName();
				outWriter.write("Name: " + lName + "\n");
				outWriter.write("Type: " + lFileSource.getContentType() + "\n");
				
				//	write some data
				OutputStream lFileOStream = lFileSource.getOutputStream();
				if(lFileOStream != null)
				{
					byte[] lFileBuffer = { 34, 35, 36, 37 };
					lFileOStream.write(lFileBuffer);
					lFileOStream.flush();
					lFileOStream.close();
					lFileOStream = null;
					
					//	read the same data
					InputStream lFileIStream = lFileSource.getInputStream();
					lFileIStream.read(lFileBuffer);
					if((lFileBuffer[0] == 34) && (lFileBuffer[1] == 35) && (lFileBuffer[2] == 36) &&(lFileBuffer[3] == 37))
					{
						outWriter.write("Test Succeeded\n");
					}
					else
					{
						outWriter.write("Test Failed\n");
					}
					lFileIStream = null;
					
					if(!lFile.delete())
					{
						outWriter.write("couldn't delete " + lName + "\n");
					}
				}
				else
				{
					outWriter.write("Test Failed because an OutputStream couldn't be created.\n");
				}
			}
		}
		else if(inArguments[0].equals("url")) {
		 //    for(int lURLIndex = 1; lURLIndex < inArguments.length; ++lURLIndex) {
// 			URL lURL = new URL(inArguments[lURLIndex]);
			
// 			outWriter.write("Name: " + lURL.getName() + "\n");
// 			outWriter.write("Type: " + lURL.getContentType() + "\n");
			
// 				//	write some data
// 			OutputStream lURLOStream = lURL.getOutputStream();
// 			if(lURLOStream != null)
// 			    {
// 				byte[] lURLBuffer = { 34, 35, 36, 37 };
// 				lURLOStream.write(lURLBuffer);
// 				lURLOStream.flush();
// 				lURLOStream.close();
				
// 				//	read the same data
// 				InputStream lURLIStream = lURL.getInputStream();
// 				lURLIStream.read(lURLBuffer);
// 				if((lURLBuffer[0] == 34) && (lURLBuffer[1] == 35) && (lURLBuffer[2] == 36) &&(lURLBuffer[3] == 37))
// 				    {
// 					outWriter.write("Test Succeeded\n");
// 				    }
// 				else
// 				    {
// 					outWriter.write("Test Failed\n");
// 				    }
// 			    }
// 			else
// 			    {
// 				outWriter.write("Test Failed because an OutputStream couldn't be created.\n");
// 			    }
// 		    }
 		}
	}
	else
	    {
		outWriter.write("usage: DataSourceTest <kind of source> <name of source>\n");
	    }
}

private TextArea	mTextArea;

}
