package com.qianfeng.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.qianfeng.entity.Goods;
import com.qianfeng.service.GoodsService;
import com.qianfeng.service.impl.GoodsServiceImpl;
import com.qianfeng.utils.JsonUtils;

/**
 * Servlet implementation class AddGoodsServlet
 */
@WebServlet("/addGoods")
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodsService goodsService = new GoodsServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 对上传的数据进行处理
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		
		Goods f = new Goods();
		// 判断表单enctype="multipart/form-data"
		if(ServletFileUpload.isMultipartContent(request)){
			// 对提交的数据进行解析
			try {
				List<FileItem> list = fileUpload.parseRequest(request);
				for (FileItem fileItem : list) {
					// 判断是否不同控件对应的数据
					if(fileItem.isFormField()){
						// 获取提交的数据
						// 指定编码方式，解决中文乱码问题
						//System.out.println(fileItem.getString("utf-8"));
						//System.out.println(fileItem.getString());
						//System.out.println(fileItem.getFieldName());
						
						// 注册日期转换操作
						ConvertUtils.register(new Converter() {
				            
				            public Object convert(Class type, Object value) {
				                
				            	//System.out.println(type.getName());//Date类型时才会打印
				                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				                
			                    try {
									return simpleDateFormat.parse(value.toString());
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				                
				                return null;
				            }
				        }, Date.class);
						
						BeanUtils.copyProperty(f, fileItem.getFieldName(), fileItem.getString("utf-8"));
						
						
						
					}else{
						// 获取文件名
						String name = fileItem.getName();
						// 将文件上传到服务器的D:/upload文件夹下
						String path = "D:/upload";
						
						// 如果路径不存在，创建
						File file = new File(path);
						if(!file.exists()){
							file.mkdirs();
						}
						// 全球唯一id
						String uuid = UUID.randomUUID().toString();
						name = uuid + "_" + name;
						// 根据路径和文件名创建对象
						File newFile = new File(path, name);
						
						// 保存文件
						fileItem.write(newFile);
						// 删除缓存中数据
						fileItem.delete();
						
						f.setImgPath(name);
					}
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JsonUtils.bean2Json(0, e.getMessage(), response);
				return;
			}
			
		}
	
		try {
			goodsService.addGoods(f);
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
