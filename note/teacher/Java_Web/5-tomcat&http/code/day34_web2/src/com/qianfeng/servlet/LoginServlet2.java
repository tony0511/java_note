package com.qianfeng.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//<input type="text" name="uname" />
		// 根据name的值获取请求参数
		
		// tomcat8下，get方式提交的数据不存在中文乱码问题
		// post方式，需要注意中文乱码的问题
		// tomcat 默认使用iso-8859-1的编码，表单提交的数据，使用utf-8编码
		
		// 针对post方式，解决中文乱码问题
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String password = request.getParameter("password");
		
		//name = new String(name.getBytes("iso-8859-1"), "utf-8");
		
		System.out.println(name);
		System.out.println(password);
		
		System.out.println(request.getMethod());// 获取提交方式
		System.out.println(request.getRequestURL());// 获取请求路径
		System.out.println(request.getRequestURI());// 获取请求路径，不包括ip和端口信息
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
