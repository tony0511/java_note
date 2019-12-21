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

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  public DownloadServlet() {
     super();
  }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("file");
		System.out.println(fileName);
		// 文件的输入流
		FileInputStream inputStream = new FileInputStream(new File("D:/upload", fileName));
		// 对路径进行url编码，会将z中文等特殊字符转换为%的形式,但是空格会变为+字符，所以命名尽量避免使用
		fileName = URLEncoder.encode(fileName, "utf-8");
		// 设置响应头，HTTP 上下文中的第一个参数是默认值是 inline，表示它可以显示在网页内或作为网页。该值可以重设为 attachment，表示它应该下载，此时大多数浏览器呈现“另存为”对话框，如果存在参数的 filename 值，会以该字段值作为文件名。
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
