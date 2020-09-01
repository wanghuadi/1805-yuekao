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
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		//查询动态 分类下拉
		//查询动态复选框
		$.post("queryTypeAndServer",function(data){
			
			var type = data.typeList;
			var server = data.serverList;
			
			for(var i in type){
				$("#type").append("<option value='"+type[i].id+"'>"+type[i].activity_name+"</option>");
			}
			
			
			for(var i in server){
				$("#server").append("<input type='checkbox' name='sid' value='"+server[i].id+"'>"+server[i].name+"")
			}
			
		})
		
	})

</script>
<script type="text/javascript">
/* 添加活动 */
	function addActivity(){
		$.post("addActivity",$("form").serialize(),function(data){
			
			if(data){
				alert('添加成功!');
				location.href="list";
			}else{
				alert("添加失败!");
			}
			
		})
	}
</script>
</head>
<body>

	<form action="#">
		活动编号:<input type="text" name="activity_code"><br>
		活动名称:<input type="text" name="activity_name"><br>
		活动类型:<select id="type" name="activity_type">
				<option value="">请选择</option>
			  </select><br>
		活动日期:<input type="date" name="start_time"> 至 <input type="date" name="end_time"><br>
		<div id="server">
		活动服务:
		</div>
		<input type="button" value="添加" onclick="addActivity()">
	</form>

</body>
</html>