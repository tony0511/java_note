package com.qianfeng.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttrListener implements HttpSessionAttributeListener {
  // 随着 tomcat 启动，创建 Listener 对象
  public SessionAttrListener() {
  }
  // session 添加属性时触发
  public void attributeAdded(HttpSessionBindingEvent sb)  {
    // 获取添加的数据
    String name = sb.getName();
    Object value = sb.getValue();
    System.out.println(name);
    System.out.println(value);
  }
  // session 删除属性时触发
  public void attributeRemoved(HttpSessionBindingEvent sb)  {
    System.out.println(sb.getName());
    System.out.println(sb.getValue());
  }
  // session 修改属性时触发
  public void attributeReplaced(HttpSessionBindingEvent sb)  {
    // 获取到的是替换之前的值
    System.out.println(sb.getName());
    System.out.println(sb.getValue());
    // 先获取 session 对象，再获取替换后的新值
    HttpSession session = sb.getSession();
    System.out.println(session.getAttribute(sb.getName()));
  }
}
