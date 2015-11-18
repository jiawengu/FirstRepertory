package chapter1;

import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.message.BasicHttpResponse;

public class HeaderIteratorDemo {
	public static void main(String[] args) {
		HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
		response.addHeader("Set-cookie", "c1=a");
		response.addHeader("Set-cookie", "c2=b");
		HeaderIterator it = response.headerIterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
