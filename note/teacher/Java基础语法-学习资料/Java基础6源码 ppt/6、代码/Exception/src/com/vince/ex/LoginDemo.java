package com.vince.ex;

import java.util.Scanner;

//面试题 ：
// Exception 与 RuntimeException
// Exception:受检异常，在编程期检查，在调用抛出这个异常的方法时，必须显示的使用try...catch...
// RuntimeException:非受检异常，在运行期检查，在调用抛出这个异常的方法时，可以不用显示的使用try...catch...
// 在使用自定义异常时，根据实际的业务要求，来决定使用哪个作为父类
public class LoginDemo {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name = input.nextLine();
		System.out.println("请输入密码：");
		String pass = input.nextLine();

		UserService us = new UserService();
		try {
			User user = us.login(name, pass);
			System.out.println("登录成功");
			System.out.println(user);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

}
