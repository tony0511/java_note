package com.vince;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SystemRuntimeDemo {

	public static void main(String[] args) {

		System.out.println("向控制台输出");
		System.err.println("出错啦");

		int[] num1 = {1,2,3,4,5,6,7,8};
		int[] num2 = new int[num1.length];
		//参数（源数组，源数组的起始位置 ，目标数组，目标数组的起始位置 ，长度）
		System.arraycopy(num1, 0, num2, 0, num1.length);
		System.out.println(Arrays.toString(num2));


		System.out.println(System.currentTimeMillis());
		Date nowDate = new Date(System.currentTimeMillis());
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		String now = df.format(nowDate);
		System.out.println(now);
		//退出JVM
		//System.exit(0);

		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("os.name"));

		Runtime rt = Runtime.getRuntime();
		System.out.println("处理器数量：" + rt.availableProcessors()+" 个");
		System.out.println("Jvm总内存数 ："+ rt.totalMemory()+" byte");
		System.out.println("Jvm空闲内存数： "+ rt.freeMemory()+" byte");
		System.out.println("Jvm可用最大内存数： "+ rt.maxMemory()+" byte");

		//在单独的进程中执行指定的字符串命令。
		try {
			rt.exec("notepad"); //打开记笔本
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//加载C、C++编写的类库
		//System.loadLibrary(libname)

	}

}
