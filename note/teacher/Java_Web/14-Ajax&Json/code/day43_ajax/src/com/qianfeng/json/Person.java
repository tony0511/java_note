package com.qianfeng.json;

import java.util.Date;

public class Person {
	private String name;
	private int age;
	private Date birth;
	
	public Person(){}
	
	public Person( String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
