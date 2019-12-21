package com.qianfeng.upload;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  public ListServlet() {
     super();
  }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "D:/upload";
		File file = new File(path);
		File[] files = file.listFiles();
		String html = "<html><head></head><body>";
		for (File file2 : files) {
			html += file2.getName() + "<a href='DownloadServlet?file=" + file2.getName() +"'>下载</a><br />";
		}
		html += "</body></html>";
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(html);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
