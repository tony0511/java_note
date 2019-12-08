package com.qianfeng.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qianfeng.entity.GoodsType;
import com.qianfeng.service.GoodsTypeService;
import com.qianfeng.service.impl.GoodsTypeServiceImpl;
import com.qianfeng.utils.JsonUtils;

/**
 * Servlet implementation class AddGoodsTypeServlet
 */
@WebServlet("/addType")
public class AddGoodsTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GoodsTypeService typeService = new GoodsTypeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGoodsTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		GoodsType type = new GoodsType();
		try {
			// 设置对象中属性
			BeanUtils.populate(type, request.getParameterMap());
			typeService.addType(type);
			
			JsonUtils.bean2Json(1, null, response);
			
		} catch (Exception e) {
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
