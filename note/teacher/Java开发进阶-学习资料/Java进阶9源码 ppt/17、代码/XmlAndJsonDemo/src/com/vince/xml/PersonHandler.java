package com.vince.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vince on 2017/7/1.
 * SAX解析的特点：
 * 1、基于事件驱动
 * 2、顺序读取，速度快
 * 3、不能任意读取节点（灵活性差）
 * 4、解析时占用的内存小
 * 5、SAX更适用于在性能要求更高的设备上使用（Android开发中）
 *
 */
public class PersonHandler extends DefaultHandler{
  private List<Person> persons = null;
  private Person p; // 当前正在解析的person
  private String tag; // 用于记录当前正在解析的标签名
  public List<Person> getPersons() { return persons; }
  // 开始解析文档时调用
  @Override
  public void startDocument() throws SAXException {
    super.startDocument();
    persons = new ArrayList<>();
    System.out.println("开始解析文档...");
  }
  // 在XML文档解析结束时调用
  @Override
  public void endDocument() throws SAXException {
    super.endDocument();
    System.out.println("解析文档结束.");
  }
  /**
   * 解析开始元素时调用
   * @param uri 命名空间
   * @param localName 不带前缀的标签名
   * @param qName 带前缀的标签名
   * @param attributes 当前标签的属性集合
   * @throws SAXException
   */
  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    super.startElement(uri, localName, qName, attributes);
    if ("person".equals(qName)){
      p = new Person();
      String personid = attributes.getValue("personid");
      p.setPersonid(personid);
    }
    tag = qName;
    System.out.println("startElement--" + qName);
  }
  // 解析结束元素时调用
  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    super.endElement(uri, localName, qName);
    if ("person".equals(qName)) {
      persons.add(p);
    }
    tag = null;
    System.out.println("endElement--" + qName);
  }
  // 解析文本内容时调用
  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    super.characters(ch, start, length);
    if (tag != null) {
      if ("name".equals(tag)) {
        p.setName(new String(ch, start, length));
      } else if ("address".equals(tag)){
        p.setAddress(new String(ch, start, length));
      } else if ("tel".equals(tag)){
        p.setTel(new String(ch, start, length));
      } else if ("fax".equals(tag)){
        p.setFax(new String(ch, start, length));
      } else if ("email".equals(tag)){
        p.setEmail(new String(ch, start, length));
      }
      System.out.println(ch);
    }
  }
}
