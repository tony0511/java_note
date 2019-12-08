package com.qianfeng.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.service.GoodsTypeService;
import com.qianfeng.service.impl.GoodsTypeServiceImpl;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VGoodsType;

/**
 * Servlet implementation class SearchTypeServlet
 */
@WebServlet("/searchType")
public class SearchTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodsTypeService typeService = new GoodsTypeServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String level = request.getParameter("level");
		String typeName = request.getParameter("typename");
		Map<String, Object> infos = new HashMap<>();
		
		if(level != null && !level.equals("")){
			infos.put("level", Integer.parseInt(level));
		}
		if(typeName != null && !typeName.equals("")){
			infos.put("typename", "%" + typeName + "%");
		}
		
		try {
			List<VGoodsType> list = typeService.search(infos);
			JsonUtils.bean2Json(1, list, response);
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
