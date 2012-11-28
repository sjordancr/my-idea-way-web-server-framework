<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../common/base.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td></td>
		<td><input id="name"></td>
	</tr>
	<tr>
		<td></td>
		<td><input id="connect_pepled"></td>
	</tr>
	<tr>
		<td></td>
		<td><input id="connect_peple"></td>
	</tr>
	<tr>
		<td></td>
		<td><input id="pay_money"></td>
	</tr>
	<tr>
		<td></td>
		<td><input id="email"></td>
	</tr>
	<tr>
		<td></td>
		<td><input id="password"></td>
	</tr>
	<input type="button" id="add" value="注册">
</table>
</body>
<script type="text/javascript">
$(document).ready(function(){
	$("#add").click(function(){
		$.ajax({
			url:"../../peple/checkConnectPeple.action",
			type: 'post',
			data:{
				connect_peple:$("#connect_peple").val()
			},
			success:function(data){
				var id = data.id;
				if( id == 0) alert('没有上级信息');
			},
			dataType:"json"
		});
	})
});
</script>
</html>