package net.hicp.jiawengu.log4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

public class CommonsLogDemo {
	private static  Log log = LogFactory.getLog(CommonsLogDemo.class);
//	static Logger log = Logger.getLogger(CommonsLogDemo.class);
	public static void main(String[] args) {
//		System.out.println(CommonsLogDemo.class);
		PropertyConfigurator.configure("log4j.properties");
		log.info("hello");
	}
}
