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
	String name = "";
	String pwd = "";
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("logininfo")){
				String info = cookie.getValue();
				String[] infos = info.split(",");
				name = infos[0];
				pwd = infos[1];
				break;
			}
		}
	}
%>

<form action="login">
	user<input type="text" name="uname" value="<%=name %>"/><br />
	password<input type="password" name="password" value="<%=pwd %>" /><br />
	<% if(name.equals("")){ %>
		<input type="checkbox" name="isRemember" value="y" />记住我<br />
	<%} %>
	<input type="submit" value="login" /><br />

</form>

</body>
</html>