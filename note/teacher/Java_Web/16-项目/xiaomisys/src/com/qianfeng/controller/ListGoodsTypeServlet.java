package com.qianfeng.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.entity.GoodsType;
import com.qianfeng.service.GoodsTypeService;
import com.qianfeng.service.impl.GoodsTypeServiceImpl;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VGoodsType;

/**
 * Servlet implementation class ListGoodsTypeServlet
 */
@WebServlet("/listType")
public class ListGoodsTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GoodsTypeService typeService = new GoodsTypeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListGoodsTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String type = request.getParameter("type");
		
		try {
			if(type.equals("1")){
				List<GoodsType> list = typeService.findTypeByLevel(1);
				JsonUtils.bean2Json(1, list, response);
			}else if(type.equals("2")){
				List<GoodsType> list = typeService.findTypeByLevel(2);
				JsonUtils.bean2Json(1, list, response);
			}else{
				//0
				List<VGoodsType> list = typeService.findAllType();
				JsonUtils.bean2Json(1, list, response);
				
			}
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
