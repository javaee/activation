/* @(#)TestCommandMap.java   1.1 98/02/09
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

import	javax.activation.*;
import  javasoft.sqe.tests.api.javax.activation.TestClasses.*;

/** This class is used to provide an alternative to the default MailcapCommandMap
 *  for testing purposes. It provides a number of distinct values which can be used
 *  to validate that it is being correctly used by a DataHandler.
 */

public class TestCommandMap extends CommandMap {

	public static String getClassName() {
		return  "test.package.TestClass";
	}

	public static String getVerb() {
		return "testVerb";
	}

	public static String getPreferredClassName() {
		return "test.package.PreferredClass";
	}

	public static String getPreferredVerb() {
		return "preferredVerb";
	}

	public static String getIncorrectMimeTypeVerb() {
		return "incorrectMimeType";
	}

	private String requiredMimeType = null;
	
	public TestCommandMap(String requiredMimeType)
	{
		this.requiredMimeType = requiredMimeType;
	}

	public CommandInfo[] getPreferredCommands(String mimeType)
	{
    	      CommandInfo cmdArray[] = new CommandInfo[1];
    	      String verb = (requiredMimeType.equals(mimeType)) ? getPreferredVerb() : getIncorrectMimeTypeVerb();
    	      cmdArray[0] = new CommandInfo(verb, getPreferredClassName());
    	      return cmdArray;
	}

	public CommandInfo[] getAllCommands(String mimeType)
	{
    		CommandInfo cmdArray[] = new CommandInfo[1];
    		String verb = (requiredMimeType.equals(mimeType)) ? getVerb() : getIncorrectMimeTypeVerb();
    		cmdArray[0] = new CommandInfo(verb, getClassName());
    		return cmdArray;
	}

	public CommandInfo getCommand(String mimeType, String cmdName)
	{
		String verb = (requiredMimeType.equals(mimeType)) ? cmdName : getIncorrectMimeTypeVerb();
		return new CommandInfo(verb, getClassName());
	}

	public DataContentHandler createDataContentHandler(String mimeType)
	{
    		return (requiredMimeType.equals(mimeType)) ? new TestDCH(mimeType) : null;
	}
}
