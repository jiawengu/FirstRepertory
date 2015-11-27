package net.hicp.jiawengu.xml.dom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {
	private DocumentBuilderFactory factory;
	public static void main(String[] args) {
		XMLReader reader = new XMLReader();
		String s = reader.priceRead("walden");
		System.out.println(s);
	}
	public Document parse(String fileName){
		factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			File file = new File(fileName);
			InputStream is = new FileInputStream(file);
			Document document = builder.parse(is);
			return document;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("没找到xml文件");
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String priceRead(String book){
		Document document = parse("xml/books.xml");
		NodeList list = document.getElementsByTagName(book);
		Node node = list.item(0);
		Element e = null;
		if(Node.ELEMENT_NODE == node.getNodeType()){
			e = (Element)node;
		}
		NodeList listPrice = e.getElementsByTagName("price");
		Node priceNode = listPrice.item(0);
		return priceNode.getTextContent();
	}
}
