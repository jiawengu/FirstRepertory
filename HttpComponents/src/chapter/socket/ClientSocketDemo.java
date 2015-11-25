package chapter.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketDemo {
		public static void main(String[] args) throws Exception {  
			  
	        Socket s = new Socket("localhost", 6450);  
	  
	        PrintWriter writer = new PrintWriter(s.getOutputStream());  
	        BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));  
	        writer.println("123");  
	        writer.flush();  
	        System.out.println(reader.readLine());  
	        s.close();  
	    }
	
}
