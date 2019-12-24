package com.vince;

import java.util.Arrays;

public class StringDemo2 {

	public static void main(String[] args) {

		String str = " fkwefwfa d6737383 ";
		char c = str.charAt(1);
		System.out.println(c);

		System.out.println(str.toCharArray());
		char[] cs = {'a','b','c'};
		String s1 = new String(cs);

		String s2 = new String(cs,0,1);
		System.out.println(s2);

		System.out.println(Arrays.toString(str.getBytes()));

		System.out.println(str.replace('w', '*'));
		System.out.println(str.replaceAll("\\d", "*"));

		System.out.println(str.substring(0, 4));

		System.out.println(Arrays.toString(str.split("d")));

		System.out.println(str.contains("a"));

		System.out.println(str.indexOf("f"));
		System.out.println(str.lastIndexOf("f"));
		System.out.println(str.isEmpty());

		System.out.println(str.length());

		System.out.println(str.trim());

		System.out.println(str.concat("*****"));
		System.out.println(String.valueOf(10));
	}

}
