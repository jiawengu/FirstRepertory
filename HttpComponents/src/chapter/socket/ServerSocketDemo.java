package chapter.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo extends Thread{
	 	private Socket socket;  
	    public ServerSocketDemo(Socket socket) {  
	        this.socket = socket;  
	    }  
	  
	    public void run() {  
	        try {  
	            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
	            PrintWriter writer = new PrintWriter(socket.getOutputStream());  
	  
	            String data = reader.readLine();  
	            writer.println(data + "somg");  
	            writer.close();  
	            socket.close();  
	        } catch (IOException e) {  
	  
	        }  
	    }  
	      
	    public static void main(String[] args) throws Exception {  
	        while (true) {  
	            new ServerSocketDemo((new ServerSocket(6450)).accept()).start();  
	        }  
	    }
}
