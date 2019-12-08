package com.qianfeng.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 创建cookie对象
		Cookie cookie = new Cookie("name", "zhangsan");
		
		// 设置到期时间，单位秒
		cookie.setMaxAge(60 * 60);
		
		// 将cookie发送给浏览器端
		response.addCookie(cookie);
		
		// cookie中数据不支持中文
//		Cookie cookie2 = new Cookie("hobby", "抽烟");
//		response.addCookie(cookie2);
		
		Cookie cookie2 = new Cookie("age", "10");
		// 设置路径，如果路径和应用的名字不同，访问应用中的资源时，不会自动发送某些cookie
		// 只会发送本应用下的cookie数据
		// 路径设置为/ 后，相应站点下的任意web应用都可以共享某些cookie
		cookie2.setPath("/");
		// 到期时间，设为负值，浏览器会话结束时
		cookie2.setMaxAge(-1);
		response.addCookie(cookie2);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
