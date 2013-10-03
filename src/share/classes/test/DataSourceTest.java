package	test;

import	java.beans.*;
import	java.io.*;
import	java.net.*;
import  javax.activation.*;

public class	DataSourceTest
{

    public static void	main(String[] inArguments) throws Exception, MalformedURLException, IOException {
	if(inArguments.length >= 2) {
	    if(inArguments[0].equals("file")){
		for(int lIndex = 1; lIndex < inArguments.length; ++lIndex) {
		    processSource(new FileDataSource(new File(inArguments[lIndex])));
		}
	    }
	    else if(inArguments[0].equals("url"))
		{
		    System.out.println("URL is not supported...");
		// 	for(int lIndex = 1; lIndex < inArguments.length; ++lIndex)
// 			{
// 				processSource((new URL(inArguments[lIndex])).openConnection());
// 			}
		}
	}
	else
	{
		System.out.println("usage: DataSourceTest <test> <sources>");
	}
}

private static void	processSource(DataSource inSource) throws Exception, IOException
{
	System.out.println("Name: " + inSource.getName());
	System.out.println("Type: " + inSource.getContentType());
	
	//	read some data
	InputStream lInputStream = inSource.getInputStream();
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
