package com.qianfeng.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter {
	private FilterConfig config = null;
	// 创建 filter 实例，只会在 tomcat 启动时执行一次
  public FirstFilter() {
    System.out.println("filter constructor");
  }
	// 销毁 tomcat 实例，只会在 tomcat 销毁时执行一次
	public void destroy() {
		System.out.println("fileter destroy");
	}
	// 核心方法
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// === 获取请求后服务响应前处理 ===
		request.setCharacterEncoding("utf-8"); // 针对 post 提交方式
		response.setContentType("text/html;charset=utf-8"); // 针对响应
		config.getInitParameter("info");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		// === 放行请求到下一 filter 或到响应处处理，filter 处理顺序为注册时的先后顺序 ===
		chain.doFilter(request, response);
		// === 服务响应后到达客户端前处理 ===
		System.out.println("after pass");
	}
	// 初始化 tomcat 实例，只会在 tomcat 启动后初始化时执行一次
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter init");
		String info = fConfig.getInitParameter("info");
		System.out.println(info);
		config = fConfig;
	}
}
