package chapter1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HtmlEncodingDemo {
	public static void main(String[] args) throws ParseException, IOException {
		List<NameValuePair> formParams = new ArrayList<NameValuePair>();
		formParams.add(new BasicNameValuePair("name", "sunpeng"));
		formParams.add(new BasicNameValuePair("age", "25"));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
		System.out.println(EntityUtils.toString(entity));
		HttpPost post = new HttpPost("https://baidu.com");
		post.setEntity(entity);
	}
}
