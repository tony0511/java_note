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
	<input type="submit" value="register" /><br />
</form>

<script type="text/javascript">
	$("form").submit(function(){
		//alert($("form").serialize());//uname=lisi&password=12345
		$.ajax({
			type:"post",
			url:"RegisterServlet",
			data:$("form").serialize(), // 表单数据的序列化，表单中需要提交的数据转为key=value格式的字符串
			dataType:"json",
			success:function(data){
				if(data.code == 1){
					window.location.href = "05login.jsp";
				}else{
					alert(data.msg);
				}
			}
		})
	})

</script>

</body>
</html>