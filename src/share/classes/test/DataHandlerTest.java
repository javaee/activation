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
