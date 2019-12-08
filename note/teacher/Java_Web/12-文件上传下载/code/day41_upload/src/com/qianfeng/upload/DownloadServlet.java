package com.qianfeng.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fileName = request.getParameter("file");
		System.out.println(fileName);
		
		// 文件的输入流
		FileInputStream inputStream = new FileInputStream(new File("D:/upload", fileName));
		
		// 对路径进行url编码，会将空格等特殊字符转换为%的形式
		fileName = URLEncoder.encode(fileName, "utf-8");
	
		// 设置响应头，记录要下载的文件的文件名
		response.setHeader("Content-Disposition","attachment;filename=" + fileName);
		
		// 响应的输出流对象
		ServletOutputStream outputStream = response.getOutputStream();
		byte[] buff = new byte[512];
		int len = -1;
		while((len = inputStream.read(buff)) != -1){
			outputStream.write(buff, 0, len);
		}
		
		inputStream.close();
		outputStream.close();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
