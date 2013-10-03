package	test;

import	java.beans.*;
import	java.io.*;
import	java.net.*;
import  javax.activation.*;

public class	DSWriteTest
{

public static void	main(String[] inArguments) throws Exception, MalformedURLException, IOException
{
	if(inArguments.length >= 2)
	{
		if(inArguments[0].equals("file"))
		{
			for(int lFileIndex = 1; lFileIndex < inArguments.length; ++lFileIndex)
			{
				File lFile = new File(inArguments[lFileIndex]);
				FileDataSource lFileSource = new FileDataSource(lFile);
				
				String lName = lFileSource.getName();
				System.out.println("Name: " + lName);
				System.out.println("Type: " + lFileSource.getContentType());
				
				//	write some data
				OutputStream lFileOStream = lFileSource.getOutputStream();
				if(lFileOStream != null)
				{
					byte[] lFileBuffer = { 34, 35, 36, 37 };
					lFileOStream.write(lFileBuffer);
					lFileOStream.flush();
					lFileOStream.close();
					lFileOStream = null;
					
					//	read the same data
					InputStream lFileIStream = lFileSource.getInputStream();
					lFileIStream.read(lFileBuffer);
					if((lFileBuffer[0] == 34) && (lFileBuffer[1] == 35) && (lFileBuffer[2] == 36) &&(lFileBuffer[3] == 37))
					{
						System.out.println("Test Succeeded");
					}
					else
					{
						System.out.println("Test Failed");
					}
					lFileIStream = null;
					
					if(!lFile.delete())
					{
						System.out.println("couldn't delete " + lName);
					}
				}
				else
				{
					System.out.println("Test Failed because an OutputStream couldn't be created.");
				}
			}
		}
		else if(inArguments[0].equals("url"))
		{
		    System.out.println("URL not supported...");
// 			for(int lURLIndex = 1; lURLIndex < inArguments.length; ++lURLIndex)
// 			{
// 				URL lURL = new URL(inArguments[lURLIndex]);
				
// 				System.out.println("Name: " + lURL.getName());
// 				System.out.println("Type: " + lURL.getContentType());
				
// 				//	write some data
// 				OutputStream lURLOStream = lURL.getOutputStream();
// 				if(lURLOStream != null)
// 				{
// 					byte[] lURLBuffer = { 34, 35, 36, 37 };
// 					lURLOStream.write(lURLBuffer);
// 					lURLOStream.flush();
// 					lURLOStream.close();
					
// 					//	read the same data
// 					InputStream lURLIStream = lURL.getInputStream();
// 					lURLIStream.read(lURLBuffer);
// 					if((lURLBuffer[0] == 34) && (lURLBuffer[1] == 35) && (lURLBuffer[2] == 36) &&(lURLBuffer[3] == 37))
// 					{
// 						System.out.println("Test Succeeded");
// 					}
// 					else
// 					{
// 						System.out.println("Test Failed");
// 					}
// 				}
// 				else
// 				{
// 					System.out.println("Test Failed because an OutputStream couldn't be created.");
// 				}
// 			}
		}
	}
	else
	{
		System.out.println("usage: DataSourceTest <kind of source> <name of source>");
	}
}

}
