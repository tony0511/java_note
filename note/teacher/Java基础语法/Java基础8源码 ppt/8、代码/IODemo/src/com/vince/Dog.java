package com.vince;

import java.io.Serializable;

//如果一个类创建的对象，需要被序列化，那么该类必须实现Serializable接口，
//Serializable是一个标记接口，没有任何定义，为了告诉JVM该类对象可以被序列化

//什么时候对象需要被序列化呢？
//1、把对象保存到文件中（存储到物理介质）
//2、对象需要在网络上传输
//如果对象没有实现Serializable接口，会报错误：java.io.NotSerializableException
public class Dog implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String sex;
	private transient int id; //在序列化中被忽略

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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Dog(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

}
