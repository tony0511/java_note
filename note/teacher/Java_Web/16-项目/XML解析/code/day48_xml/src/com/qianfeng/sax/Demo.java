package com.qianfeng.sax;

import java.io.File;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

public class Demo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		SAXParser parser = factory.newSAXParser();
		
		parser.parse(new File(Demo.class.getResource("/UserInfo.xml").getPath()), new SaxService());
	}

}
