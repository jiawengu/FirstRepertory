package com.guxiagufei.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class TXTReader {
	public String read(File file){
		StringBuilder sb = new StringBuilder();
		try {
			InputStream in = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			char[] chars = new char[1024 * 10];
			int length = 0;
			
			while((length = br.read(chars)) != -1){
				sb.append(chars, 0, length);
			}
			br.close();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
		
	}
}
