<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="form1" action="${pageContext.request.contextPath}/user/" method="post">
	<label for="">用户名：<input type="text" name="username" /></label><br />
	<label for="">密码：<input type="password" name="password" /></label><br />
	<label for="">年龄：<input type="text" name="age" /></label><br />
	<label for="">邮箱：<input type="text" name="email" /></label><br />
	<label for="">省份：<input type="text" name="address.province" /></label><br />
	<label for="">城市：<input type="text" name="address.city" /></label><br />
	<label for="">生日：<input type="text" name="birthday" /></label><br />
	<button>保存</button>
</form>

<hr />

<h1>请录入用户信息：格式为</h1>
<p>helen|18|123@qq.com</p>
<form name="form2"  action="${pageContext.request.contextPath}/saveuser" method="post">
	<textarea name="user" id="user" cols="100" rows="10"></textarea>
	<label for="">生日：<input type="text" name="birthday" /></label>
	<button>保存</button>
</form>

<hr />

<h1>使用json提交用户数据</h1>
<form name="form3"  id="form3" action="" method="post">
	<label for="">用户名：<input type="text" name="username"  id="username"/></label><br />
	<label for="">密码：<input type="password" name="password" id="password"/></label><br />
	<label for="">年龄：<input type="text" name="age" id="age"/></label><br />
	<button type="button" id="saveBtn">保存</button>
</form>

<hr />
<h1>文件上传</h1>
<form action="fileupload" method="post" enctype="multipart/form-data">
	<label for=""><input type="file" name="file" /></label><br>
	<label for=""><input type="text" name="desc" /></label><br>
	<button>上传</button>
</form>

<script src="${pageContext.request.contextPath}/lib/js/jquery.min.js"></script>
<script>
	
	$(function(){
		
		$('#saveBtn').click(function(){
			
			var row = {
					username: $('#username').val(),
					password: $('#password').val(),
					age: $('#age').val(),
			}
			
			$.ajax({
				
				url: 'user-json',
				type: 'post' ,
				contentType: 'application/json;charset=utf-8',
				data: JSON.stringify(row)
			});
			
		});
		
	});
</script>
</body>
</html>