package com.vince;

/**
 *
 * @author vince
 * @description
 * String 表示一个字符串，内部使用字符数组实现，不能被继承（最终类），不可变
 */
public class StringDemo {

	public static void main(String[] args) {

		//String 的两种赋值方式，JAVA推荐使用第一种方式

		//1 直接赋值
		String s1 = "粪粪";
		//2 使用new关键字创建对象,new：表示申请内存空间
		////面试题 问以下代码创建了几个对象? 2个
		String s2 = new String("粪粪");

		String s3 = "粪粪";

		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println("-----------------");
		//代码示例：4种情况分析:直接赋值字符串连接时，考虑编译期和运行期
		//如果在编译期值 可以被确定，那么就使用已有的对象，否则会创建新的对象
		String a = "a";
		String a1 = a+1;
		String a2 = "a1";
		System.out.println(a1==a2);

		final String b = "b";
		String b1 = b+1;
		String b2 = "b1";
		System.out.println(b1==b2);

		String c = getC();
		String c1 = c+1;
		String c2 = "c1";
		System.out.println(c1==c2);

		final String d = getD();
		String d1 = d+1;
		String d2 = "d1";
		System.out.println(d1==d2);
	}

	private static String getC(){
		return "c";
	}
	private static String getD(){
		return "d";
	}

}
