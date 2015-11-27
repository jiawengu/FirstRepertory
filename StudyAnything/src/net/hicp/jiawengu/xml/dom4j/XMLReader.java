package net.hicp.jiawengu.xml.dom4j;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLReader {
	private SAXReader reader;
	public XMLReader(){
		reader = new SAXReader();
	}
	public static void main(String[] args) {
		XMLReader reader = new XMLReader();
		reader.read("xml/books.xml");
	}
	public Document parse(String filename){
		try {
			return  reader.read(new File(filename));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void read(String filename){
		Document document = parse(filename);
		Element root = document.getRootElement();
		Iterator<Element> it = root.elementIterator();
		while(it.hasNext()){
			Element book = it.next();
			Iterator<Element> it2 = book.elementIterator();
			while(it2.hasNext()){
				Element bookOne = it.next();
				List<Element> list = bookOne.elements();
				Element lunyu = list.get(0);
				System.out.println(lunyu.getName());
			}
			
		}
	}
}
