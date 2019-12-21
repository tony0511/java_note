<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  session.getLastAccessedTime();
	request.setAttribute("age", 10);
%>
${ age == 2 } <br />
${ age eq 2 } <br />
${ age < 2 } <br />
${ age lt 2 } <br />
${ age > 2 } <br />
${ age gt 2 } <br />
${ age <= 2 } <br />
${ age le 2 } <br />
${ age >= 2 } <br />
${ age ge 2 } <br />
<%
  request.setAttribute("name", "haha");
%>
${ name != null } <br />
${ name not null } <br />
<!-- 判断字符串是否为空 -->
${empty name }<br />

${ 10 > 2 && 10 < 100 } <br />
${ 10 > 2 and 10 < 100 } <br />
${ name == null || name == "" } <br />
${ !true } <br />
${ not true } <br />
<!-- 三目运算符 -->
${empty name ? 0 : 1 }

<!-- 获取指定的请求参数 -->
${param["id"] }<br />
${param.id }<br />

<!-- 获取请求头的数据 -->
${header["host"] }<br />

<!-- 根据cookie的name获取cookie对象 -->
${cookie["JSESSIONID"] }<br />
${cookie["JSESSIONID"].name }<br />
${cookie["JSESSIONID"].value }<br />

</body>
</html>