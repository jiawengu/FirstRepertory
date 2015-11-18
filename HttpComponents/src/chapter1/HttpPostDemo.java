package chapter1;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.message.BasicHttpResponse;

public class HttpPostDemo {
	public static void main(String[] args) {
		HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
		System.out.println(response.getStatusLine());
		response.addHeader("Set-cookie","cl=a; path=/");
		response.addHeader("Set-cookie","c2=b;path=//");
		Header h1 = response.getFirstHeader("Set-cookie");
		Header h2 = response.getLastHeader("Set-cookie");
		Header[] all = response.getHeaders("Set-cookie");
		System.out.println(h1);
		System.out.println(h2);
		System.out.println(all[1]);
	}
}
