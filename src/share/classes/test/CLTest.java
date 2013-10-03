/**
 * NOTE: This test only works on JDK 1.2!!
 */
package	test;

import	java.net.*;

class	CLTest
{

public static void	main(String[] inArgs)
{
	URL[] lURLs = ClassLoader.getSystemResources(inArgs[0]);
	
	System.out.println("Looking for resources named " + inArgs[0]);
	System.out.println("Found:");
	
	for(int lIndex = 0; lIndex < lURLs.length; ++lIndex)
	{
		System.out.println("    " + lURLs[lIndex].toString());
	}
}

}
