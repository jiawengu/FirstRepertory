package com.guxiagufei.json;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;

import com.guxiagufei.io.TXTReader;

public class ValidateJSON {
	
	public static boolean isJSON(String str){
		try{
			new JSONObject(str);
		}catch (JSONException e){
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public static boolean isJSON(File filename){
		TXTReader reader = new TXTReader();
		String str = reader.read(filename);
		System.out.println(str +"123");
		return isJSON(str);
	}
	
	public static void main(String[] args) {
		File file = new File("txt/Everyday.txt");
		System.out.println(isJSON(file));
	}
}
