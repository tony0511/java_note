package com.qianfeng.cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LasttimeServlet
 */
@WebServlet("/LasttimeServlet")
public class LasttimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LasttimeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Cookie[] cookies = request.getCookies();
		if(cookies == null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timeStr = sdf.format(new Date());
			Cookie cookie = new Cookie("lasttime", timeStr);
			response.addCookie(cookie);
			
		}else{
			Cookie timeCookie = null;
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("lasttime")){
					timeCookie = cookie;
					break;
				}
			}
			
			if(timeCookie != null){
				String time = timeCookie.getValue();
				response.getWriter().write(time);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timeStr = sdf.format(new Date());
			Cookie cookie = new Cookie("lasttime", timeStr);
			response.addCookie(cookie);
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
