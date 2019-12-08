package com.qianfeng.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.qianfeng.dao.EmployeeDao;
import com.qianfeng.dao.impl.EmployeeDaoImpl;
import com.qianfeng.entity.Employee;
import com.qianfeng.service.EmployeeService;
import com.qianfeng.service.impl.EmployeeServiceImpl;
import com.qianfeng.vo.JsonBean;
import com.qianfeng.vo.PageBean;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService empService = new EmployeeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
//		try{
//			List<Employee> list = empService.findAllEmployee();
//			// 将共享的数据放入请求对象中
//			request.setAttribute("empList", list);
//			// 转发
//			request.getRequestDispatcher("/list.jsp").forward(request, response);
//		}catch(Exception e){
//			HttpSession session = request.getSession();
//			session.setAttribute("errorInfo", e.getMessage());
//			response.sendRedirect(request.getContextPath() + "/error.jsp");
//			return;
//		}
		
		String page = request.getParameter("page");
		
		String realPath = this.getServletContext().getRealPath("/");
		System.out.println(realPath);
		
		JsonBean jb = new JsonBean();
		try{
			PageBean<Employee> bean = empService.findEmpByPage(Integer.parseInt(page));
			jb.setCode(1);
			jb.setInfo(bean);
			
		
		}catch(Exception e){
			jb.setCode(0);
			jb.setInfo(e.getMessage());
			
			return;
		}
		
		String jsonString = JSON.toJSONString(jb);
		response.getWriter().write(jsonString);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
