<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 创建对象，对象会放入域中
	id 对象名，相当于变量名
	class 类的字符串，类的全路径 包名+类名
	scope 作用范围
 -->
<jsp:useBean id="dog" class="com.qianfeng.entity.Dog" scope="page"></jsp:useBean>

<!-- 设置属性
	name 表示要操作的对象名
	property 对象中的属性名
	value 属性对应的值
-->
<jsp:setProperty property="name" value="zhaolasi" name="dog"/>
${ dog } <br />
${ dog.name } <br />
<!-- 获取对象中指定属性 -->
<jsp:getProperty property="name" name="dog"/>
<!-- 转发
  WEB-INF 文件夹下的资源不能直接访问
-->
<%-- <jsp:forward page="index.jsp"></jsp:forward> --%>
<jsp:forward page="WEB-INF/index.jsp"></jsp:forward>
</body>
</html>