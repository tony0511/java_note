package com.vince.mina;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by vince on 2017/6/8.
 */
public class Server {
  public static void main(String[] args) {
    // 创建一个非阻塞的 Server 端 Socket NIO
    SocketAcceptor acceptor = new NioSocketAcceptor();
    // 获取过滤链
    DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
    // 设定一个过滤器，一行一行的读取数据（即以 /r/n 结尾，myChin 为过滤器的一个标识名）
    // chain.addLast("myChin", new ProtocolCodecFilter(new TextLineCodecFactory()));
    // 设定一个过滤器，以对象为单位读取数据(objectFilter 为过滤器的一个标识名)
    chain.addLast("objectFilter", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
    // 设置服务端的消息处理器
    acceptor.setHandler(new MinaServerHandler());
    int port = 9999; // 服务器的端口号
    try {
      // 绑定端口，启动服务器(不会阻塞，立即返回)
      acceptor.bind(new InetSocketAddress(port));
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("Mina Server running, listener on : " + port);
  }
}
