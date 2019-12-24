package com.vince;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * 程序国际化
 * 1、Locale
 * 2、Properties文件：属性文件（配置文件），内容以键值对的形式存放（key-value）
 * 3、ResourceBundle工具类，来绑定属性文件，并指定Locale对象，来自动选择使用哪个属性文件，默认将使用与操作系统相同的语言环境。
 * 	  getString()方法来从属性文件中使用key来获取value
 * 注意，ResourceBundle工具类是只读的
 * @author vince
 * @description
 */
  public class I18NDemo {

	public static void main(String[] args) {
		// 创建一个本地语言环境对象，该对象会根据参数设置来自动选择与之相关的语言环境
		// 参数：语言，地区
		Locale locale_CN = new Locale("zh","CN");
		Locale locale_US = new Locale("en","US");
		// 获取当前系统的默认语言环境
		Locale locale_default = Locale.getDefault();

		Scanner input = new Scanner(System.in);
		// 用于绑定属性文件的工具类（参数：属性文件的基本名（就是前缀：比如 info））
		// ResourceBundle r = ResourceBundle.getBundle("com.vince.info");
		ResourceBundle r = ResourceBundle.getBundle("com.vince.info",locale_US);
		System.out.println(r.getString("system.name"));
		System.out.println(r.getString("input.username"));
		String username = input.nextLine();
		System.out.println(r.getString("input.password"));
		String password = input.nextLine();

		if("admin".equals(username) && "123".equals(password)){
			System.out.println(r.getString("login.success"));
			String welcome = r.getString("welcome");
			// 动态文本格式化
			welcome = MessageFormat.format(welcome, username);
			System.out.println(welcome);


		}else {
			System.out.println(r.getString("login.error"));
		}

	}

}
