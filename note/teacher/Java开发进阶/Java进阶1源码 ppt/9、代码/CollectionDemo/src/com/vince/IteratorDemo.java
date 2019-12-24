package com.vince;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 集合的输出（迭代）
 * @author vince
 * @description
 */
public class IteratorDemo {
	// === Consumer 消费者接口(有一个入参，没有返回值) ===
	private static void consumerTest(){
		List<String> list = Arrays.asList("Larry", "Moe", "Curly", "Tom", "QF_vince");
		list.forEach(s -> selfPrint(s, c -> System.out.println(c)));
	}
	private static void selfPrint(String s, Consumer<String> c){
		c.accept(s);
	}
	// === Predicate 断言接口(有一个入参，返回布尔值) ===
	private static void predicateTest(){
		List<String> list = Arrays.asList("Larry", "Moe", "Curly", "Tom", "QF_vince");
		List<String> result = filter(list, (s) -> s.contains("o"));
		result.forEach(System.out::println);
	}
	private static List<String> filter(List<String> list, Predicate<String> p){
		List<String> results = new ArrayList<>();
		for (String s : list) {
			if(p.test(s)){ // 测试是否符合要求
				results.add(s);
			}
		}
		return results;
	}
	// === Supplier 代表结果供应商(没有入参，只有返回值) ===
	private static void supplierTest(){
		List<Integer> list = getNums(10, () -> (int)(Math.random() * 100));
		list.forEach(System.out::println);
	}
	private static List<Integer> getNums(int num, Supplier<Integer> sup){
		 List<Integer> list = new ArrayList<>();
		 for(int i = 0; i < num; i++){
			 list.add(sup.get());
		 }
		 return list;
	}
	// === Function 表示接受一个参数并产生结果的函数(有一个入参，也有返回值) ===
	private static void functionTest(){
		String s = strToUpp("qf_vince", (str) -> str.toUpperCase());
		System.out.println(s);
	}
	public static String strToUpp(String str, Function<String, String> f){
		return f.apply(str);
	}
	// === Enumeration ===
	private static void enumeration(){
		Vector<String> vs = new Vector<>();
		vs.add("tom");
		vs.add("jack");
		Enumeration<String> es = vs.elements();
		while(es.hasMoreElements()){
			System.out.println(es.nextElement());
		}
	}
	// === forEach (jdk1.8新的迭代方法) === jdk1.8新的迭代方法
	private static void foreach(){
		List<String> list = new ArrayList<>();
		list.add("tom");
		list.add("jack");
		list.forEach(s -> System.out.println(s));
		// list.forEach(System.out::println);
	}
	// === for(T t: ts) ===foreach(1.5后)
	private static void foreach(Collection<Cat> c){
		for(Cat cat: c){
			System.out.println(cat);
		}
	}
	// === Iterator (1.5之前统一的迭代集合方式) ===
	private static void iterator(Collection<Cat> c){
		Iterator<Cat> iter = c.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
	public static void main(String[] args) {
		List<Cat> list = new ArrayList<>();
		Cat c1 = new Cat("miaomiao", 5, 1);
		Cat c2 = new Cat("huahua", 2, 2);
		list.add(c1);
		list.add(c2);
		iterator(list);
		foreach(list);
		functionTest();
		supplierTest();
		predicateTest();
	}
}
