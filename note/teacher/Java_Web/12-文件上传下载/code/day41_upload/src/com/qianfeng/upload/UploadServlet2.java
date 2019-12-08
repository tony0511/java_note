package com.qianfeng.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet2
 */
public class UploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet2() {
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
						System.out.println(fileItem.getString("utf-8"));
						//System.out.println(fileItem.getString());
						System.out.println(fileItem.getFieldName());
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
					}
				}
				
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
