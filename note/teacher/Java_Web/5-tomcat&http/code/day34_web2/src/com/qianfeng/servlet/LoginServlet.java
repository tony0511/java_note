package com.qianfeng.servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
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
    // get提交方式调用
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		// http://localhost:8080/day34_web2/LoginServlet?uname=qwe&uname=123
		// 获取get提交方式的请求参数
		String queryString = request.getQueryString();
		System.out.println(queryString);
		
		// URL解码
		String info = URLDecoder.decode(queryString, "utf-8");
		System.out.println(info);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		// 获取请求的输入流
		ServletInputStream inputStream = request.getInputStream();
		byte[] buff = new byte[1024];
		int len = inputStream.read(buff);
		String info = new String(buff, 0, len);
		System.out.println(info);
		
	}

}
