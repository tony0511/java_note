<%@page import="java.util.ArrayList"%>
<%@page import="com.qianfeng.entity.Dog"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- taglib 引入标签库
	引入jstl的核心标签库,前缀是c
 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 设置变量,放入域中
	var 变量名
	value 变量的值
 -->
<c:set value="zhangsan" var="name"></c:set>

${name }<br />


<jsp:useBean id="dog" class="com.qianfeng.entity.Dog"></jsp:useBean>

<!-- 设置对象的属性 -->
<c:set target="${dog }" property="name" value="bulutuo"></c:set>
${dog.name }<br />

<!-- 输出变量 
	escapeXml 设置html标签是否生效，true表示不生效，false 生效
-->
<c:out value="${name1 }" default="<h1>haha</h1>" escapeXml="false"></c:out>

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

<input type="radio"  <c:if test="${sex == '男' }">checked="checked"</c:if>   />男
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

<%
	List<Dog> list = new ArrayList<Dog>();
	for(int i = 0; i <= 10; i++){
		Dog d = new Dog();
		d.setId(100 + i);
		d.setName("fugui" + i);
		list.add(d);
	}
	request.setAttribute("dogList", list);

%>
<table>
	<tr>
		<td>编号</td>
		<td>名字</td>
		<td>status</td>
	</tr>

	<!-- 遍历
		items 待遍历的数据
		var 遍历的每一个数据对应的变量
		varStatus 变量的状态
			count 序号
			index 索引
			first 是否第一个元素
			last 是否最后一个元素
		begin/end 开始和结束索引
		step 步长
			
	 -->
	<c:forEach var="dog" items="${dogList }" varStatus="vs" begin="2" end="8" step="2">
		<tr>
			<td>${dog.id }</td>
			<td>${dog.name }</td>
			<td>${vs.count } / ${vs.index } / ${vs.first } / ${vs.last} </td>
		</tr>
	</c:forEach>

</table>

<!-- 针对特定格式的字符串进行操作 -->
<c:forTokens items="java-c-c++-python" delims="-" var="item">
	${item }
</c:forTokens>


</body>
</html>






