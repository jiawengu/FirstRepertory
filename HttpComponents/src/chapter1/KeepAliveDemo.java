package chapter1;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;

public class KeepAliveDemo {
	public static void main(String[] args) {
		ConnectionKeepAliveStrategy keepAliveStra = new DefaultConnectionKeepAliveStrategy(){
			
			@Override
			public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
				long keepAlive = super.getKeepAliveDuration(response, context);
				if(keepAlive == -1){
					keepAlive = 5000;
				}
				return keepAlive;
			}
		};
		CloseableHttpClient httpClient = HttpClients.custom().setKeepAliveStrategy(keepAliveStra).build();
	}
}
