package com.vince;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Collection接口：用于存储单个对象的集合
 * List接口：
 * 1、有序的,可以重复
 * 2、允许多个 null 元素
 * 3、具体的实现有常用的：ArrayList，Vector，LinkedList
 * 在实际开发中，我们如何选择list的具体实现？
 * 1、安全性问题
 * 2、是否频繁插入，删除操作（LinkedList）
 * 3、是否是存储后遍历
 *
 * Set接口：
 * @author vince
 * @description
 */
public class ListDemo {
	/**
	 * LinkedList
	 * 1、实现原理，采用双向链表结构实现
	 * 2、适合插入，删除操作，性能高
	 *
	 */
	private static void linkedList(){
		LinkedList<String> list = new LinkedList<>();
		list.add("苍老师");
		list.add("李老师");
		for(int i = 0;i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	/**
	 * Vector
	 * 1、实现原理，采用动态对象数组实现，默认构造方法创建了一个大小为10的对象数组
	 * 2、扩充的算法：当增量为0时，扩充为原来大小的2倍，当增量大于0时，扩充为原来大小+增量
	 * 3、不适合删除或插入操作
	 * 4、为了防止数组动态扩充次数过多，建议创建Vector时，给定初始容量
	 * 5、线程安全，适合在多线程访问时使用，在单线程下使用效率较低
	 * 面试题 ：Vector与ArrayList的区别?
	 */
	private static void vector(){
		Vector<String> v = new Vector<>();
		v.add("苍老师");
		v.add("李老师");
		for(int i = 0; i < v.size(); i++){
			System.out.println(v.get(i));
		}
	}
	/**
	 * ArrayList（1.8）
	 * 1、实现原理，采用动态对象数组实现，默认构造方法创建了一个空数组
	 * 2、第一次添加元素，扩展容量为10，之后的扩充算法：原来数组大小+原来数组的一半
	 * 3、不适合进行删除或插入操作
	 * 4、为了防止数组动态扩充次数过多，建议创建ArrayList时，给定初始容量
	 * 5、多线程中使用不安全，适合在单线程访问时使用，效率较高
	 * JDK1.2开始
	 */
	private static void  arrayList(){
		List<String> list = new ArrayList<>();
		list.add("苍老师");
		list.add("李老师");
		// 遍历集合
		int size = list.size(); // 获取 List 的长度
		for(int i = 0; i < size; i++){
			System.out.println(list.get(i)); // 查询元素
		}
		System.out.println(list.contains("苍老师")); // 是否包含指定元素
		list.remove("毕老师"); // 删除元素
		String[] array = list.toArray(new String[]{}); // List 转成数组
		for(String s: array){
			System.out.println(s);
		}
	}
	public static void main(String[] args) {
		arrayList();
		vector();
		linkedList();
	}
}
