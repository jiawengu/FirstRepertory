package chapter1;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;

public class LaxRedirectStrategyDemo {
	public static void main(String[] args) {
		LaxRedirectStrategy strategy = new LaxRedirectStrategy();
		CloseableHttpClient client = HttpClients.custom().setRedirectStrategy(strategy).build();
		
	}
}
