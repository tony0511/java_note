<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	window.onload = function() {
		// 创建ajax对象
		var ajax = createAjaxObj();
		
		var method = "get";
		var url = "UserListServlet"; // 访问的资源
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
					//alert(typeof info);
					// '[{},{}]'
					// 对字符串数据进行转换，消除字符串的影响
					// 本例中，转为数组对象
					var arr = eval(info)
					
					var tEle = document.getElementById("tid");
					/* <tr>
						<td>haha</td>
						<td>heihei</td>
					   </tr> */
					for(var index in arr){
						var trEle = document.createElement("tr");// <tr></tr>
						
						for(var key in arr[index]){
							var tdEle = document.createElement("td");// <td></td>
							tdEle.innerHTML = arr[index][key];// <td>zhagnsan</td>
							trEle.appendChild(tdEle);// <tr><td>zhagnsan</td></tr>
						}
						
						/* var tdEle = document.createElement("td");// <td></td>
						tdEle.innerHTML = arr[index]["name"];// <td>zhagnsan</td>
						trEle.appendChild(tdEle);// <tr><td>zhagnsan</td></tr>
						tdEle = document.createElement("td");// <td></td>
						tdEle.innerHTML =  arr[index]["age"];// <td>12</td>
						trEle.appendChild(tdEle);//<tr><td>zhagnsan</td><td>12</td></tr> */
						
						tEle.appendChild(trEle);//<table>....<tr><td>zhagnsan</td><td>12</td></tr></table>
					}
					
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