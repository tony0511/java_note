<!-- page 指令，用于定义 JSP 页面的各种属性 -->
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- jsp 脚本，内容放在 _jspService 方法中 -->
<%
	// 局部变量
	int a = 10;
	System.out.println(a);
	Date date = new Date();
%>

<%
	for(int i = 1; i <= 6; i++ ){
%>
<h<%= i %>>biaoti</h<%=i %>>
<% } %>

<%
	for(int i = 1; i <= 6; i++ ){
		out.write("<h" + i + ">标题</h" + i + ">");
	}
%>

<!-- jsp 表达式，内容放在 _jspService 方法里
	out.print()
 -->
<%= a %>

<!-- jsp 声明 内容相当于类的成员变量和方法 -->
<%!
	public int age = 20;
	public int add(int a, int b){
		return a + b;
	}
%>

<%-- jsp 注释内容 --%>

<!-- include 指令，用于包含其他的 jsp 文件 -->
<%@ include file="head.jsp" %>

</body>
</html>