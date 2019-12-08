package com.qianfeng.xpath;

import java.util.List;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(Demo.class.getResourceAsStream("/Book.xml"));
			// 根据xpath路径获取指定的节点
			List<Element> eles = doc.selectNodes("/root/books/book/auther/name");
			for (Element element : eles) {
				System.out.println(element.getText());
				
			}
			System.out.println("--------------------");
			// 找所有标签名时name的节点，不管层次关系
			List<Element> eles2 = doc.selectNodes("//name");
			for (Element element : eles2) {
				System.out.println(element.getText());
			}
			// 根据子元素的文本内容获取父元素对象
//			Element ele = (Element) doc.selectSingleNode("/root/books/book[name='乔布斯传']");
			// 根据节点属性值获取对象
			Element ele = (Element) doc.selectSingleNode("/root/books/book[@id=2]");
			// 获取节点的xml格式的字符串
			System.out.println(ele.asXML());
		
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
