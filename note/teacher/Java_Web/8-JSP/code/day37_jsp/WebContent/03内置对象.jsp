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
	request.getContextPath();
	out.write("hahah");
	//response.sendRedirect(arg0)
	
	// 通过pageContext可以获取其他的8个内置对象
	pageContext.getRequest();
	pageContext.getResponse();
	pageContext.getSession();
	
	// pageContext 也是域对象,只针对当前的jsp起作用
	//pageContext.setAttribute("name", "zhangsan");
	// 可以指定将数据存储到哪个域对象中
	pageContext.setAttribute("name", "req_name", PageContext.REQUEST_SCOPE);
	
	// 在域对象中查找属性  顺序pageContext、request、session、application
	Object info = pageContext.findAttribute("name");
	System.out.println(info);

%>




</body>
</html>