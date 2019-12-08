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

<input id="inid" type="text" name="name" onblur="userBlur()" >
<span id="tid"></span>

<script type="text/javascript">
	function userBlur(){
		var data = {name: $("#inid").val()};
		// get方式发送ajax请求
		// 第二个参数：提交的数据
		// 第三个参数：回调函数,指定如何处理响应的数据
		/* $.get("UserExistServlet", data, function(backData){
			$("#tid").html(backData);
		}) */
		
		//post方式发送ajax请求
		$.post("UserExistServlet", data, function(backData){
			$("#tid").html("<img src='" + backData + "' />");
		})
		
		
		
	}

</script>



</body>
</html>