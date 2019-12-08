package com.qianfeng.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.dao.EmployeeDao;
import com.qianfeng.dao.impl.EmployeeDaoImpl;
import com.qianfeng.entity.Employee;

/**
 * Servlet implementation class ListServlet
 */
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
		
		EmployeeDao empDao = new EmployeeDaoImpl();
		
		// 获取所有员工数据
		List<Employee> list = empDao.findAll();
	
		String html = "<!DOCTYPE html>";
		
		html += "<html>                                                       ";
        html += "                                                             ";
		html += "	<head>                                                    ";
		html += "		<meta charset='utf-8' />                              ";
		html += "		<title>所有员工信息</title>                           ";
		html += "		<style type='text/css'>                               ";
		html += "			table td {                                        ";
		html += "				text-align: center;                           ";
		html += "			}                                                 ";
		html += "			/*合并表格的边框*/                                ";
		html += "			                                                  ";
		html += "			table {                                           ";
		html += "				width: 700px;                                 ";
		html += "				border-collapse: collapse;                    ";
		html += "			}                                                 ";
		html += "			                                                  ";
		html += "			h3 {                                              ";
		html += "				text-align: center;                           ";
		html += "			}                                                 ";
		html += "			                                                  ";
		html += "			div {                                             ";
		html += "				margin: 0 auto;                               ";
		html += "				width: 700px;                                 ";
		html += "			}                                                 ";
		html += "		</style>                                              ";
		html += "	</head>                                                   ";
        html += "                                                             ";
		html += "	<body>                                                    ";
		html += "		<div>                                                 ";
		html += "			<h3>所有员工信息</h3>                             ";
		html += "			<a href='添加.html'>添加员工信息</a><br/>         ";
		html += "			<table border='1'>                                ";
        html += "                                                             ";
		html += "				<tr>                                          ";
		html += "					<th>序号</th>                             ";
		html += "					<th>姓名</th>                             ";
		html += "					<th>性别</th>                             ";
		html += "					<th>年龄</th>                             ";
		html += "					<th>手机</th>                             ";
		html += "					<th>操作</th>                             ";
		html += "				</tr>                                         ";
		for (Employee employee : list) {
			
			html += "				<tr>                                          ";
			html += "					<td>" + employee.getId() + "</td>                                ";
			html += "					<td>" + employee.getName() + "</td>                             ";
			html += "					<td>" + employee.getSex() + "</td>                               ";
			html += "					<td>" + employee.getAge() + "</td>                               ";
			html += "					<td>" + employee.getPhone() + "</td>                       ";
			html += "					<td>                                      ";
			html += "						<a href='修改.html'>修改</a>&nbsp;    ";
			html += "						<a href='#'>删除</a>                  ";
			html += "					</td>                                     ";
			html += "				</tr>                                         ";
		}
        html += "                                                             ";
		html += "			</table>                                          ";
		html += "		</div>                                                ";
		html += "	</body>                                                   ";
        html += "                                                             ";
		html += "</html>                                                      ";
		
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
