<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 引入格式化标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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




