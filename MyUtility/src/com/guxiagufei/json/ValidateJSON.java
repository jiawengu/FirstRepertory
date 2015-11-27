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
			return false;
		}
		return true;
	}
	
	public static boolean isJSON(File filename){
		TXTReader reader = new TXTReader();
		String str = reader.read(filename);
		return isJSON(str);
	}
}
