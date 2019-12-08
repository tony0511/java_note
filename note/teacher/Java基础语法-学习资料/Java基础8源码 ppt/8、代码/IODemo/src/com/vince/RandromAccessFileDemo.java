package com.vince;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandromAccessFile
 * @author vince
 * @description
 */
public class RandromAccessFileDemo {
	public static void main(String[] args) {
		try {
			// 读取文件
			RandomAccessFile r = new RandomAccessFile("c:\\3D0.jpg", "r");
			// 写入文件
			RandomAccessFile w = new RandomAccessFile("c:\\test\\3D0.jpg", "rw");
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len = r.read(bytes)) != -1){
				w.write(bytes,0,len);
			}
			w.close();
			r.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
}
