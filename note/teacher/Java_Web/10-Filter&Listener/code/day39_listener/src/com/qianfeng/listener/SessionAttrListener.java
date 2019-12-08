package com.qianfeng.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class SessionAttrListener
 *
 */
public class SessionAttrListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public SessionAttrListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent sb)  { 
         // TODO Auto-generated method stub
    	// 获取添加的数据
    	String name = sb.getName();
    	Object value = sb.getValue();
    	//instanceof
    	System.out.println(name);
    	System.out.println(value);
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent sb)  { 
         // TODO Auto-generated method stub
    	System.out.println(sb.getName());
    	System.out.println(sb.getValue());
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    // 更新
    public void attributeReplaced(HttpSessionBindingEvent sb)  { 
         // TODO Auto-generated method stub
    	// 获取到的是替换之前的值
    	System.out.println(sb.getName());
    	System.out.println(sb.getValue());
    	
    	// 先获取session对象，再获取替换后的新值
    	HttpSession session = sb.getSession();
    	System.out.println(session.getAttribute(sb.getName()));
    }
	
}
