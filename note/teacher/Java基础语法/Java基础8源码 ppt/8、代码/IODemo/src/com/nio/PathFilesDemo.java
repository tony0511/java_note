package com.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

/**
 * JDK1.7新的文件操作类 Path接口 Paths类 Files类
 *
 * @author vince
 * @description
 */
public class PathFilesDemo {
	public static void main(String[] args) {
		File file = new File("c:\\test\\3D0.jpg");
		// === Path, Paths ===
		Path p1 = Paths.get("c:\\test", "3D0.jpg"); // c:\test\3D0.jpg
		Path p2 = file.toPath(); // c:\test\3D0.jpg
		// 其实 Paths.get() 内部就是采用 FileSystems.getDefault().getPath() 来获取Path的
		Path p3 = FileSystems.getDefault().getPath("c:\\test", "3D0.jpg"); // c:\test\3D0.jpg
		// Files工具类
		Path p4 = Paths.get("c:\\test\\vince.txt");
		String info = "村花到我家，一起...";
		// 写入文件
		try {
			Files.write(p4, info.getBytes("gb2312"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 读取文件
		try {
			byte[] bytes = Files.readAllBytes(p4);
			System.out.println(new String(bytes));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 复制文件
		try {
			Files.copy(p3, Paths.get("c:\\3D0.jpg"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 移动文件
		try {
			Files.move(p3, Paths.get("c:\\3D0.jpg"),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 删除文件
		try {
			Files.delete(p3); // static boolean deleteIfExists(Path path)
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 创建新目录，除了最后一个部件，其他必须是已存在的
		try {
			Files.createDirectory(Paths.get("c:\\BB"));
			// Files.createDirectories(path); // 创建多级不存在的目录
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 创建文件
		try {
			Files.createFile(Paths.get("c:\\BB.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 添加前/后缀创建临时文件或临时目录
		Path newPath = Files.createTempFile(dir, prefix, suffix);
		Path newPath = Files.createTempDirectory(dir, prefix);
	}
}
