package com.qianfeng.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 创建session对象
		// 根据sessionid找是否存在相关的session对象，如果存在，返回，如果不存在，创建
		HttpSession session = request.getSession();
	
		// 获取session对象的最近访问时间
		long lastAccessedTime = session.getLastAccessedTime();
		System.out.println(lastAccessedTime);
		
		// 设置最大不活动时间间隔，单位秒，默认30分钟
		session.setMaxInactiveInterval(20 * 60);
		
		// 获取sessionid
		System.out.println(session.getId());
		
		// 新建cookie，存储sessionid的值
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(30 * 60);
		// 只能通过http协议获取cookie，不能通过js中的document.cookie获取cookie
		// 默认情况下，sessionid发送到浏览器端，设置了该属性
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		
		
		Cookie cookie2 = new Cookie("name", "haha");
		cookie2.setMaxAge(30 * 60);
		response.addCookie(cookie2);
		
		// 作为域对象使用
		// 只要session对象存在，通过sessionid能找到对应的session对象，就可以共享其中的数据
		session.setAttribute("name", "zhangsan");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
