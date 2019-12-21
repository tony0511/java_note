package com.qianfeng.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextServlet
 */
public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 获取ServletContext对象
		ServletContext servletContext = this.getServletContext();

		//    /W08_2_Servlet
		System.out.println(servletContext.getContextPath());

		//通过request对象，获取应用的路径
		System.out.println(request.getContextPath());


		// 获取应用的路径
		String path = servletContext.getContextPath();
		System.out.println(path);

		// 获取应用的初始化参数
		String pwd = servletContext.getInitParameter("password");
		System.out.println(pwd);

		// 向ServletContext域中存储数据
		servletContext.setAttribute("name", "gugui");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
