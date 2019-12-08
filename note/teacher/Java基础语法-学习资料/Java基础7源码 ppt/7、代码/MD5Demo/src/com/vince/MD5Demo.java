package com.vince;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class MD5Demo {

	private static String savePassword = "pmq7VoTEWWLYh1ZPCDRujQ==";//存储的密文
	public static void main(String[] args) {


		//test();

		System.out.println(login("admin123456"));

	}

	private static boolean login(String password){
		if(savePassword.equals(md5(password))){
			return true;
		}else{
			return false;
		}
	}

	//计算MD5的工具方法
	private static String md5(String password){
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			//通过MD5计算摘要
			byte[] bytes = md.digest(password.getBytes("UTF-8"));
			String str = Base64.getEncoder().encodeToString(bytes);
			return str;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void test() {
		String password = "admin123456";  //dsfkjdskfj76776f98732 明文（原文）
		String savePassword = "pmq7VoTEWWLYh1ZPCDRujQ==";//存储的密文

		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			//通过MD5计算摘要
			byte[] bytes = md.digest(password.getBytes("UTF-8"));
			System.out.println(Arrays.toString(bytes));
			String mdStr = new String(bytes);
			//System.out.println(mdStr);
			//a-z A-Z 0-9 / * BASE64编码算法
			//1.8版本
			//String str = Base64.getEncoder().encodeToString(bytes);
			//System.out.println(str);

			//JDK1.8之前使用
			BASE64Encoder base64 = new BASE64Encoder();
			String str = base64.encode(bytes);
			//base64解码
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] bs = decoder.decodeBuffer(str);
			System.out.println(str);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
