package test;

import	java.beans.*;
import	java.io.*;
import	java.net.*;

class	SerReader11
{

public static void	main(String[] inArgs) throws FileNotFoundException, StreamCorruptedException, IOException, ClassNotFoundException, OptionalDataException
{
	if(inArgs.length == 1)
	{
		//	first set up the input stream
		File lFile = new File(inArgs[0]);
		FileInputStream lFileStream = new FileInputStream(lFile);
		ObjectInputStream lObjectStream = new ObjectInputStream(lFileStream);
		
		//	now read a URL
		URL lURL = (URL)lObjectStream.readObject();
		
		//	verify it is the correct url
		if(lURL.toString().equals("http://java.sun.com/"))
		{
			System.out.println("Test succeeded");
		}
		else
		{
			System.out.println("Test failed");
		}
	}
	else
	{
		System.out.println("usage: SerReader <name of input file>");
	}
}

}
