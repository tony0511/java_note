package com.vince;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * File类的使用
 * @author vince
 * @description
 */
public class FileDemo {
	public static void main(String[] args) {
		// File类表示一个文件或目录
		// C:\\test\\vince.txt
		File f1 = new File("c:" + File.separator + "test" + File.separator + "vince.txt");
		if(!f1.exists()){ // 判断文件是否存在
			try {
				f1.createNewFile(); // 创建文件
				System.out.println("文件创建成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("是否为文件：" + f1.isFile());
		System.out.println("是否为文件夹：" + f1.isDirectory());

		File f2 = new File("c:\\test\\my");
		boolean b = f2.delete(); // 删除文件
		String[] names = f2.list(); // 列出当前目录下的所有文件名
		System.out.println(Arrays.toString(names));

		File[] fs = f2.listFiles(); // 列出当前目录下的所有文件，以file对象返回
		for(File f: fs){
			System.out.println("length=" + f.length()); // 文件长度
			System.out.println("name=" + f.getName()); // 文件名
			System.out.println("相对路径=" + f.getPath()); // 相对于项目
			System.out.println("绝对路径=" + f.getAbsolutePath());
			System.out.println("是否为隐藏文件=" + f.isHidden());
			System.out.println("是否可读文件=" + f.canRead());
			Date date = new Date(f.lastModified()); // 文件最后修改时间
			DateFormat df = new SimpleDateFormat("HH:mm:ss");
			System.out.println("文件最后修改的时间=" + df.format(date));
		}

		File f3 = new File("temp.txt");
		System.out.println(f3.getPath()); // 获取相对路径
		System.out.println(f3.getAbsolutePath()); // 获取绝对路径

		File f4 = new File("c:\\test\\dabin1");
		f4.mkdirs(); // 新建文件夹
		// f4.renameTo(new File("c:\\test\\dabin2")); // 重命名文件
		f4.renameTo(new File("c:\\dabin1")); // 移动文件

		// 添加文件过滤条件
		File f5 = new File("c:\\test\\my");
		// File[] files = f5.listFiles(new FileFilter() {
		// 	@Override
		// 	public boolean accept(File pathname) {
		// 		return pathname.getName().endsWith(".txt");
		// 	}
		// });
		File[] files = f5.listFiles((pathname) -> pathname.getName().endsWith(".txt"));
		for(File f:files){
			System.out.println(f.getName());
		}
	}
}
