<%@page import="com.qianfeng.entity.Dog"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Dog d = new Dog();
d.setName("wangci");
d.setAge(2);

request.setAttribute("dog", d);
%>

${dog.name }<br />
${dog.age }<br />

</body>
</html>