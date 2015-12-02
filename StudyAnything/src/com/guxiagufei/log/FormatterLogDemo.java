package com.guxiagufei.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class FormatterLogDemo {
	public static void main(String[] args) {
		Logger log = Logger.getLogger("hello");
		try {
			FileHandler handler = new FileHandler("demo.log");
			handler.setFormatter(new Myformatter());
			log.addHandler(handler);
			log.info("helloName");
			log.severe("danger");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class Myformatter extends Formatter{
	
	@Override
	public String format(LogRecord record) {
		return record.getLevel() + " : " + record.getMessage() + "\n";
	}
	
}
