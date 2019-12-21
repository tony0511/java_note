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

public class UploadServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  public UploadServlet3() {
     super();
  }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 创建 FileItem 对象的工厂对象
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 穿创建文件上传处理对象
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		// 判断表单数据类型是否为 multipart/form-data 类型
		if(ServletFileUpload.isMultipartContent(request)){
			// 对提交的数据进行解析
			try {
				// 解析请求数据
				List<FileItem> list = fileUpload.parseRequest(request);
				for (FileItem fileItem : list) {
					// 判断数据是否一般数据还是文件对象
					if (fileItem.isFormField()) {
						// 获取字段名
						System.out.println(fileItem.getFieldName());
						// 获取字段值
						//System.out.println(fileItem.getString());
						// 指定编码方式，解决中文乱码问题
						System.out.println(fileItem.getString("utf-8"));
					} else {
						// 获取文件名
						String name = fileItem.getName();
						// 将文件上传到服务器的 D:/upload文件夹下
						// String path = "D:/upload";
						// 获取服务器上，web 应用目录下的 upload 文件夹所在的绝对路径
						String path = this.getServletContext().getRealPath("/");
						System.out.println(path);
						// 如果路径不存在，创建
						File file = new File(path);
						// 获取父路径，和 upload 文件夹组成一个新路径，即文件上传到 D:/..../webapps/upload目录下
						file =  new File(file.getParent() + "/upload");
						if(!file.exists()){
							file.mkdirs();
						}
						// 获取全球唯一id（避免重名文件被替换）
						String uuid = UUID.randomUUID().toString();
						name = uuid + "_" + name;
						// 根据路径和文件名创建对象
						File newFile = new File(file.getAbsolutePath(), name);
						// 保存文件
						fileItem.write(newFile);
						// 删除缓存中数据
						fileItem.delete();
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
