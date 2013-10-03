/* @(#)TestDCH.java   1.1 98/02/09
 *
 * Copyright (c) 1997-1998 Sun Microsystems, Inc.  All Rights Reserved.
 * This software is the confidential and proprietary information of Sun
 * Microsystems, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 *
 * SUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 */

package	javasoft.sqe.tests.api.javax.activation.TestClasses;

import	java.awt.datatransfer.*;
import	java.io.*;
import  java.io.IOException;
import	javax.activation.*;

/** Test DCH that does nothing. Just provides an object 
 */

public class TestDCH implements DataContentHandler {

    private DataFlavor df = null;
    private static Object obj = null;

    public static String getDefaultMimeType() {
	return "test/test";
    }

    public static String getDataFlavorName() {
	return "madeInTestDCH";
    }

    public static Object getObject()
    {
	if (obj == null)
	    obj = new TestCommandObject();

	return obj;
    }

    public TestDCH(String mimeType)
    {
	this.df = new DataFlavor(mimeType, getDataFlavorName());
    }

    public TestDCH()
    {
	this(getDefaultMimeType());
    }

    public DataFlavor[] getTransferDataFlavors()
    {
	DataFlavor dfs [] = new DataFlavor[1];
	dfs[0] = df;
	return dfs;
    }

    public Object getTransferData(DataFlavor df, DataSource ds) throws UnsupportedFlavorException, IOException {
	if (!this.df.isMimeTypeEqual(df.getMimeType()))
	    throw new UnsupportedFlavorException(df);

	return getObject();
    }
    /**
     * Return an object representing the data in its most preferred form.
     * Generally this will be the form described by the first DataFlavor
     * returned by the getTransferDataFlavors method.
     */

    public Object getContent(DataSource ds) throws IOException
    {
	return obj;
    }
    /**
     * Convert the object to a byte stream of the specified MIME type
     * and write it to the output stream.
     */

    public void writeTo(Object obj, String mimeType, OutputStream os ) throws IOException {
	// tests not counting on this doing anything for now.
    }
    // methods of TestDCH  (testing convenience)

    public String getMimeType()
    {
	return df.getMimeType();
    }
}
