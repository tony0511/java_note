<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.qianfeng.entity.Dog"%>
<%@page import="java.util.List"%>
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
	//向请求域中写入数据
	request.setAttribute("name", "Tom");
	session.setAttribute("name", "session_name");
	application.setAttribute("name", "application_name");
	//pageContext.setAttribute("name", "page_name");
	// 无法通过el表达式获取数据，因为没有放到相关的域对象中国 
	int a = 10;

%>

<%=request.getAttribute("name") %>
<br />
<!-- el表达式
	从域对象中获取数据
	本质上，是从相关的域对象中查找指定的值  顺序：pageContext/request/session/application
 -->
${name }<br />

<!-- 根据指定的域获取数据 -->
${requestScope.name }<br />
${sessionScope.name }<br />

<br />
${a }

<%
	List<Dog> list = new ArrayList<Dog>();
	for(int i = 0; i < 3; i++){
		Dog d = new Dog();
		d.setId(100 + i);
		d.setName("wangcai" + i);
		d.setAge(5 + i);
		list.add(d);
	}
	
	request.setAttribute("doglist", list);

%>
<!-- 通过下标获取列表中数据 -->
${doglist[0] }<br />
<!-- 相当于调用了getName等方法 -->
${doglist[0].name }<br />
${doglist[0].age }<br />


<%
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("name", "Jerry");
	map.put("age", 3);
	request.setAttribute("mapp", map);
	
%>

${mapp['name'] }<br />
${mapp.age }<br />


</body>
</html>