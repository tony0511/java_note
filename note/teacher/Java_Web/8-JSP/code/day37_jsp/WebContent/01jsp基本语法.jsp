<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="false"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- jsp脚本,内容放在_jspServlce方法中 -->
<%
	// 局部变量
	int a = 10;
	System.out.println(a);
	
	Date date = new Date();

%>

<!-- jsp表达式，内容放在_jspService方法里
	out.print()
 -->
<%=a %>

<%
	for(int i = 1; i <= 6; i++ ){
%>

<h<%=i %>>biaoti</h<%=i %>>

<%} %>

<%
	for(int i = 1; i <= 6; i++ ){
		out.write("<h" + i + ">标题</h" + i + ">");
	}
%>

<!-- jsp声明  内容相当于类的成员变量和方法 -->

<%-- jsp注释 --%>
<%!
	public int age = 20;
	public int add(int a, int b){
		return a + b;
	}	

%>






</body>
</html>