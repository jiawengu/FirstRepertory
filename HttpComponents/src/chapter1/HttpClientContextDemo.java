package chapter1;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.params.HttpParamConfig;
import org.apache.http.protocol.HttpContext;

public class HttpClientContextDemo {
	public static void main(String[] args) {
		HttpContext context = new HttpContext() {
			
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
		};
		HttpClientContext clientContext = HttpClientContext.adapt(context);
		HttpHost target = clientContext.getTargetHost();
		HttpRequest request = clientContext.getRequest();
		RequestConfig congif = clientContext.getRequestConfig();
	}
}
