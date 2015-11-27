package com.guxiagufei.json;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class ValidateJSONTest {

	@Test
	public void testIsJSONFile() {
		File file = new File("txt/json.txt");
		boolean b = ValidateJSON.isJSON(file);
		System.out.println(b);
	}

}
