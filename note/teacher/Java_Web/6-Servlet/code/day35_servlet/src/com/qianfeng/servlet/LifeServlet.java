package com.qianfeng.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeServlet
 */
public class LifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public LifeServlet() {
    System.out.println("life constructor 构造实例"); // 只会执行一次（启动服务或第一次调用时）
    super();
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
  	System.out.println("life init 初始化"); // 只会执行一次（启动服务或第一次调用时）
  	super.init(config);
  }

  @Override
  protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
  	System.out.println("life service"); // 每次访问都会调用
  	// 根据提交方式，确定调用 doGet 还是 doPost 方法
  	super.service(arg0, arg1);
  }

  @Override
  public void destroy() {
  	System.out.println("life destory 销毁实例"); // 只会执行一次（关闭服务或重启服务时）
  	super.destroy();
  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		doGet(request, response);
	}

}
