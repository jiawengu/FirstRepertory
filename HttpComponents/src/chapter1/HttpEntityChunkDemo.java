package chapter1;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

public class HttpEntityChunkDemo {
	public static void main(String[] args) {
		StringEntity entity = new StringEntity("test chunk prefer",ContentType.create("text/plain", "UTF-8"));
		entity.setChunked(true);
		HttpPost post = new HttpPost("https://taobao.com");
		post.setEntity(entity);
	}
}
