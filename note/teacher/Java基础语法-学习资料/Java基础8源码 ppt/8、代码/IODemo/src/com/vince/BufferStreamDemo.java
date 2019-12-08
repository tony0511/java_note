package com.vince;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * 缓存的目的：
 * 解决在写入文件操作时，频繁的操作文件所带来的性能降低的问题，
 * BufferedOutputStream 内部默认的缓存大小是8KB，每次写入时存储到缓存中的byte数组中，当数组存满时，会把数组中的数据写入文件，
 * 并且缓存下标归零
 *
 * 字符流
 * 1、加入字符缓存流，增强读取功能（readLine）
 * 2、更高效的读取数据
 * FileReader: 内部使用InputStreamReader( sun.nio.cs.StreamDecoder),解码过程，byte->char，默认缓存大小是8K
 * BufferedReader:默认缓存大小是8K，但可以手动指定缓存大小，把数据进接读取到缓存中，减少每次转换过程,效率更高
 * BufferedWriter 同上
 *
 * @author vince
 * @description
 */
public class BufferStreamDemo {
	private static void charReader(){
		File file = new File("c://test//vince.txt");
		try {
			Reader reader = new FileReader(file);
			// 构造一个字符缓冲输入流
			BufferedReader br = new BufferedReader(reader);
			char[] cs = new char[1024];
			int len = -1;
			while((len = br.read(cs)) != -1){
				System.out.println(new String(cs, 0, len));
			}
			br.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
	private static void charWriter(){
		File file = new File("c://test//vince.txt");
		try {
			Writer writer = new FileWriter(file);
			// 构造一个字符缓冲输出流
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("村花到我家");
			bw.flush();
			bw.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
	private static void byteReader2(){
		File file = new File("c://test//vince.txt");
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len = bis.read(bytes)) != -1){
				System.out.println(new String(bytes,0,len));
			}
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
	private static void byteReader(){
		File file = new File("c://test//vince.txt");
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
		// try {
		// 	InputStream in = new FileInputStream(file);
		// 	// 构造一个字节缓冲输入流
		// 	BufferedInputStream bis = new BufferedInputStream(in);
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len = bis.read(bytes)) != -1){
				System.out.println(new String(bytes, 0, len));
			}
			// bis.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
	private static void byteWriter(){
		File file = new File("c://test//vince.txt");
		try {
			OutputStream out = new FileOutputStream(file);
			// 构造一个字节缓冲输出流
			BufferedOutputStream bos = new BufferedOutputStream(out);
			String info = "小河还是流水哗啦啦";
			bos.write(info.getBytes());
			bos.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// byteWriter();
		byteReader();
	}
}
