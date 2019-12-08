<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

${pageContext.request.contextPath }<br />

<form action="/day38_jsp/login"></form>
<form action="${pageContext.request.contextPath }/login"></form>

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