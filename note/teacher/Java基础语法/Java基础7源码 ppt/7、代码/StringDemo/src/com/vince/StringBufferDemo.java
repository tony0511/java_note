package com.vince;

public class StringBufferDemo {
	public static void main(String[] args) {
		String a = "a";
		String b = "b";
		String c = a+b+1;
		System.out.println(c);

		String d = "a"+1+2+3+4+"b";//a1234b //常量相加没有性能问题（编译期进行优化）

		//StringBuffer目的是来解决字符串相加时带来的性能问题(常量与变量)
		//StringBuffer的内部实现采用字符数组，默认数组的长度为16，超过数组大小时，动态扩充的算法是原来长度*2+2
		//所以当我们预知要添加的数据长度时，建议使用带初始化容量的构造方法，来避免动态扩充的次数，从而提高效率
		//线程安全的，会影响性能，
		StringBuffer sb = new StringBuffer(32);//带容量的构造（建议）
		sb.append(a).append(b).append(1);
		System.out.println(sb.toString());

		StringBuffer sb2 = new StringBuffer("abc");
		sb2.delete(0, 1);
	}
}
