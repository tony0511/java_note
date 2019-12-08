package com.qianfeng.dom;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 创建SAXReader对象
		SAXReader reader = new SAXReader();
		
		// 获取文件的路径
		// 如果是java项目，获取的是bin目录下的文件
		// 如果是web项目，获取的是发布目录下classes目录下的文件
		String path = Demo.class.getResource("/contact.xml").getPath();
		
		// 获取document对象
		try {
			List<Contact> list = new ArrayList<>();
			Document doc = reader.read(new File(path));
			// 获取根节点
			Element rootEle = doc.getRootElement();
			// 获取指定节点下的所有子节点
			List<Element> elements = rootEle.elements();
			for (Element element : elements) {
				/*// 根据属性名获取属性对象
				Attribute attribute = element.attribute("id");
				// 获取属性的值
				System.out.println(attribute.getValue());
				
				// 根据标签名获取元素对象
				Element nameEle = element.element("name");
				// 获取元素的文本内容
				System.out.println(nameEle.getText());
				
				// 根据标签名获取元素的文本内容
				System.out.println(element.elementText("age"));
				System.out.println(element.elementText("phone"));
				System.out.println(element.elementText("email"));
				System.out.println(element.elementText("qq"));*/
				
				Contact c = new Contact();
				c.setId(element.attributeValue("id"));
				c.setName(element.elementText("name"));
				c.setPhone(element.elementText("phone"));
				c.setEmail(element.elementText("email"));
				c.setQq(element.elementText("qq"));
				c.setAge(Integer.parseInt(element.elementText("age")));
				
				list.add(c);
				
			}
			
			for (Contact c : list) {
				System.out.println(c.getName());
			}
			
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
