package com.qianfeng.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qianfeng.dao.EmployeeDao;
import com.qianfeng.dao.impl.EmployeeDaoImpl;
import com.qianfeng.entity.Employee;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String id = request.getParameter("id");
		
		EmployeeDao empDao = new EmployeeDaoImpl();
		
		Employee emp1 = empDao.findById(Integer.parseInt(id));
		if(emp1 != null){
			Employee emp = new Employee(Integer.parseInt(id), name, sex, Integer.parseInt(age), phone);
			empDao.update(emp);
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("errorInfo", "员工不存在，不能删除");
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			return;
		}
		
		
	
		response.sendRedirect(request.getContextPath() + "/list");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
