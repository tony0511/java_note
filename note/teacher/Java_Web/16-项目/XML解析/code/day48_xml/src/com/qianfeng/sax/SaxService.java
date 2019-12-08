package com.qianfeng.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

// 自定义解析类
public class SaxService extends DefaultHandler{

	List<User> list = null;
	User user = null;
	String tagName = null;
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		
		list = new ArrayList<>();
		
	}
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		
		for (User user : list) {
			System.out.println(user.getName());
		}
		
	
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		
		if(qName.equals("user")){
			user = new User();
			// 根据属性名获取属性值
			user.setId(attributes.getValue("id"));
		}
		// 记录标签名
		tagName = qName;
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub

		if(qName.equals("user")){
			list.add(user);
		}
		tagName = null;
	}
	
	// 获取标签的文本内容
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		if(tagName == null){
			return;
		}
		String info = new String(ch, start, length);
		switch (tagName) {
		case "name":
			user.setName(info);
			break;
		case "age":
			user.setAge(Integer.parseInt(info));
			break;
		case "hobby":
			user.setHobby(info);
			break;
		default:
			break;
		}
		
	}
}
