package com.vince;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectStreamDemo {
	/**
	 * 对象序列化
	 * 把对象写入文件：实际写入的是类名、属性名、属性类型、属性的值等
	 */
	private static void writeObjects(){
		Dog dog = new Dog("wangwang", 2, "母");
		Dog dog2 = new Dog("2哈", 3, "公");
		Dog[] dogs = {dog,dog2};
		File file = new File("c:\\test\\dog.obj");
		try {
			OutputStream out = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(dogs);
			oos.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 反序列化的过程
	 * 从文件中把对象的内容读取出来，还原成对象
	 */
	private static void readObject(){
		File file = new File("c:\\test\\dog.obj");
		try {
			InputStream in = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(in);
			Dog dog = (Dog)ois.readObject();
			ois.close();
			System.out.println(dog);
		} catch (FileNotFoundException|IOException|ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 对象序列化
	 * 把对象写入文件：实际写入的是类名、属性名、属性类型、属性的值等
	 */
	private static void writeObject(){
		Dog dog = new Dog("wangwang", 2, "母");
		File file = new File("c:\\test\\dog.obj");
		try {
			OutputStream out = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(dog);
			oos.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// writeObject();
		readObject();
	}
}
