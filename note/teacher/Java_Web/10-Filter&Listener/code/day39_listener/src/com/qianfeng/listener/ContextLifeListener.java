package com.qianfeng.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class ContextLifeListener
 *
 */
// 随着tomcat启动，创建Listener对象
public class ContextLifeListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextLifeListener() {
        // TODO Auto-generated constructor stub
    	System.out.println("context listener constructor");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    //  ServletContext销毁时，会调用该方法
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("context destroy");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    // ServletContext创建时会调用该方法
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("context init");
    }
	
}
