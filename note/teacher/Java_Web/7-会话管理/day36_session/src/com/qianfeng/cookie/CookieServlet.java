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
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 创建 cookie 对象（注：cookie 数据不支持中文）
		Cookie cookie = new Cookie("name", "zhangsan");
		// 设置到期时间，单位秒
		cookie.setMaxAge(60 * 60);
		// 到期时间，设为负值，浏览器会话结束时
		// cookie2.setMaxAge(-1);
		// 设置路径，如果路径和应用的名字不同，不会自动发送某些 cookie，默认发送本应用下的 cookie 数据
		// 路径设置为 / 后，相应站点下的任意 web 应用都可以共享某些 cookie
		cookie.setPath("/");
		// 将 cookie 发送给浏览器端
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
