package com.vince;

import java.io.File;

/**
 * 在指定的目录中查找文件
 * @author vince
 * @description
 */
public class FileDemo2 {

	public static void main(String[] args) {
		findFile(new File("C:\\Users\\vince\\Downloads"),".jpg");
	}

	//查找文件的方法
	private static void findFile(File target,String ext){
		if(target==null)return;
		//如果文件是目录
		if(target.isDirectory()){
			File[] files = target.listFiles();
			if(files!=null){
				for(File f: files){
					findFile(f,ext);//递归调用
				}
			}
		}else{
			//此处表示File是一个文件
			String name = target.getName().toLowerCase();
			//System.out.println(name);
			if(name.endsWith(ext)){
				System.out.println(target.getAbsolutePath());
			}
		}
	}

}
