/* @(#)TestActivationDataFlavor.java   1.1 98/02/09
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
package javasoft.sqe.tests.api.javax.activation.TestClasses;

import java.awt.datatransfer.*;
import javax.activation.*;

/**
 * this class extends ActivationDataFlavor and provides 
 * public versions of protected methods for JCK testing
 */

public class TestActivationDataFlavor extends ActivationDataFlavor {

    public TestActivationDataFlavor(String mimeType,
				    String humanReadableName)
    {
	super(mimeType, humanReadableName);
    }

    // we will only override protected methods:
    public String testNormalizeMimeTypeParameter(String parameterName,
						 String parameterValue)
    {
	return super.normalizeMimeTypeParameter(parameterName,parameterValue);
    }

    public String testNormalizeMimeType(String mimeType)
    {
	return super.normalizeMimeType(mimeType);
    }
}
