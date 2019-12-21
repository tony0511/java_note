package com.qianfeng.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastJsonTest {
	@Test
	// 对象转为 json 格式的字符串
	public void bean2Json(){
		Student s = new Student(2, "zhagnsan", 39);
		String json = JSON.toJSONString(s);
		System.out.println(json); // {"age":39,"id":2,"name":"zhagnsan"}
	}
	@Test
	// 数组转为 json 格式的字符串
	public void list2Json(){
		List<Student> l = new ArrayList<>();
		Student s = new Student(2, "zhagnsan", 39);
		Student s1 = new Student(4, "zhagnsan4", 39);
		l.add(s);
		l.add(s1);
		String json = JSON.toJSONString(l);
		// [{"age":39,"id":2,"name":"zhagnsan"},{"age":39,"id":4,"name":"zhagnsan4"}]
		System.out.println(json);
	}
	@Test
	// json 格式字符串转为对象
	public void json2bean(){
		String json = "{\"name\":\"lisi\", \"age\":30,\"id\":5}";
		Student stu = JSON.parseObject(json, Student.class);
		System.out.println(stu.getName());
	}
	@Test
	// json格式字符串转为数组
	public void json2list(){
		String json = "[{\"name\":\"lisi\", \"age\":30,\"id\":5}]";
		// List<Student> list = JSON.parseArray(json, Student.class);
		// 这种方式更通用
		List<Student> list = JSON.parseObject(json, new TypeReference<List<Student>>(){});
		System.out.println(list.get(0).getName());
	}
	@Test
	// json 中的日期转换
	public void dateInfo(){
		Person p = new Person();
		p.setAge(30);
		p.setName("haha");
		p.setBirth(new Date());
		// 日期对象默认转为时间戳
		System.out.println(JSON.toJSONString(p));
		// 日期转为 yyyy-MM-dd HH:mm:ss
		System.out.println(JSON.toJSONString(p, SerializerFeature.WriteDateUseDateFormat));
		// 自定义转换格式
		System.out.println(JSON.toJSONStringWithDateFormat(p, "yyyy-MM-dd" , SerializerFeature.WriteDateUseDateFormat));
	}
}
