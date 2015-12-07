package net.hicp.jiawengu.log4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Log4JFile {
	static Log log = LogFactory.getLog(Log4JFile.class);
	public static void main(String[] args) {
//		PropertyConfigurator.configure("log4j.properties");
		log.info("hello");
		log.debug("hello");
	}
}
