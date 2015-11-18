package chapter2;

import java.io.IOException;

import javax.xml.ws.spi.http.HttpContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class PoolingHttpClientConnectionManagerDemo {
	public static void main(String[] args) {
		PoolingHttpClientConnectionManager phcm = new PoolingHttpClientConnectionManager();
		phcm.setMaxTotal(200);
		phcm.setDefaultMaxPerRoute(20);
		HttpHost host = new HttpHost("localhost", 80);
		HttpRoute route = new HttpRoute(host);
		phcm.setMaxPerRoute(route, 30);
		CloseableHttpClient client = HttpClients.custom().setConnectionManager(phcm).build();
	}
	
	public static void main2(){
		PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
		CloseableHttpClient client = HttpClients.custom().setConnectionManager(manager).build();
		String[] urisToGet = {
				"http://www.domain1.com", 
				"http://www.domain2.com", 
				"http://www.domain3.com", 
				};
		GetThread[] threads = new GetThread[urisToGet.length];
		for (int i = 0; i < threads.length; i++) {
			HttpGet httpget = new HttpGet(urisToGet[i]);
			threads[i] = new GetThread(client, httpget);
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
			
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	static class GetThread extends Thread{
		private final CloseableHttpClient httpclient;
		private final HttpClientContext context;
		private final HttpGet get;
		public GetThread(CloseableHttpClient httpclient, HttpGet get) {
			super();
			this.httpclient = httpclient;
			this.context = HttpClientContext.create();
			this.get = get;
		}
		
		@Override
		public void run() {
			try {
				CloseableHttpResponse response = httpclient.execute(get, context);
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
