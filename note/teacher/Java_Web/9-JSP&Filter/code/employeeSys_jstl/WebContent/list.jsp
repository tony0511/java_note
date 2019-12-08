
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<a href="${pageContext.request.contextPath }/add.jsp">添加员工信息</a><br/>
			<table border="1">

				<tr>
					<th>序号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
			<c:forEach items="${empList }" var="emp" varStatus="vs">
				<tr>
					<td>${vs.count }</td>
					<td>${emp.name }</td>
					<td>${emp.sex }</td>
					<td>${emp.age }</td>
					<td>${emp.phone }</td>
					<td>
						<a href="query?id=${emp.id }">修改</a>&nbsp;
						<a href="delete?id=${emp.id }">删除</a>
					</td>
				</tr>
			</c:forEach>

			</table>
		</div>
	</body>

</html>