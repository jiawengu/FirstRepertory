package com.guxiagufei.io;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class WriteString {
	public static void writeException(String str, String filePath) {
		File file = new File(filePath);
		OutputStream os = null;
		BufferedWriter bw = null;
		try {
			os = new BufferedOutputStream(new FileOutputStream(file));// true把文件写入原有信息的末尾
			bw = new BufferedWriter(new OutputStreamWriter(os));
			bw.write(str);
			bw.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
