<%@page import="com.qianfeng.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>所有员工信息</title>
		<style type="text/css">
			table td {
				text-align: center;
			}
			/*合并表格的边框*/

			table {
				width: 700px;
				border-collapse: collapse;
			}

			h3 {
				text-align: center;
			}

			div {
				margin: 0 auto;
				width: 700px;
			}
		</style>
	</head>

	<body>
		<div>
			<h3>所有员工信息</h3>
			<a href="添加.html">添加员工信息</a><br/>
			<table border="1">
				<tr>
					<th>序号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
			<%
				// 从内置的request对象中获取数据
				List<Employee> list = (List<Employee>)request.getAttribute("empList");
				for(Employee emp : list){
			%>
				<tr>
					<td><%=emp.getId() %></td>
					<td><%=emp.getName() %></td>
					<td><%=emp.getSex() %></td>
					<td><%=emp.getAge() %></td>
					<td><%=emp.getPhone() %></td>
					<td>
						<a href="修改.html">修改</a>&nbsp;
						<a href="#">删除</a>
					</td>
				</tr>
			<%} %>
			</table>
		</div>
	</body>

</html>