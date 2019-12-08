package com.qianfeng.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class JsonlibTest {

	@Test
	public void bean2Json(){
		
		Student s = new Student(2, "zhagnsan", 39);
		// 对象转为json格式的字符串
		String json = JSONObject.fromObject(s).toString();
		System.out.println(json);//{"age":39,"id":2,"name":"zhagnsan"}
		
	}
	
	@Test
	public void list2Json(){
		
		List<Student> l = new ArrayList<>();
		Student s = new Student(2, "zhagnsan", 39);
		Student s1 = new Student(4, "zhagnsan4", 39);
		l.add(s);
		l.add(s1);
		
		// 对象转为json格式的字符串
		String json = JSONArray.fromObject(l).toString();
		//[{"age":39,"id":2,"name":"zhagnsan"},{"age":39,"id":4,"name":"zhagnsan4"}]
		System.out.println(json);
		
	}
	
	@Test
	public void dateInfo(){
		Person p = new Person();
		p.setAge(30);
		p.setName("haha");
		p.setBirth(new Date());
		
		// 日期对象默认转为分别包含年月日时分秒等信息的对象
		System.out.println(JSONObject.fromObject(p).toString());
		//{"name":"haha","birth":{"date":15,"hours":11,"seconds":12,"month":10,"timezoneOffset":-480,"year":118,"minutes":33,"time":1542252792225,"day":4},"age":30}

		
	}
	
}
