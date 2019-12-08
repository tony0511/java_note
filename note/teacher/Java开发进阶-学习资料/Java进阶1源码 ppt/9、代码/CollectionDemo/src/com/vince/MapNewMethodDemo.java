package com.vince;

import java.util.HashMap;
import java.util.Map;

/**
 * Map接口1.8新增方法介绍
 * @author vince
 * @description
 */
public class MapNewMethodDemo {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "jack");
		map.put(2, "tom");
		// 获取，没有的话使用默认值
		String value = map.getOrDefault(4, "null");
		// 只会添加不存在相同 key 的值
		String val = map.putIfAbsent(3, "vince");
		// 根据键和值都匹配时才删除
		map.remove(1, "jack");
    // key 存在时才会用 vince 替换
		map.replace(3, "vince");
    // key 和 value 都相等时才会用 vince 替换
		map.replace(3, "lily", "vince");
		// 把Lambda表达式计算后的值作为该key对应的键值
		map.compute(1, (k, v1) -> v1 + "1");
    // 如果指定的 key 不存在（或映射到 null），才把Lambda表达式计算后的值作为该key对应的键值，否则保持不变
		map.computeIfAbsent(5, val -> val + "test"); // value key
		// 如果指定的 key 不存在则把 888 put到该key对应的键值，如果存在，则把Lambda表达式计算后的值作为该key对应的键值
		map.merge(8, "888", (oldVal, newVal) -> oldVal.concat(newVal));
		map.forEach((k, v) -> System.out.println(k + "->" + v));
	}
}
