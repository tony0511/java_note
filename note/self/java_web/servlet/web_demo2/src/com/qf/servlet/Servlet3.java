package com.qf.servlet;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet3
 */
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  System.out.println(this.getServletContext().getContextPath());
	  // /web_demo2
	  System.out.println(this.getServletContext().getRealPath("/"));
	  // /Users/tony/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/web_demo2/
	  // enctype="multipart/form-data" 采用如下方式，无法正常读取提交的参数
    String name = request.getParameter("username"); // 结果为 null
    System.out.println(name);
    // 解析数据麻烦
    ServletInputStream inputStream = request.getInputStream();
    byte[] buff = new byte[1024];
    int len = inputStream.read(buff);
    String info = new String(buff, 0, len);
    System.out.println(info);
    response.getWriter().write("");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
