package com.qf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // response.getWriter().append("Served at: ").append(request.getContextPath());
		// 获取参数
	  // 方式一
	  // String req = request.getQueryString();
	  // System.out.println(req);
	  // System.out.println(URLDecoder.decode(req, "utf-8"));
	  // 方式二
    // tomcat8下，get方式提交的数据不存在中文乱码问题
    // 针对post方式，tomcat 默认使用 iso-8859-1 的编码，表单提交的数据，使用 utf-8 编码
    request.setCharacterEncoding("utf-8");
     String name = request.getParameter("uname");
     String password = request.getParameter("password");
    // name = new String(name.getBytes("iso-8859-1"), "utf-8");
    // System.out.println(name + " --- " + password);
    // 获取其他请求信息
    System.out.println(request.getMethod()); // 获取提交方式 POST
    System.out.println(request.getContextPath()); // 获取 web 应用的路径 /web_demo2
    System.out.println(request.getRequestURL()); // 获取请求路径 http://localhost:8080/web_demo2/Servlet
    System.out.println(request.getRequestURI()); // 获取请求路径，不包括 host，/web_demo2/Servlet
    if (name.equals("admin") && password.equals("123")) {
      response.setStatus(302); // 重定向
      response.setHeader("location", request.getContextPath() +  "/index.html");
    } else {
      response.setStatus(302);
      response.setHeader("location", request.getContextPath() +  "/error.html");
    }

    // === 转发 ===
    // request.getRequestDispatcher("/index.html").forward(request, response);
    // 指定返回的 MIME 数据类型为 text/html
    // response.setContentType("text/html;charset=utf-8");
    // PrintWriter writer = response.getWriter();
    // writer.write("<html><head></head><body><font color='color'>今天周五，明天休息lalala</font></body></html>");
    // 定时刷新，时间间隔单位秒
    // response.setContentType("text/plain;charset=utf-8");
    // response.setHeader("refresh", "1");
    // response.setHeader("refresh", "3;url=/day34_web2/index.html");
    // response.getWriter().write("定时跳转lalala");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 获取请求的输入流
	  // 方式一
    // ServletInputStream inputStream = request.getInputStream();
    // byte[] buff = new byte[1024];
    // int len = inputStream.read(buff);
    // String info = URLDecoder.decode(new String(buff, 0, len), "utf-8");
    // System.out.println(info);
    // 方式二
    doGet(request, response);
	}
}
