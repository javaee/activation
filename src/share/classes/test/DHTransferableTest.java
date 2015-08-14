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
