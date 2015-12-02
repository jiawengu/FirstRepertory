package com.guxiagufei.log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ShipWithLogDemo {
	public static void main(String[] args) {
		Logger log = Logger.getLogger("demo");
		log.setLevel(Level.INFO);
		log.info("hello world");
		log.fine("fine");
	}
}
