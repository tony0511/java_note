package com.qianfeng.history;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		ItemDao dao = new ItemDao();
		
		Item item = dao.findById(Integer.parseInt(id));
		
		String html = "<html><head></head><body>";
		
		html += item.getId() + "<br />";
		html += item.getName() + "<br />";
		html += item.getPrice() + "<br />";
		html += item.getComment() + "<br />";
		
		html += "</body></html>";
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(html);
		
		// 处理cookie的逻辑
		Cookie[] cookies = request.getCookies();
		if(cookies == null){
			Cookie cookie = new Cookie("historyinfo", id);
			response.addCookie(cookie);
		}else{
			Cookie info = null;
			// 查找是否存在指定名称的cookie
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("historyinfo")){
					info = cookie;
					break;
				}
			}
			if(info == null){
				Cookie cookie = new Cookie("historyinfo", id);
				response.addCookie(cookie);
			}else{
				// 获取已有的历史记录信息    100,102,106
				String value = info.getValue();
				String[] split = value.split(",");
				// 转为列表
				List<String> asList = Arrays.asList(split);
				LinkedList<String> ll = new LinkedList<>(asList);
				
				// 已有记录中是否包含访问的信息
				if(ll.contains(id)){
					ll.remove(id);
					ll.addFirst(id);
				}else{
					int size = ll.size();
					// 如果达到临界值，删除最后的，在最前面添加最新的
					if(size >= 5){
						ll.removeLast();
						ll.addFirst(id);
					}else{
						ll.addFirst(id);;
					}
				}
				// 列表转为数组
				String[] array = ll.toArray(new String[ll.size()]);
				String newInfo = String.join(",", array);
				
				Cookie cookie = new Cookie("historyinfo", newInfo);
				response.addCookie(cookie);
				
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
