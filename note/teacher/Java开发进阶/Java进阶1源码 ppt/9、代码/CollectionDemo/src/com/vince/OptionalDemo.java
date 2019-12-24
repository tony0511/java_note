package com.vince;

import java.util.Optional;

/**
 * Optional JDK1.8容器类
 * @author vince
 * @description
 */
public class OptionalDemo {
	public static void main(String[] args) {
		// // 为非 null 的值创建一个 Optional
		Optional<String> optional = Optional.of("bin");
		// 为指定的值创建一个 Optional，如果指定的值为 null，则返回一个空的 Optional
		Optional<String> optional2 = Optional.ofNullable("bin");
		Optional<String> optional3 = Optional.empty();
		// 如果值存在返回 true，否则返回 false
		System.out.println(optional.isPresent());
		// 如果 Optional 有值则将其返回，否则抛出 NoSuchElementException
		System.out.println(optional.get());
		// 如果 Optional 实例有值则为其调用 consumer，否则不做处理
		optional.ifPresent(value -> System.out.println(value));
		// 如果有值则将其返回，否则返回指定的其它值
		System.out.println(optional.orElse("无值"));
		// 接受 Supplier 接口的实现用来生成默认值
		System.out.println(optional.orElseGet(() -> "default"));
		try {
			// 如果有值则将其返回，否则抛出 supplier 接口创建的异常
			optional3.orElseThrow(Exception::new);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 如果有值，则对其执行调用mapping函数得到返回值。如果返回值不为 null，则创建包含 mapping 返回值的 Optional 作为 map 方法返回值，否则返回空 Optional
		Optional<String> optional4 = optional.map(value -> value.toUpperCase());
		System.out.println(optional4.orElse("no found"));
		// 如果有值，为其执行 mapping 函数返回 Optional 类型返回值，否则返回空 Optional
		optional4 = optional.flatMap(value -> Optional.of(value.toUpperCase() + "-flatMap"));
		System.out.println(optional4.orElse("no found"));
		// 如果有值并且满足断言条件返回包含该值的 Optional，否则返回空 Optional
		optional4 = optional.filter(value -> value.length() > 3);
		System.out.println(optional4.orElse("这个值的长度小于3"));
	}
}
