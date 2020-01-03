<!-- page 指令，用于定义 JSP 页面的各种属性 -->
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<%= a %> <br />

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

<%
  // pageContext 域对象，只针对当前的 jsp 起作用
  pageContext.setAttribute("name", "zhangsan");
  // 可以指定将数据存储到哪个域对象中
  pageContext.setAttribute("name2", "req_name", PageContext.REQUEST_SCOPE);
  // 在域对象中查找属性，顺序为 pageContext、request、session、application
  Object info = pageContext.findAttribute("name2");
  System.out.println(info); 
%>
<%
	request.getSession();
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
${ name ne null } <br />
<!-- 判断字符串是否为空 -->
${empty name }<br />

${ 10 > 2 && 10 < 100 } <br />
${ 10 > 2 and 10 < 100 } <br />
${ name == null || name == "" } <br />
${ !true } <br />
${ not true } <br />
<!-- 三目运算符 -->
${empty name ? 0 : 1 } <br />

<!-- http://localhost:8080/web_demo2/index.jsp?id=3&habit=6&habit=7 -->
<!-- 获取指定的请求参数 -->
${ param["id"] }<br /> <!-- 3 -->
${ param.id }<br /> <!-- 3 -->
${ paramValues.habit[0] }<br /> <!-- 6 -->
${ paramValues.habit[1] }<br /> <!-- 7 -->

<!-- 获取请求头的数据 -->
${header["host"] }<br />

<!-- 根据 cookie 的 name 获取 cookie 对象 -->
${ cookie["JSESSIONID"] }<br />
${ cookie["JSESSIONID"].name }<br />
${ cookie["JSESSIONID"].value }<br />
<!-- 设置变量,放入域中
	var 变量名
	value 变量的值
 -->
<c:set value="zhangsan" var="name"></c:set>
${ name }<br />
<!-- 输出变量
	escapeXml 设置 html 标签是否生效，true 表示不生效，false 生效
-->
<c:out value="${ name1 }" default="<h1>haha</h1>" escapeXml="false"></c:out>
<c:set var="sex" value="女"></c:set>
<!-- 单条件 -->
<c:if test="${sex == '男' }">
	<input type="radio" checked="checked" />男
	<input type="radio"  />女
</c:if>
<c:if test="${sex != '男' }">
	<input type="radio"  />男
	<input type="radio" checked="checked" />女
</c:if>
<input type="radio"  <c:if test="${sex == '男' }">checked="checked"</c:if> />男
<input type="radio" <c:if test="${sex == '女' }">checked="checked"</c:if> />女

<c:set var="score" value="40"></c:set>
<!-- 多条件 -->
<c:choose>
	<c:when test="${score > 80 && score <= 100 }">
		学霸
	</c:when>
	<c:when test="${score >= 60 && score <= 80 }">
		just so so
	</c:when>
	<c:otherwise>
		渣渣
	</c:otherwise>
</c:choose>
<!-- 针对特定格式的字符串进行操作 -->
<c:forTokens items="java-c-c++-python" delims="-" var="item">
	${ item }
	<!-- java c c++ python -->
</c:forTokens>
<!--
	type
		number 数字
		currency 货币
		percent 百分比，默认不包含小数部分
	pattern 格式化样式
		# 占位符 会四舍五入
		0 占位符 如果位数不够，补0
	currencySymbol 货币的符号，默认￥
	minFractionDigits 小数部分最少多少位
-->
<!-- 10.13 -->
<fmt:formatNumber value="10.128" type="number" pattern=".##"></fmt:formatNumber>
<!-- 10.1 -->
<fmt:formatNumber value="10.1" type="number" pattern=".##"></fmt:formatNumber>
<!-- 10.10 -->
<fmt:formatNumber value="10.1" type="number" pattern=".00"></fmt:formatNumber>
<!-- 10.13 -->
<fmt:formatNumber value="10.134" type="number" pattern=".00"></fmt:formatNumber>
<!-- ￥1234567.12 -->
<fmt:formatNumber value="1234567.12345" type="currency"></fmt:formatNumber>
<!-- $1234567.12 -->
<fmt:formatNumber value="1234567.12345" type="currency" currencySymbol="$"></fmt:formatNumber>
<!-- %12.30 -->
<fmt:formatNumber value="0.123" type="percent" minFractionDigits="2"></fmt:formatNumber>
<%
	Date date = new Date();
	request.setAttribute("date", date);
%>
<!-- Tue Dec 17 23:07:35 CST 2019 -->
${ date }<br />
<!-- type
		date 日期
		time 时间
		both 日期和时间
 -->
<!-- 2019-12-17 -->
<fmt:formatDate value="${ date }" type="date"/>
<!-- 23:07:35 -->
<fmt:formatDate value="${ date }" type="time"/>
<!-- 2019-12-17 23:07:35 -->
<fmt:formatDate value="${ date }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
</body>
</html>