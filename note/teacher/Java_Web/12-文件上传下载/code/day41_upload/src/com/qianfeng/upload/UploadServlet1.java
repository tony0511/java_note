package com.qianfeng.upload;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  public UploadServlet1() {
    super();
  }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // enctype="multipart/form-data" 采用如下方式，无法正常读取提交的参数
		String name = request.getParameter("name"); // 结果为 null
		// 解析数据麻烦
		ServletInputStream inputStream = request.getInputStream();
		byte[] buff = new byte[1024];
		int len = inputStream.read(buff);
		String info = new String(buff, 0, len);
		System.out.println(info);
    /* 服务端接收到的返回数据
      ------WebKitFormBoundary23pp7eSMYfcZoGok
      Content-Disposition: form-data; name="username"

      asda测试
      ------WebKitFormBoundary23pp7eSMYfcZoGok
      Content-Disposition: form-data; name="file"; filename="未命名aaa.txt"
      Content-Type: text/plain

      扣丁学堂333：http://www.codingke.com/cmooc/JavaEE
      ------WebKitFormBoundary23pp7eSMYfcZoGok
      Content-Disposition: form-data; name="file"; filename="java_info.txt"
      Content-Type: text/plain

      扣丁学堂：http://www.codingke.com/cmooc/JavaEE
      ------WebKitFormBoundary23pp7eSMYfcZoGok--
    */
		response.getWriter().write("");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
