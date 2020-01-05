<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/" method="post">
	<label for="">用户名：<input type="text" name="username" /></label><br />
	<label for="">密码：<input type="password" name="password" /></label><br />
	<label for="">年龄：<input type="text" name="age" /></label><br />
	<label for="">邮箱：<input type="text" name="email" /></label><br />
	<label for="">省份：<input type="text" name="address.province" /></label><br />
	<label for="">城市：<input type="text" name="address.city" /></label><br />
	<button>保存</button>
</form>
</body>
</html>