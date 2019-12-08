package com.qianfeng.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.entity.GoodsType;
import com.qianfeng.service.GoodsTypeService;
import com.qianfeng.service.impl.GoodsTypeServiceImpl;
import com.qianfeng.utils.JsonUtils;

/**
 * Servlet implementation class QueryTypeServlet
 */
@WebServlet("/queryType")
public class QueryTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GoodsTypeService typeService = new GoodsTypeServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		
		try {
			GoodsType type = typeService.findTypeById(Integer.parseInt(id));
			JsonUtils.bean2Json(1, type, response);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JsonUtils.bean2Json(0, e.getMessage(), response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
