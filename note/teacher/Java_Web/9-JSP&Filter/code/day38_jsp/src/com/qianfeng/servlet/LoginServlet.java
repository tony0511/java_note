package com.qianfeng.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String password = request.getParameter("password");
		String isRemember = request.getParameter("isRemember");
	
		if(isEmpty(name) || isEmpty(password)){
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			return;
		}
		
		if(name.equals("admin") && password.equals("123")){
			
			// 如果选中记住我，将用户名和密码存储到cookie
			if(!isEmpty(isRemember)){
				Cookie cookie = new Cookie("logininfo", name + "," + password);
				response.addCookie(cookie);
			}
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			
		}else{
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private boolean isEmpty(String info){
		if(info == null || info.equals("")){
			return true;
		}
		return false;
	}

}
