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

<p id="pid"></p>
<button onclick="btnclick()">click</button>

<script type="text/javascript">
	function btnclick(){
		// 将后台返回的数据直接加载到选择器对应的元素
		// 默认使用get提交方式
		//$("#pid").load("AjaxTimeServlet");
		
		var sendData = {name:"haha"};
		// 第二个参数，表示提交的数据，只要使用改参数，内部，会使用post方式进行提交
		// 第三个参数，回调函数，
		//			data 响应的数据
		//			responseState 响应状态的字符串内容
		//			ajax ajax对象
		$("#pid").load("AjaxTimeServlet", sendData, function(data, responseState, ajax){
			alert(data);
			alert(responseState);
			alert(ajax.responseText);
		});
	}
	
	$(function(){
		$("#pid").load("AjaxTimeServlet");
	})

</script>



</body>
</html>