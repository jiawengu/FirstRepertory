package chapter1;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;

public class HttpRequestRetryHandlerDemo {
	HttpRequestRetryHandler handler = new HttpRequestRetryHandler() {
		
		@Override
		public boolean retryRequest(IOException exception, int exceptionCount, HttpContext context) {
			if(exceptionCount > 5){
				//do not retry if over max retry count
				return false;
			}
			if(exception instanceof InterruptedIOException){
				//timeout
				return false;
			}
			if(exception instanceof UnknownHostException){
				return false;
			}
			if(exception instanceof ConnectTimeoutException){
				return false;
			}
			if(exception instanceof SSLException){
				return false;
			}
			HttpClientContext clientContext = HttpClientContext.adapt(context);
			HttpRequest request = clientContext.getRequest();
			boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
			if(idempotent){
				return true;
			}
			return false;
			
		}
	};
	CloseableHttpClient client = HttpClients.custom().setRetryHandler(handler).build();
}
