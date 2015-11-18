package chapter1;

import java.io.File;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;

public class FileEntityDemo {
	public static void main(String[] args) {
		File file = new File("chapter1/file.txt");
		FileEntity fe = new FileEntity(file, ContentType.create("text/html", "utf-8"));
		HttpPost post = new HttpPost("http://baidu.com");
		post.setEntity(fe);
	}
}
