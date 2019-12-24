package com.vince;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream接口：不是存储数据结构，数据源可以是一个集合，为了函数式编程创造 ，
 * 惰式执行，数据只能被消费一次
 *
 * 两种类型的操作方法：
 * 1、中间操作（生成一个Stream）
 * 2、结束操作（执行计算操作）
 * @author vince
 * @description
 */
public class StreamDemo {
	public static void main(String[] args) {
		// 获取 stream 流
		Stream<String> stream1 = Stream.of("good", "good", "study", "day", "day", "up");
		// count(获取集合中元素的数量)
		System.out.println(stream1.count());
		// foreach(遍历)
		stream1.forEach(str -> System.out.println(str));
		// stream1.forEach(System.out::println);
		// filter(过滤)
		stream1.filter(s -> s.length() > 3).forEach(System.out::println);
		// distinct(去重)
		stream1.distinct().forEach(s -> System.out.println(s));
		// map(遍历得到结果的集合)
		stream1.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		// flatMap(合并)
		Stream<List<Integer>> stream2 = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5));
		stream2.flatMap(list -> list.stream()).forEach(System.out::println);
		// reduce(聚合)
		Optional<String> opt = stream1.reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
		System.out.println(opt.get());
		// 返回一个 IntStream，其中包含将给定函数应用于此流的元素的结果
		System.out.println(stream1.mapToInt(s -> s.length()).sum());
		// collect(把 stream 转换成 List/Set/Map)
		List<String> list = stream1.collect(Collectors.toList());
		list.forEach(s -> System.out.println(s));
		// :: 方法引用
		// 引用静态方法     	Integer::valueOf
		// 引用对象的方法  	list::add
		// 引用构造方法			ArrayList::new
	}
}
