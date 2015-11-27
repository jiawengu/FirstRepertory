package net.hicp.jiawengu.xml.dom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLWriter {
	private DocumentBuilderFactory factory;
	private Document document;
	private TransformerFactory factory2;
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		XMLWriter writer = new XMLWriter();
		writer.getDocument();
		writer.buildXML();
		writer.write();
	}
	public void getDocument(){
		factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void buildXML(){
		Element root = document.createElement("books");
		Element book1 = document.createElement("book");
		Element lunyu = document.createElement("lunyu");
		Element lunyuPrice = document.createElement("price");
		lunyuPrice.setTextContent("15");
		Element lunyuType = document.createElement("type");
		lunyuType.setTextContent("classical");
		Element book2 = document.createElement("book");
		Element walden = document.createElement("walden");
		Element waldenPrice = document.createElement("price");
		waldenPrice.setTextContent("20");
		Element waldenType = document.createElement("type");
		waldenType.setTextContent("country");
		
		lunyu.appendChild(lunyuPrice);
		lunyu.appendChild(lunyuType);
		book1.appendChild(lunyu);
		
		walden.appendChild(waldenPrice);
		walden.appendChild(waldenType);
		book2.appendChild(walden);
		
		root.appendChild(book1);
		root.appendChild(book2);
		
		document.appendChild(root);
		
	}
	
	public void write() throws FileNotFoundException, UnsupportedEncodingException{
		File outFile = new File("xml/books2.xml");
		Source xmlsource = new DOMSource(document);
		Result xmlResult = new StreamResult(outFile);
		factory2 = TransformerFactory.newInstance();
		try {
			Transformer transformer = factory2.newTransformer();
			transformer.transform(xmlsource, xmlResult);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
