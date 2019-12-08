/**
	三目运算符与优先级
*/

import java.util.Scanner;
public class Test12{
	public static void main(String[] args){

		System.out.println("请输入一个成绩：");
		Scanner input = new Scanner(System.in);
		int score = input.nextInt();
		//String表示一个字符串类型，不是基本数据类型
		String s = score>=60?"及格":"挂科";
		System.out.println(s);

		int a = 1;
		int b = 2;
		a = ++a + (b--) + (a-b) + b;
		System.out.println(a);
	}
}