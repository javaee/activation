package test;

import	java.beans.*;
import	java.io.*;
import	java.net.*;

class	SerMaker11
{

public static void	main(String[] inArgs) throws IOException, MalformedURLException
{
	if(inArgs.length == 1)
	{
		//	first set up the output stream
		File lFile = new File(inArgs[0]);
		FileOutputStream lFileStream = new FileOutputStream(lFile);
		ObjectOutputStream lObjectStream = new ObjectOutputStream(lFileStream);
		
		//	now create a URL
		URL lURL = new URL("http://java.sun.com/");
		
		//	serialize it
		lObjectStream.writeObject(lURL);
		
		//	clean up the stream
		lObjectStream.flush();
		lObjectStream.close();
	}
	else
	{
		System.out.println("usage: SerMaker <name of output file>");
	}
}

}
