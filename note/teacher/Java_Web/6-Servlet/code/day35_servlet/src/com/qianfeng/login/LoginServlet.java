package com.qianfeng.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
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
		
		
		String name1 = PropUtils.getUserName();
		String pwd1 = PropUtils.getPassword();
		
		if(name.equals(name1) && pwd.equals(pwd1)){
			response.setStatus(302);
			//request.getContextPath() 获取web应用的路径
			response.setHeader("location", request.getContextPath() +  "/index.html");
		}else{
			response.setStatus(302);
			//request.getContextPath() 获取web应用的路径
			response.setHeader("location", request.getContextPath() +  "/error.html");
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
