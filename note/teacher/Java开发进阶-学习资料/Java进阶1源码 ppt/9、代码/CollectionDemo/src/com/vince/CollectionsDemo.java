package com.vince;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections工具类
 * @author vince
 * @description
 */
public class CollectionsDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("jack");
		list.add("tom");
		list.add("lily");
		list.add("lily");
		Collections.reverse(list); // 反转
		Collections.shuffle(list); // 随机排序
		Collections.sort(list); // 根据自然升序排序
		Collections.sort(list, c); // 自定义比较器进行排序
		Collections.swap(list, 0, 2); // 交换
		Collections.rotate(list, 1); // 右移
  	// 需要事先排好序的list否则可能会找不到
		System.out.println(Collections.binarySearch(list, "tom")); // 二分搜索法
		System.out.println(Collections.max(list)); // 最大元素
		System.out.println(Collections.min(list)); // 最小元素
		Collections.fill(list, "bin"); // 填充
		System.out.println(Collections.frequency(list, "lily")); // 指定对象出现的次数
		Collections.replaceAll(list, "lily", "bin"); // 替换
		List<String> syncList = Collections.synchronizedList(new ArrayList<String>()); // 返回指定集合对象对应的同步对象
		List<String> sList = Collections.emptyList(); // 返回一个空的不可变的集合对象
		sList.add("bin");
		Collections.sort(list,Collections.reverseOrder()); // 返回一个比较器，它强行反转指定比较器的顺序
		System.out.println(list);
	}
}
