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

<table id="tid">
	<tr>
		<td>name</td>
		<td>age</td>
	</tr>
	<tr>
		<td>haha</td>
		<td>heihei</td>
	</tr>
</table>

<script type="text/javascript">
	$(function(){
		// $.ajax({})
		$.ajax({
			type:"get",
			url:"UserListServlet",
			dataType:"json",// 预期返回的数据格式
			success:function(backData){ // ajax请求成功
				
				$(backData).each(function(){
					var html = "<tr>";
					html += "<td>" + this.name + "</td>";
					html += "<td>" + this.age + "</td>";
					html += "</tr>";
					// 添加元素
					$("table").append($(html));
				})	
			},
			error:function(data){ // ajax访问失败
				alert(data);
			}
		})
		
	})

</script>




</body>
</html>