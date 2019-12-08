<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.2.min.js"></script>

</head>
<body>

<form action="#" method="post" onsubmit="return false;">
	<input type="text" name="uname" /><br />
	<input type="password" name="password" /><br />
	<input type="submit" value="login" /><br />
	<a href="register.jsp">注册</a>
</form>

<script type="text/javascript">
	$("form").submit(function(){
		$.ajax({
			type:"post",
			url:"LoginServlet",
			data:{uname:$(":text").val(), password:$(":password").val()},// 提交的数据
			dataType:"json",
			success:function(data){
				//alert(data);
				/* if(data == "success"){
					window.location.href = "index.jsp";
				}else{
					alert("用户名或者密码错误");
				} */
				if(data.code == 1){
					window.location.href = "index.jsp";
				}else{
					alert(data.msg);
				}
			}
		})
	})

</script>


</body>
</html>