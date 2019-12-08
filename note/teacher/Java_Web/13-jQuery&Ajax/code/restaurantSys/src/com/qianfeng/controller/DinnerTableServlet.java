package com.qianfeng.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qianfeng.entity.DinnerTable;
import com.qianfeng.service.DinnerTableService;
import com.qianfeng.service.impl.DinnerTableServiceImpl;

/**
 * Servlet implementation class DinnerTableServlet
 */
@WebServlet("/dtable")
public class DinnerTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DinnerTableService tableService = new DinnerTableServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DinnerTableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String method = request.getParameter("method");
		switch(method){
		case "list":
			this.list(request, response);
			break;
		case "add":
			this.add(request, response);
			break;
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		List<DinnerTable> list = tableService.findAllTable();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/detail/boardList.jsp").forward(request, response);
		
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//request.getParameter("name");
		DinnerTable dt = new DinnerTable();
		// 实现对象属性的赋值
		try {
			BeanUtils.populate(dt, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tableService.addTable(dt);
		
		response.sendRedirect(request.getContextPath() + "/dtable?method=list");
	}

}
