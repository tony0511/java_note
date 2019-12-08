package com.qianfeng.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	private FilterConfig config = null;
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		// 获取请求的路径
		String uri = req.getRequestURI();
		
		String infos = this.config.getInitParameter("passinfo");
		String[] split = infos.split(",");
		boolean flag = false;
		for (String string : split) {
			
			if(uri.contains(string)){
				flag = true;
				break;
			}
		}
		if(flag){
			// 如果是需要直接访问的资源，直接放行
			chain.doFilter(request, response);
		}else{
			// 如果不是，需要判断是否登录过
			HttpSession session = req.getSession(false);
			if(session == null){
				session = req.getSession();
				//跳转到登录页面
				res.sendRedirect(req.getContextPath() + "/login.jsp");
			}else{
				String name = (String)session.getAttribute("loginInfo");
				if(name == null || name.equals("")){
					//跳转到登录页面
					res.sendRedirect(req.getContextPath() + "/login.jsp");
				}else{
					chain.doFilter(request, response);
				}
			}
			
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = fConfig;
	}

}
