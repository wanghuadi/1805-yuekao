<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet"> --%>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		//查询动态 分类下拉
		//查询动态复选框
		$.post("queryTypeAndServer",function(data){
			
			var type = data.typeList;
			
			for(var i in type){
				$("#type").append("<option value='"+type[i].id+"'>"+type[i].activity_name+"</option>");
			}
			
		})
		
	})

</script>
<script type="text/javascript">
	function deleteActivity(aid){
		
		$.post("deleteActivity",{"aid":aid},function(data){
				
				if(data){
					alert('删除成功!');
					//location.href="list";
					location.reload();
				}else{
					alert("删除失败!");
				}
				
			})
	}
</script>
</head>
<body>
	<!-- 3、根据创建时间时间段查询：5分
	4、根据活动名称模糊查询 5 分
	根据活动类型下拉精确查询：5分 -->
	
	
	<form action="list" method="post">
		活动名称:<input type="text" name="aname">
		活动类型:<select id="type" name="tid">
					<option value="">请选择</option>
				</select><br>
		创建时间:<input type="date" name="startTime"> 至  <input type="date" name="endTime"><br>
		<input type="submit" value="搜索">
	</form>
	
	<a href="add.jsp">
		<input type="button" value="添加" class="btn btn-primary">
	</a>
	<table class="table">
		<tr>
			<td>序号</td>
			<td>活动编号</td>
			<td>活动名称</td>
			<td>活动类型</td>
			<td>活动开始时间</td>
			<td>活动结束时间</td>
			<td>活动服务</td>
			<td>创建时间</td>
			<td>操作</td>
		</tr>
	
	<c:forEach items="${page.list }" var="a">
		<tr>
			<td>${a.id }</td>
			<td>${a.activity_code }</td>
			<td>${a.activity_name }</td>
			<td>${a.tname }</td>
			<td>${a.start_time }</td>
			<td>${a.end_time }</td>
			<td>${a.sname }</td>
			<td>${a.create_time }</td>
			<td>
				<a href="update.jsp?id=${a.id }">
					<input type="button" value="修改" class="btn btn-info">
				</a>
					<input type="button" value="删除"  class="btn btn-danger" onclick="deleteActivity(${a.id })">
			</td>
		</tr>
	</c:forEach>
	</table>
	<ul class="pagination">
		<li><a href="list?pageNum=1">首页</a></li>
		<li><a href="list?pageNum=${page.pageNum - 1 }">上一页</a></li>
		<li><a href="list?pageNum=${page.pageNum + 1 }">下一页</a></li>
		<li><a href="list?pageNum=${page.pages }">尾页</a></li>
	</ul>
</body>
</html>