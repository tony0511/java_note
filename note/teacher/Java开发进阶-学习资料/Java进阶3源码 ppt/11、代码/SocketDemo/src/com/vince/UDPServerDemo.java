package com.vince;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.SAXConnector;
import java.io.IOException;
import java.net.*;

/**
 * Created by vince on 2017/6/7.
 */
public class UDPServerDemo {
  public static void main(String[] args) {
    String info = "good good 学习，天天 UP";
    byte[] bytes = info.getBytes();
    try {
      // 封装一个数据报包
      /*
      buf - 数据包数据。
      offset - 分组数据偏移量。
      length - 分组数据长度。
      address - 目的地址。
      port - 目的端口号。
       */
      DatagramPacket dp = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("127.0.0.1"), 8000);
      // 本程序的端口
      DatagramSocket socket = new DatagramSocket(9000);
      socket.send(dp);
      socket.close();
    } catch (UnknownHostException|SocketException|IOException e){
      e.printStackTrace();
    }
  }
}
