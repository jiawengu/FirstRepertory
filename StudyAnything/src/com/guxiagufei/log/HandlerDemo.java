package com.guxiagufei.log;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandlerDemo {
	public static void main(String[] args) {
		Logger log = Logger.getLogger("demo");
		log.setLevel(Level.INFO);
		ConsoleHandler handler = new ConsoleHandler();
		log.addHandler(handler);
		try {
			FileHandler fileHandler = new FileHandler("demo.log");
			log.addHandler(fileHandler);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("i have a dream");
		log.severe("i have two dreams");
		
	}
}
