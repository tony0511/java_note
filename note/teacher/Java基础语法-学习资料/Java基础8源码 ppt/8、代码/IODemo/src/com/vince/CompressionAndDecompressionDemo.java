package com.vince;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 压缩与解压缩
 * @author vince
 * @description
 */
public class CompressionAndDecompressionDemo {
	// === 压缩 ===
	private static void compression(String zipFileName, File targetFile){
		System.out.println("正在压缩...");
		try {
			// 构造压缩的输出流
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
			BufferedOutputStream bos = new BufferedOutputStream(out);
			zip(out, targetFile, targetFile.getName(), bos);
			bos.close();
			out.close();
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
		System.out.println("压缩完成");
	}
	// zip
	private static void zip(ZipOutputStream zOut, File targetFile, String name, BufferedOutputStream bos) throws IOException {
		if (targetFile.isDirectory()) { // 如果是个目录
			File[] files = targetFile.listFiles();
			if(files.length == 0){ // 处理空目录
				zOut.putNextEntry(new ZipEntry(name + "/"));
			}
			for (File f: files) { // 递归处理
				zip(zOut, f, name + "/" + f.getName(), bos);
			}
		} else { // 处理文件
			zOut.putNextEntry(new ZipEntry(name));
			InputStream in = new FileInputStream(targetFile);
			BufferedInputStream bis = new BufferedInputStream(in);
			byte[] bytes = new byte[1024];
			int len = -1;
			while((len = bis.read(bytes)) != -1){
				bos.write(bytes, 0, len);
			}
			bis.close();
		}
	}
	// === 解压 ===
	private static void decompression(String targetFileName, String parent){
		try {
			// 构造解压的输入流
			ZipInputStream zIn = new ZipInputStream(new FileInputStream(targetFileName));
			ZipEntry entry = null;
			File file = null;
			while((entry = zIn.getNextEntry()) != null && !entry.isDirectory()){
				file = new File(parent, entry.getName());
				if(!file.exists()){
					new File(file.getParent()).mkdirs(); // 创建此文件的上级目录
				}
				OutputStream out = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				byte[] bytes = new byte[1024];
				int len = -1;
				while((len = zIn.read(bytes)) != -1){
					bos.write(bytes, 0, len);
				}
				bos.close();
				System.out.println(file.getAbsolutePath() + " 解压成功");
			}
		} catch (FileNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// compression("c:\\test.zip", new File("c:\\test"));
		decompression("c:\\test.zip", "C:\\QMDownload\\");
	}
}
