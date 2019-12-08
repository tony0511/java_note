<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p id="pid"></p>
<button onclick="btnclick()">click</button>

<script type="text/javascript">
	function btnclick(){
		// 创建ajax对象
		var ajax = createAjaxObj();
		
		var method = "get";
		var url = "AjaxTimeServlet"; // 访问的资源
		// 发送请求前的准备工作
		ajax.open(method, url);
		// 发送请求
		ajax.send(null);
		// 监听ajax的状态
		ajax.onreadystatechange = function(){
			// 4 ajax请求正常
			if(ajax.readyState == 4){
				
				if(ajax.status == 200){
					
					// 获取响应的数据
					var info = ajax.responseText;
					//alert(info);
					
					var pEle = document.getElementById("pid");
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