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
