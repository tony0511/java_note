package com.qianfeng.login;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtils {
	private static Properties pro = null;
	static{
		
		pro = new Properties();
		// 通用方式，针对web应用和普通的java程序，都可以得到正确的文件路径
//		String filePath = LoginServlet.class.getResource("/info.properties").getPath();
//		System.out.println(filePath);
		
		
		// 将读取到的文件转换为流对象
		// 针对web程序， 路径中的 / 相对于 发布目录下classes目录;如果文件放在包下，可以不用写/
		// 针对java程序， 路径中的 / 相对于 bin目录
		InputStream inputStream = PropUtils.class.getResourceAsStream("/info.properties");
		try {
			pro.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			pro.setProperty("username", "admin");
		}
		
	}
	
	public static String getUserName(){
		if(pro == null){
			return "";
		}
		return pro.getProperty("username");
	}
	
	public static String getPassword(){
		return pro.getProperty("password");
	}
}
