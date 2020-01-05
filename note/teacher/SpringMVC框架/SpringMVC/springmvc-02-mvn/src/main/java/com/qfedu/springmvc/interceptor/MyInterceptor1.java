package com.qfedu.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor1 implements HandlerInterceptor{

	/**
	 * 在执行 Handler 之前执行，用于身份校验，权限认证，
	 * 
	 * 返回 true 表示放行
	 * 返回 false 表示拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle1");
		System.out.println(request.getRequestURL());
		return true;
	}

	/**
	 * 在执行Handler时返回ModelAndView之前执行
	 * 如果想要向页面提供一些公共数据或者一些公用的配信息，可以考虑使用这里的modelAndView对象
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle1");
	}

	/**
	 * 在执行Handler之后执行
	 * 日志，系统性能分析
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion1");
	}

}
