package chapter1;

import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpResponse;

public class HeaderElementDemo {
	public static void main(String[] args) {
		HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
		response.addHeader("Set-cookie","c1=a");
		response.addHeader("Set-cookie","c2=b");
		HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator());
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
}
