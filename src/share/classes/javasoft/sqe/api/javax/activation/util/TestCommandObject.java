/* @(#)TestCommandObject.java   1.1 98/02/09
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

/**
 * This is utility library routine.
 */

public class TestCommandObject implements CommandObject {

    private DataHandler dh = null;
    private String verb = null;
    private boolean wasCalled = false;
    
    public TestCommandObject() {
    }
    
    public void setCommandContext(String verb, DataHandler dh) {
	this.dh = dh;
	this.verb = verb;
	wasCalled = true;
    }
    
    public String getVerb() {
	return verb;
    }

    public DataHandler getDataHandler() {
	return dh;
    }

    public boolean getWasCalled() {
	return wasCalled;
    }
}
