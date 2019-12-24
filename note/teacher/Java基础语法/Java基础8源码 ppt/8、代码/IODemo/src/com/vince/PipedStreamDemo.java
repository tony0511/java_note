package com.vince;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
/**
 * 管道流测试：一个线程写入，一个线程读取
 * 作用，用于线程之间的数据通讯
 * @author vince
 * @description
 */
public class PipedStreamDemo {
	public static void main(String[] args) {
		PipedInputStream pin = new PipedInputStream();
	  PipedOutputStream pout = new PipedOutputStream();
	  try {
			pin.connect(pout); // 两个管道进行链接
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 输入流与输出流连接
    ReadThread readTh   = new ReadThread(pin);
    WriteThread writeTh = new WriteThread(pout);
    new Thread(readTh).start();
    new Thread(writeTh).start();
	}
}
// 读取数据的线程
class ReadThread implements Runnable {
	private PipedInputStream pin; // 输入管道
	ReadThread(PipedInputStream pin){
		this.pin = pin;
	}
	public void run(){
		try {
			byte[] buf = new byte[1024];
			int len = pin.read(buf); // read阻塞
			String s = new String(buf, 0, len);
			System.out.println("读到：" + s);
			pin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
// 写入数据的线程
class WriteThread implements Runnable {
	private PipedOutputStream pout; // 输出管道
	WriteThread(PipedOutputStream pout) {
		this.pout = pout;
	}
	public void run() {
		try {
			pout.write("一个美女...".getBytes()); // 管道输出流
			pout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}