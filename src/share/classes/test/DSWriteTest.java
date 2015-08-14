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

public class	DSWriteTest
{

public static void	main(String[] inArguments) throws Exception, MalformedURLException, IOException
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
				System.out.println("Name: " + lName);
				System.out.println("Type: " + lFileSource.getContentType());
				
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
						System.out.println("Test Succeeded");
					}
					else
					{
						System.out.println("Test Failed");
					}
					lFileIStream = null;
					
					if(!lFile.delete())
					{
						System.out.println("couldn't delete " + lName);
					}
				}
				else
				{
					System.out.println("Test Failed because an OutputStream couldn't be created.");
				}
			}
		}
		else if(inArguments[0].equals("url"))
		{
		    System.out.println("URL not supported...");
// 			for(int lURLIndex = 1; lURLIndex < inArguments.length; ++lURLIndex)
// 			{
// 				URL lURL = new URL(inArguments[lURLIndex]);
				
// 				System.out.println("Name: " + lURL.getName());
// 				System.out.println("Type: " + lURL.getContentType());
				
// 				//	write some data
// 				OutputStream lURLOStream = lURL.getOutputStream();
// 				if(lURLOStream != null)
// 				{
// 					byte[] lURLBuffer = { 34, 35, 36, 37 };
// 					lURLOStream.write(lURLBuffer);
// 					lURLOStream.flush();
// 					lURLOStream.close();
					
// 					//	read the same data
// 					InputStream lURLIStream = lURL.getInputStream();
// 					lURLIStream.read(lURLBuffer);
// 					if((lURLBuffer[0] == 34) && (lURLBuffer[1] == 35) && (lURLBuffer[2] == 36) &&(lURLBuffer[3] == 37))
// 					{
// 						System.out.println("Test Succeeded");
// 					}
// 					else
// 					{
// 						System.out.println("Test Failed");
// 					}
// 				}
// 				else
// 				{
// 					System.out.println("Test Failed because an OutputStream couldn't be created.");
// 				}
// 			}
		}
	}
	else
	{
		System.out.println("usage: DataSourceTest <kind of source> <name of source>");
	}
}

}
