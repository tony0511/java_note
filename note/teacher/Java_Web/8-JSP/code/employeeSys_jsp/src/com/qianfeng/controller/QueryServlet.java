package com.qianfeng.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.dao.EmployeeDao;
import com.qianfeng.dao.impl.EmployeeDaoImpl;
import com.qianfeng.entity.Employee;

/**
 * Servlet implementation class QueryServlet
 */
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		
		EmployeeDao empDao = new EmployeeDaoImpl();
		Employee emp = empDao.findById(Integer.parseInt(id));
	
		String html = "<!DOCTYPE html>";
		html += "<html>";
		html += "	<head>";
		html += "		<meta charset='utf-8' />";
		html += "		<title>修改信息</title>";
		html += "		<style type='text/css'>";
		html += "			table {";
		html += "				width: 300px;";
		html += "				border-collapse: collapse;";
		html += "			}";
		html += "			h3 {";
		html += "				text-align: center;";
		html += "			}";
		html += "			div {";
		html += "				margin: 0 auto;";
		html += "				width: 300px;";
		html += "			}";
		html += "		</style>";
		html += "	</head>";
		html += "	<body>";
		html += "		<div>";
		html += "			<h3>修改员工信息</h3>";
		//html += "			<form action='update?id=" + emp.getId() + "' method='post'>";
		html += "			<form action='update' method='post'>";
		// 隐藏控件
		html += "<input type='hidden' name='id' value='" + emp.getId() + "' />";
		html += "				<table border='1'>";
		html += "					<tr>";
		html += "						<th>姓名</th>";
		html += "						<td><input type='text' name='name' value='" + emp.getName() + "' /></td>";
		html += "					</tr>";
		html += "					<tr>";
		html += "						<th>性别</th>";
		if(emp.getSex().equals("男")){
			html += "						<td>";
			html += "							<input type='radio' name='sex' value='男' checked='checked' />男";
			html += "							<input type='radio' name='sex' value='女'  />女";
			html += "						</td>";
		}else{
			html += "						<td>";
			html += "							<input type='radio' name='sex' value='男'  />男";
			html += "							<input type='radio' name='sex' value='女' checked='checked' />女";
			html += "						</td>";
		}
		
		html += "					</tr>";
		html += "					<tr>";
		html += "						<th>年龄</th>";
		html += "						<td><input type='text' name='age' value='" + emp.getAge() + "' /></td>";
		html += "					</tr>";
		html += "					<tr>";
		html += "						<th>手机</th>";
		html += "						<td><input type='text' name='phone' value='" + emp.getPhone() + "' /></td>";
		html += "					</tr>";
		html += "					<tr>";
		html += "						<td colspan='2' align='center'>";
		html += "							<input type='submit' value='修改' />&nbsp;";
		html += "							<input type='reset' value='重置' /></td>";
		html += "					</tr>";
		html += "				</table>";
		html += "			</form>";
		html += "		</div>";
		html += "	</body>";
		html += "</html>";
		
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(html);
		
//		String info = "<input type='hidden' name='id' value=" + emp.getName() + " />";
//		System.out.println(info);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
