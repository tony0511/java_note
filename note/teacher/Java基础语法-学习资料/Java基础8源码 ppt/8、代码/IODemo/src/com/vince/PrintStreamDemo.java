package com.vince;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * 打印流:很方便的进行输出
 *
 * 字节打印流
 * 在字节输出时，可以增强输出功能
 * 字符打印流
 *
 * @author vince
 * @description
 */
public class PrintStreamDemo {
	private static void charPrint(){
		File file = new File("c:\\test\\vince.txt");
		try {
			Writer out = new FileWriter(file);
			// 加缓存
			BufferedWriter bos = new BufferedWriter(out);
			// 增强打印功能
			PrintWriter pw = new PrintWriter(bos);
			pw.println("小河流水天天哗啦啦");
			pw.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
	private static void bytePrint(){
		File file = new File("c:\\test\\vince.txt");
		try {
			OutputStream out = new FileOutputStream(file);
			// 加缓存
			BufferedOutputStream bos = new BufferedOutputStream(out);
			// 增强打印功能
			PrintStream ps = new PrintStream(bos);
			ps.println("小河流水天天哗啦啦");
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// bytePrint();
		charPrint();
	}
}
