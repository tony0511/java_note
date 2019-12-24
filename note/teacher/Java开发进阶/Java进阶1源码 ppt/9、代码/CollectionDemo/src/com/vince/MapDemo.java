package com.vince;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * Map接口：
 * 1、键值对存储一组对象
 * 2、Key不能重复（唯一），Value可以重复
 * 3、具体的实现类：HashMap TreeMap Hashtable LinkedHashMap
 * 4、HashMap 与 Hashtable的区别？
 * 5、如何选择使用哪个？
 * 6、数据结构:数组、链表、二叉树（红黑树）、哈希表（数组+链表）、栈、队列
 * @author vince
 * @description
 */
public class MapDemo {

	/**
	 * 基于二叉树的红黑树实现
	 */
	private static void treeMap(){
		Map<String, String> map = new TreeMap<>();
		// map.put("one", "Lily");
		// map.put("two", "Tom");
		// map.put("three", "Bin");
		// map.forEach((key, value) -> System.out.println(key + "->" + value));
		Map<Dog, String> dogs = new TreeMap<>();
		dogs.put(new Dog(1, "2ha", 3), "dog1");
		dogs.put(new Dog(1, "wangwang", 2), "dog2");
		dogs.put(new Dog(3, "hsq", 4), "dog3");
		dogs.forEach((key, value) -> System.out.println(key + "->" + value));
	}

	/**
	 * LinkedHashMap是HashMap的子类，由于HashMap不能保正顺序恒久不变，此类使用一个双重链表来维护
	 * 元素添加的顺序。
	 */
	private static void linkedHashMap(){
		Map<String, String> table = new LinkedHashMap<>();
		table.put("one", "Lily");
		table.put("two", "Tom");
		table.forEach((key, value) -> System.out.println(key + "->" + value));
	}

	/**
	 * JDK1.0开始
	 * 基于哈希表实现（数组+链表）
	 * 默认数组大小为11，加载因子0.75
	 * 扩充方式：原数组大小<<1 (*2) +1
	 * 线程安全的，用在多线程访问时
	 */
	private static void hashtable(){
		Map<String, String> table = new Hashtable<>();
		table.put("one", "Lily");
		table.put("two", "Tom");
		table.forEach((key, value) -> System.out.println(key + "->" + value));
	}
	/**
	 * HashMap的现实原理：
	 * 1、基于哈希表（数组+链表+二叉树（红黑树） ）1.8JDK
	 * 2、默认加载因子为0.75，默认数组大小是16，
	 * 3、把对象存储到哈希表中，如何存储？
	 * 	把key对象通过hash()方法计算hash值，然后用这个hash值对数组长度取余数（默认16），来决定该对KEY对象
	 * 在数组中存储的位置 ，当这个位置 有多个对象时，以链表结构存储，JDK1.8后，当链表长度大于8时，链表将转换为
	 * 红黑树结构存储。
	 * 这样的目的，是为了取值更快，存储的数据量越大，性能的表现越明显
	 *
	 * 4、扩充原理：当数组的容量超过了75%，那么表示该数组需要扩充，如何扩充？
	 * 扩充的算法是：当前数组容量<<1 （相当于是乘2），扩大1倍, 扩充次数过多，会影响性能，每次扩充表示哈希表重新
	 * 散列（重新计算每个对象的存储位置），我们在开发中尽量要减少扩充次数带来的性能问题。
	 * 5、线程不安全，适合在单线程中使用
	 */
	private static void hashMap(){
		Map<Integer,String> map = new HashMap<>();
		map.put(1, "Tom");
		map.put(2, "Jack");
		System.out.println("size=" + map.size()); // 获取元素的数量
		System.out.println(map.get(1)); // 通过 key 取 value
		// map的遍历
		// 1 遍历Entry
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		for(Entry e: entrySet){
			System.out.println(e.getKey() + "->" + e.getValue());
		}
		System.out.println("--------");
		// 2 遍历键
		Set<Integer> keys = map.keySet();
		for(Integer i: keys){
			String value = map.get(i);
			System.out.println(i + "->" + value);
		}
		System.out.println("--------");
		// 3 遍历值
		Collection<String> values = map.values();
		for(String value: values){
			System.out.println(value);
		}
		System.out.println("--------");
		// 4 foreach
		map.forEach((key, value) -> System.out.println(key + "->" + value));
		// 判断集合中是否存在指定的key
		System.out.println(map.containsKey(7));
		// 判断集合中是否存在指定的value
		System.out.println(map.containsValue("Vince"));
	}
	public static void main(String[] args) {
		// hashMap();
		// hashtable();
		treeMap();
	}
}
