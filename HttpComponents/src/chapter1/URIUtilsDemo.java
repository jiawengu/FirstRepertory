package chapter1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class URIUtilsDemo {
	public static void main(String[] args) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpClientContext context = HttpClientContext.create();
		HttpGet get = new HttpGet("https://baidu.com/helloworld");
		List<URI> redirectLocation = context.getRedirectLocations();
		try {
			CloseableHttpResponse response = client.execute(get, context);
			HttpHost host = context.getTargetHost();
			URI location = URIUtils.resolve(get.getURI(), host, redirectLocation);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
