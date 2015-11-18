package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

public class HttpEntityDemo {
	public static void main(String[] args) {
		StringEntity se = new StringEntity("important message", ContentType.create("text/plain","utf-8"));
		System.out.println(se.getContentLength());
		System.out.println(se.getContentType());
		try {
			InputStream is = se.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));
			System.out.println(br.readLine());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
