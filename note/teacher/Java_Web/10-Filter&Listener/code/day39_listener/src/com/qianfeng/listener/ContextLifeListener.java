package com.qianfeng.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLifeListener implements ServletContextListener {
  // 随着 tomcat 启动，创建 Listener 对象
  public ContextLifeListener() {
    System.out.println("context listener constructor");
  }
  // ServletContext 销毁时触发
  public void contextDestroyed(ServletContextEvent arg0)  {
    System.out.println("context destroy");
  }
  // ServletContext 初始化时触发
  public void contextInitialized(ServletContextEvent arg0)  {
    System.out.println("context init");
  }
}
