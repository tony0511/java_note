<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

${10 > 2 }<br />
${10 < 2 }<br />
${10 == 2 }<br />
${10 != 2 }<br />
${10 lt 2 }<br />

<%
	request.setAttribute("age", 10);
%>

${age == 2 }<br />
<hr />

${10 > 2 && 10 < 100 }<br />
${10 > 2 and 10 < 100 }<br />
${10 > 2 || 10 < 100 }<br />

${!true }<br />
${not true }<br />


<%
	request.setAttribute("name", "haha");
%>

${name == null || name == "" }<br />
<!-- 判断字符串是否为空 -->
${empty name }<br />


<!-- 三目运算符 -->
${empty name ? 0 : 1 }



</body>
</html>