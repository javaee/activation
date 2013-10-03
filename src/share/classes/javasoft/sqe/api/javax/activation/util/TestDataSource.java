/* @(#)TestDataSource.java   1.1 98/02/09
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
 */

package	javasoft.sqe.tests.api.javax.activation.TestClasses;

import javax.activation.*;
import java.io.*;

/**
 * A TestDataSource for the DataHandler tests. It will return a 
 * the passed in byte stream via the getinputstream method.
 */

public class TestDataSource implements DataSource {

    byte byte_array[] = null;
    
    public TestDataSource(byte byte_array[]){
	this.byte_array = byte_array;
    }

    public InputStream getInputStream() throws IOException {
	ByteArrayInputStream bis = new ByteArrayInputStream(byte_array);
	return bis;
	
    }
    public OutputStream getOutputStream() throws IOException {
	return null;
    }
    public String getContentType(){
	return "application/octet-stream";
    }
    public String getName() {
	    return "name";
    }
}
