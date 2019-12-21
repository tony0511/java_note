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

		// 创建 session 对象
		// 根据 sessionid 找是否存在相关的 session 对象，如果存在则返回，如果不存在则创建
		HttpSession session = request.getSession();
		// 获取 session 对象的最近访问时间
		long lastAccessedTime = session.getLastAccessedTime();
		System.out.println(lastAccessedTime);
		// 设置最大不活动时间间隔，单位秒，默认30分钟
		session.setMaxInactiveInterval(20 * 60);
		// 获取sessionid
		System.out.println(session.getId());
		// =====================================
		// 默认 JSESSIONID 设置到浏览器的 httpOnly 属性值为 true，path 属性值为 当前应用。如果需要重写 JSESSIONID 的 cookie 属性则如下
		// 新建 cookie，存储 sessionid 的值
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setPath("/");
		cookie.setMaxAge(30 * 60);
		// 只能通过 http 协议获取 cookie，不能通过 js 中的 document.cookie 获取 cookie
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		// =====================================
		Cookie cookie2 = new Cookie("name", "haha");
		cookie2.setMaxAge(30 * 60);
		response.addCookie(cookie2);
		// 作为域对象使用，只要 session 对象存在，通过 sessionid 能找到对应的 session 对象，就可以共享其中的数据
		// 设置 session 域中的值
		session.setAttribute("name", "zhangsan");
		// 获取 session 域中的值
		System.out.println(session.getAttribute("name"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
