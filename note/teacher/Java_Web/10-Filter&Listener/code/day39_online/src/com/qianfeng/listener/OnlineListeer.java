package com.qianfeng.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnlineListeer
 *
 */
public class OnlineListeer implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public OnlineListeer() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	
    	HttpSession session = se.getSession();
    	String info = (String)session.getAttribute("loginInfo");
    	if(info != null && !info.equals("")){
    		// session销毁时，删除登录列表中的用户
    		List<Map<String, Object>> list = (List<Map<String, Object>>)session.getServletContext().getAttribute("ulist");
    		for (Map<String, Object> map : list) {
				if(map.get("name").equals(info)){
					list.remove(map);
					break;
				}
    			
			}
    		
    	}
    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent sbe)  { 
         // TODO Auto-generated method stub
    	// 登录成功，向sessin中存放登录数据时，触发监听器操作，将数据放入ServletContext的ulist
    	String name = sbe.getName();
    	String v = (String)sbe.getValue();
    	
    	List<Map<String, Object>> list = (List<Map<String, Object>>)sbe.getSession().getServletContext().getAttribute("ulist");
    	if(name.equals("loginInfo")){
    		Map<String, Object> map = new HashMap<>();
    		map.put("name", v);
    		map.put("sessionid", sbe.getSession().getId());
    		list.add(map);
    	}
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	// ServletContext创建时，将存放在线用户的空的列表，存放到ServletContext中
    	List<Map<String, Object>> list = new ArrayList<>();
    	sce.getServletContext().setAttribute("ulist", list);
    	
    }
	
}
