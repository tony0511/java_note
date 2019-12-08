package com.vince;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

/**
 * 转换流
 * OutputStreamWriter：可以将输出的字符流转换为字节流的输出形式
   InputStreamReader：将输入的字节流转换为字符流输入形式
 * @author vince
 * @description
 */
public class ChangeStreamDemo {
	private static void write(OutputStream out){
		Writer writer = new OutputStreamWriter(out, Charset.defaultCharset());
		try {
			writer.write("开开心心来玩耍\r\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void read(InputStream in){
		Reader reader = new InputStreamReader(in, Charset.defaultCharset());
		char[] cs = new char[1024];
		int len = -1;
		try {
			while((len = reader.read(cs)) != -1){
				System.out.println(new String(cs, 0, len));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		// 字节输出流 转 字符输出流
		OutputStream out = new FileOutputStream("c:\\test\\vince.txt");
		write(out);
		// 字节输入流 转 字符输入流
		InputStream in = new FileInputStream("c:\\test\\vince.txt");
		read(in);
	}
}
