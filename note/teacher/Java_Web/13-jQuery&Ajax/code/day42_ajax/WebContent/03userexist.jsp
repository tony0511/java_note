<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<input id="inid" type="text" name="name" onblur="userBlur()" >
<span id="tid"></span>

<script type="text/javascript">
	function userBlur(){
		// 创建ajax对象
		var ajax = createAjaxObj();
		
		//var method = "get";
		// get请求，在url中拼接发送的参数
		//var url = "UserExistServlet?name=XXXX"; // 访问的资源
		var method = "post";
		var url = "UserExistServlet"; // 访问的资源
		var iEle = document.getElementById("inid");
		// 发送请求前的准备工作
		ajax.open(method, url);
		// post方式提交ajax请求，必须设置Content-Type请求头
		ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		// post请求，在send方法设置发送的参数
		ajax.send("name=" + iEle.value );
		// 监听ajax的状态
		ajax.onreadystatechange = function(){
			// 4 ajax请求正常
			if(ajax.readyState == 4){
				
				if(ajax.status == 200){
					
					// 获取响应的数据
					var info = ajax.responseText;
					//alert(info);
					
					var pEle = document.getElementById("tid");
					pEle.innerHTML = info;
					
				}
				
			}
		}
	}

</script>

<script type="text/javascript">
			
			function createAjaxObj(){
				
				var ajax = null;
				try{
					// IE
					ajax = new ActiveXObject("microsoft.xmlhttp");
				}catch(e){
					// 针对非IE浏览器
					ajax = new XMLHttpRequest();
				}
				return ajax;
			}
			
			
			
		</script>


</body>
</html>