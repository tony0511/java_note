package com.qianfeng.history;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ItemDao dao = new ItemDao();
		List<Item> list = dao.findAll();
		
		
		// 读取cookie中数据
		String infos = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("historyinfo")){
					infos = cookie.getValue();
					break;
				}
			}
		}
		String[] infoArr = null;
		if(infos != null){
			infoArr = infos.split(",");
		}
		
		String html = "<html><head></head><body><table><tr><td>序号</td><td>名称</td><td>价格</td></tr>";
		for (Item item : list) {
			html += "<tr>";
			html += "<td>" + item.getId() + "</td>";
			html += "<td><a href='DetailServlet?id=" + item.getId() + "'>" + item.getName() + "</a></td>";
			html += "<td>" + item.getPrice() + "</td>";
			html += "</tr>";
		}
		
		html += "</table><hr />";
		for(String info : infoArr){
			Item it = dao.findById(Integer.parseInt(info));
			html += it.getId() + ":" + it.getName() + "<br />";
		}
		
		html += "</body></html>";
	
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
