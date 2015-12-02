package net.hicp.jiawengu.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4JFile {
	static Logger log = Logger.getLogger(Log4JFile.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j/log4j.properties");
		log.info("hello");
		log.debug("hello");
	}
}
