package com.qianfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseServlet
 */
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		// 指定返回数据的格式和编码
		// text/html 表示html中的文本格式
		response.setContentType("text/html;charset=utf-8");
		
		//PrintWriter writer = response.getWriter();
		//writer.write("hello");
		
		//writer.write("<html><head></head><body><font color='color'>今天周五，明天休息</font></body></html>");
	
		
		// 理解、了解
		// 302重定向
		//response.setStatus(302);
		// 设置location响应头
		//response.setHeader("location", "/day34_web2/index.html");
		
		// 定时刷新，时间间隔单位秒
		//response.setHeader("refresh", "1");
		response.setHeader("refresh", "3;url=/day34_web2/index.html");
		response.getWriter().write("定时跳转");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
