package com.guava;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.Collections2;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

public class GuavaDemo {
	// 双键的Map -> Table -> rowKey+columnKye+value
	@Test
	public void testGuava10(){
		Table<String, String, Integer> table = HashBasedTable.create();
		table.put("jack", "java", 80);
		table.put("tom", "php", 70);
		table.put("bin", "java", 59);
		table.put("lily", "ui", 98);
		Set<Cell<String, String, Integer>> cells = table.cellSet();
		for(Cell c: cells){
			System.out.println(c.getRowKey() + "-" + c.getColumnKey() + "-" + c.getValue());
		}
	}
	// BiMap：双向Map(bidirectional Map) 键与值不能重复
	@Test
	public void testGuava9(){
		BiMap<String, String> map = HashBiMap.create();
		map.put("finally_test", "18201583398");
		map.put("bin_test", "18388881521");
		String name = map.inverse().get("18201583398");
		System.out.println(name);
		// System.out.println(map.inverse().inverse() == map);
	}
	// Multimap：key可重复
	@Test
	public void testGuava8() {
		Map<String, String> map = new HashMap<>();
		map.put("Java从入门到精通", "bin");
		map.put("Android从入门到精通", "bin");
		map.put("PHP从入门到精通", "jack");
		map.put("笑看人生", "vince");
		Multimap<String, String> mmap = ArrayListMultimap.create();
		Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry<String, String> entry = iter.next();
			mmap.put(entry.getValue(), entry.getKey());
		}
		Set<String> keySet = mmap.keySet();
		for(String key: keySet){
			Collection<String> values = mmap.get(key);
			System.out.println(key + "->" + values);
		}
	}
	// Multiset：无序可重复
	@Test
	public void testGuava7() {
		String s = "good good study day day up";
		String[] ss = s.split(" ");
		HashMultiset<String> set = HashMultiset.create();
		for (String str : ss) {
			set.add(str);
		}
		Set<String> set2 = set.elementSet();
		for (String str : set2) {
			System.out.println(str + ":" + set.count(str));
		}
	}
	// 集合操作：交集、差集、并集
	@Test
	public void testGuava6() {
		Set<Integer> set1 = Sets.newHashSet(1, 2, 3);
		Set<Integer> set2 = Sets.newHashSet(3, 4, 5);
		// 交集
		SetView<Integer> v1 = Sets.intersection(set1, set2);
		// v1.forEach(System.out::println);
		// 差集
		SetView<Integer> v2 = Sets.difference(set1, set2);
		// v2.forEach(System.out::println);
		// 并集
		SetView<Integer> v3 = Sets.union(set1, set2);
		v3.forEach(System.out::println);
	}
	// 加入约束：非空、长度验证
	@Test
	public void testGuava5() {
		Set<String> set = Sets.newHashSet();
		// 14版可用
		Constraint<String> constraint = new Constraint<>(){
			@Override
			public String checkElement(String element){}
		}
		Preconditions.checkArgument(expression);
		Preconditions.checkNotNull(reference)
	}
	// 组合式函数
	@Test
	public void testGuava4() {
		List<String> list = Lists.newArrayList("java", "php", "jack", "h5", "javascript");
		Function<String, String> f1 = new Function<String, String>() {
			@Override
			public String apply(String t) {
				return t.length() > 4 ? t.substring(0, 4) : t;
			}
		};
		Function<String, String> f2 = new Function<String, String>() {
			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
		};
		Function<String, String> f = Functions.compose(f1, f2);
		Collection<String> coll = Collections2.transform(list, f);
		coll.forEach(System.out::println);
	}
	// 转换
	@Test
	public void testGuava3() {
		Set<Long> timeSet = Sets.newHashSet(20121212L, 20170520L, 20160808L);
		Collection<String> timeCollect = Collections2.transform(timeSet, (e) -> new SimpleDateFormat("yyyy-MM-dd").format(e));
		timeCollect.forEach(System.out::println);
	}
	// 过滤器
	@Test
	public void testGuava2() {
		List<String> list = Lists.newArrayList("java", "php", "jack", "h5", "javascript");
		Collection<String> result = Collections2.filter(list, (e) -> e.startsWith("j"));
		result.forEach(System.out::println);
	}
	// 设置 只读
	@Test
	public void testGuava1() {
		System.out.println("test guava");
		// List<String> list = Arrays.asList("jack", "tom", "lily", "bin");
		// list.add("vince");
		List<String> list = new ArrayList<>();
		list.add("jack");
		list.add("tom");
		list.add("lily");
		list.add("bin");
		// List<String> readList = Collections.unmodifiableList(list);
		// readList.add("vince");
		// ImmutableList<String> iList =
		// ImmutableList.of("jack", "tom", "lily", "bin");
		// iList.add("vince");
	}
}
