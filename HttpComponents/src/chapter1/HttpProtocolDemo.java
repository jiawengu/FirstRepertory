package chapter1;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;

public class HttpProtocolDemo {
	public static void main(String[] args) {
		//貌似自定义custom method之后都有一个build method
		CloseableHttpClient httpClient = HttpClients.custom().addInterceptorLast(new HttpRequestInterceptor() {
			
			@Override
			public void process(HttpRequest request,  HttpContext context) throws HttpException, IOException {
				AtomicInteger count = (AtomicInteger) context.getAttribute("count");
				request.addHeader("count", Integer.toString(count.getAndIncrement()));
			}
		}).build();
		AtomicInteger count = new AtomicInteger(1);
		HttpClientContext localContext = HttpClientContext.create();
		localContext.setAttribute("count", count);
		for (int i = 0; i < 10; i++) {
			try {
				CloseableHttpResponse response = httpClient.execute(new HttpGet("http://localhost/2"));
				HttpEntity entity = response.getEntity();
				response.close();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
}
