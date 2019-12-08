package com.vince;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件的复制：
 * 从一个输入流中读取数据，然后通过输出流写入目标位置
 * 一边读一边写
 * @author vince
 * @description
 */
public class CopyFileDemo {

	public static void main(String[] args) {
		System.out.println("start copy...");
		copy("c:\\mm.jpg","C:\\test\\mm.jpg");
		System.out.println("copy success.");
	}

	private static void copy(String src,String target){
		File srcFile = new File(src);
		File targetFile = new File(target);
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(targetFile);

			byte[] bytes = new byte[1024];
			int len = -1;
			while((len=in.read(bytes))!=-1){
				out.write(bytes, 0, len);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(in!=null)in.close();
				if(out!=null)out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
