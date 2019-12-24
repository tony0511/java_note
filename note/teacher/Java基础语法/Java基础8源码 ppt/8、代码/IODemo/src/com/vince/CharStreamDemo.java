package com.vince;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 字符流：
 * 字符输出流：Writer，对文件的操作使用子类：FileWriter
 * 字符输入流：Reader，对文件的操作使用子类：FileReader
 * 每次操作的单位是一个字符
 * 文件字符操作流会自带缓存，默认大小为1024字节，在缓存满后，或手动刷新缓存，或关闭流时会把数据写入文件
 *
 * 如何选择使用字节流还是字符流：
 * 一般操作非文本文件时，使用字节流，操作文本文件时，建议使用字符流
 *
 * 字符流的内部实现还是字节流
 * @author vince
 * @description
 */
public class CharStreamDemo {
	private static void in() {
		File file = new File("c:\\test\\vince.txt");
		try {
			Reader in = new FileReader(file);
			char[] cs = new char[3];
			int len = -1;
			StringBuilder buf = new StringBuilder();
			while((len = in.read(cs)) != -1){
				buf.append(new String(cs, 0, len));
			}
			in.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
	private static void out() {
		File file = new File("c:\\test\\vince.txt");
		try {
			Writer out = new FileWriter(file, true);
			out.write(",村花到我家");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		out();
		// in();
	}
}
