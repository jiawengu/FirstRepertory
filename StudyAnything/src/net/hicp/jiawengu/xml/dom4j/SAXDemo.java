package net.hicp.jiawengu.xml.dom4j;

import javax.management.modelmbean.XMLParseException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAXDemo {
	public static void main(String[] args) throws SAXException, ParserConfigurationException {
		XMLReader reader= XMLReaderFactory.createXMLReader();
		SAXParserFactory sf = SAXParserFactory.newInstance();
		SAXParser parse = sf.newSAXParser();
	}
}
