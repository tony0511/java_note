package com.qianfeng.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionLifeListener implements HttpSessionListener {
  // 随着 tomcat 启动，创建 Listener 对象
  public SessionLifeListener() {
  }
  // session 创建时触发
  public void sessionCreated(HttpSessionEvent arg0)  {
    System.out.println("session create");
  }
  // session 销毁时触发
  public void sessionDestroyed(HttpSessionEvent arg0)  {
    System.out.println("session destroy");
  }
}
