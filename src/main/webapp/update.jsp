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
		/* 根据活动id  查询信息 回显 */
		$.post("queryById",{"id":"${param.id}"},function(data){
			
			var activity = data.activity;
			var type = data.typeList;
			var server = data.serverList;
			
			//id回显
			$("[name='id']").val(activity.id);
			
			//编号回显
			$("[name='activity_code']").val(activity.activity_code);
			//名称回显
			$("[name='activity_name']").val(activity.activity_name);
			
			//活动开始日期回显
			$("[name='start_time']").val(activity.start_time);
			
			//活动结束日期回显
			$("[name='end_time']").val(activity.end_time);
			
			for(var i in type){
				$("#type").append("<option value='"+type[i].id+"'>"+type[i].activity_name+"</option>");
			}
			
			//分类回显
			$("#type").val(activity.activity_type);
			
			var str = "";
			for(var i in server){
				
				str+="<input type='checkbox' name='sid' ";
				
				if(server[i].flg){
					str+="checked='checked'";
				}
				
				str+="value='"+server[i].id+"'>"+server[i].name+"";
			}
			
			$("#server").append(str);
			
		});
		
	})

</script>
<script type="text/javascript">
/* 添加活动 */
	function updateActivity(){
		$.post("updateActivity",$("form").serialize(),function(data){
			
			if(data){
				alert('修改成功!');
				location.href="list";
			}else{
				alert("修改失败!");
			}
			
		})
	}
</script>
</head>
<body>

	<form action="#">
			  <input type="hidden" name="id">
		活动编号:<input type="text" name="activity_code"><br>
		活动名称:<input type="text" name="activity_name"><br>
		活动类型:<select id="type" name="activity_type">
				<option value="">请选择</option>
			  </select><br>
		活动日期:<input type="date" name="start_time"> 至 <input type="date" name="end_time"><br>
		<div id="server">
		活动服务:
		</div>
		<input type="button" value="修改" onclick="updateActivity()">
	</form>

</body>
</html>