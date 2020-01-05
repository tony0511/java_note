<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>用户列表</h1>

<a href="user">增加</a>
<table border="1">
	<tr>
		<td>id</td>
		<td>姓名</td>
		<td>年龄</td>
		<td>操作</td>
	</tr>
	<c:forEach  items="${userList}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.username}</td>
			<td>${user.age}</td>
			<td>
				<a href="javascript:void(0)" onclick="deleteById(${user.id})">删除</a>
				<a href="user/${user.id}">修改</a>
			</td>
		</tr>
	</c:forEach>
</table>


<form method="post" id="deleteForm">
	<input type="text" name="_method" value="DELETE" />
	<button>DELETE提交</button>
</form>
<script src="${pageContext.request.contextPath}/lib/js/jquery.min.js"></script>
<script>
function deleteById(id){
	var form = document.getElementById('deleteForm');
	form.action = "user/" + id;
	document.getElementById('deleteForm').submit();
}
</script>
</body>
</html>