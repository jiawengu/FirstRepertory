package chapter1;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.omg.CORBA.Request;

public class HttpContextDemo {
	public static void main(String[] args) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		RequestConfig config = RequestConfig.custom().setSocketTimeout(1000).setConnectTimeout(1000).build();
		HttpGet get = new HttpGet("http://localhost/1");
		get.setConfig(config);
		try {
			CloseableHttpResponse response = httpClient.execute(get, new HttpContext() {
				
				@Override
				public void setAttribute(String arg0, Object arg1) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public Object removeAttribute(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public Object getAttribute(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}
			});
			
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
