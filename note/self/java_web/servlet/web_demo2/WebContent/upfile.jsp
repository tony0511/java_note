<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 必须设置为 method="post" enctype="multipart/form-data" -->
	<form action="Servlet3" method="post" enctype="multipart/form-data" target="_blank">
		<input type="text" name="username"/><br />
		<input type="file" multiple name="file" /><br />
		<input type="submit" value="upload" />
	</form>
</body>
</html>