package demo;

import java.util.Arrays;
import java.io.ByteArrayOutputStream;
import javax.activation.DataHandler;

public class Bug6456395 {

    public static void main(String args[]) throws Exception {
	Bug6456395 bug = new Bug6456395();
	
	if(args.length != 0) {
	    System.out.println("usage: Bug6456395");
	    System.exit(1);
	}
        String whatisyourname = "como se llama ?";	
        byte[] hello = new byte[] {'h','o','l','a'};
	bug.test(whatisyourname);
        bug.test(hello);
    }

    private void test(String obj) throws Exception {
        DataHandler dh = new DataHandler(obj, "espanol/foo");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        dh.writeTo(bos);
        if (obj.equals(bos.toString()))
	    System.out.println(
                "Test Passed for String Object and Unknown MimeType");
        else System.out.println(
            "Test Failed for String Object and Unknown MimeType");
    }

    private void test(byte[] obj) throws Exception {
        DataHandler dh = new DataHandler(obj, "espanol/foo");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        dh.writeTo(bos);
        if (Arrays.equals((byte[])obj, bos.toByteArray()))
            System.out.println(
                "Test Passed for Byte array Object and Unknown MimeType");
        else System.out.println(
            "Test Failed for Byte array Object and Unknown MimeType");            
    }
}
