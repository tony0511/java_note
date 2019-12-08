
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>所有员工信息</title>
		<style type="text/css">
			table td {
				text-align: center;
			}
			/*合并表格的边框*/
			
			table {
				width: 700px;
				border-collapse: collapse;
			}
			
			h3 {
				text-align: center;
			}
			
			div {
				margin: 0 auto;
				width: 700px;
			}
		</style>
		<script type="text/javascript" src="js/jquery-1.12.2.min.js"></script>
	</head>

	<body>
		<div>
			<h3>所有员工信息</h3>
			<a href="${pageContext.request.contextPath }/add.jsp">添加员工信息</a><br/>
			<table border="1">

				<tr>
					<th>序号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
				<tbody id="tid">
				</tbody>
			
				
			</table>
			
			
			<script type="text/javascript">
				$(function(){
					
					loadData(1);
					
				})
			
			</script>
			
			<script type="text/javascript">
				function loadData(page){
					$.ajax({
						type:"get",
						url:"list?page=" + page,
						dataType:"json",
						success:function(data){
							if(data.code == 1){
								// 清除原来的数据
								$("#tid").empty();
								
								var emplist = data.info.empList;
								
								$(emplist).each(function(){
									
									var html = '<tr>';
									html += '<td>' + this.id + '</td>';
									html += '<td>' + this.name + '</td>';
									html += '<td>' + this.sex + '</td>';
									html += '<td>' + this.age + '</td>';
									html += '<td>' + this.phone + '</td>';
									html += '<td>';
									html += '	<a href="query?id=${emp.id }">修改</a>&nbsp;';
									html += '	<a href="delete?id=${emp.id }">删除</a>';
									html += '</td>';
									html += '</tr>';
									
									$("#tid").append($(html));
									
								})
								var html = "<tr><td colspan='6'>";
								html += "<a href='javascript:loadData(1)'>首页</a>";
								html += "<a href='javascript:loadData(" + (data.info.currentPage - 1) + ")'>上一页</a>";
								html += "<a href='javascript:loadData(" + (data.info.currentPage + 1) + ")'>下一页</a>";
								html += "<a href='javascript:loadData(" + data.info.totalPage +")'>末页</a>";
								html += data.info.currentPage + "/" + data.info.totalPage + "</td></tr>"
								$("#tid").append($(html));
								
							}else{
								alert(data.info);
							}
						}
					})
				}
			
			</script>
			
			
		</div>
	</body>

</html>