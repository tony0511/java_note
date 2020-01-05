<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${sessionScope.strvalue}
${sessionScope.intvalue}
<form action="save" method="get">
	<label for="">用户名：<input type="text" name="username" value="${user.username}"/></label>
	<label for="">密码：<input type="password" name="password" value="${user.password}"/></label>
	<label for="">年龄：<input type="text" name="age" value="${sessionScope.user.age}"/></label>
	<label for="">邮箱：<input type="text" name="email" value="${user.email}"/></label>
	<label for="">省份：<input type="text" name="address.province" value="${user.address.province}"/></label>
	<label for="">城市：<input type="text" name="address.city" value="${user.address.city}"/></label>
	<button>保存</button>
</form>
</body>
</html>