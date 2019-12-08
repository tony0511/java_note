package com.qianfeng.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("uname");
		String pwd = request.getParameter("password");
		
		if(name.equals("admin") && pwd.equals("123")){
			// 登录成功，将正确的用户名存到session里
			HttpSession session = request.getSession();
			session.setAttribute("loginname", name);
//			response.sendRedirect(request.getContextPath() + "/MainServlet");
			
			// 如果禁用cookie，encodeURL后，会将sessionid放在url后面
			///day36_session/MainServlet;jsessionid=2761973C39B6683C69C0B8B9B6672CD6
			String newUrl = response.encodeURL(request.getContextPath() + "/MainServlet");
			response.sendRedirect(newUrl);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
