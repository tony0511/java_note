package com.vince;

import java.io.*;
import java.net.Socket;

/**
 * Created by vince on 2017/6/6.
 */
public class EchoClientDemo {
  public static void main(String[] args) {
    // 创建一个Socket对象，指定要连接的服务器
    try {
      Socket socket = new Socket("localhost", 6666);
      // 获取socket的输入输出流
      PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
      BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      ps.println("hello,my name is Bin"); // 向服务端发送数据
      ps.flush(); // 刷新流
      // 读取服务器端返回的数据(该例中服务端 println 方法发送的数据)，如果没有数据，那么会阻塞
      String info = br.readLine();
      System.out.println(info);
      ps.close(); // 关闭流
      br.close(); // 关闭流
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
