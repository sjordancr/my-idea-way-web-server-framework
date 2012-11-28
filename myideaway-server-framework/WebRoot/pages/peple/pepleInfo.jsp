<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../common/base.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
<input type="hidden" id="id" value="${sessionScope.peple.t_peple_info_id}">
<input type="text" id="name">
<input type="text" id="connect_peple">
<input type="text" id="own_money">
<input type="text" id="own_peple">
<input type="text" id="pay_money">
</body>
<script type="text/javascript">
$(document).ready(function(){
	  
	$.ajax({
 		type: 'post',
		url:"../../peple/getPepleInfo.action",
		data:{
			id:$("#id").val()
		},
		success:function(data){
			$("#name").val(data.name);
			$("#own_money").val(data.own_money);
			$("#own_peple").val(data.own_peple);
			$("#connect_peple").val(data.connect_peple_name);
			$("#pay_money").val(data.pay_money);
		},
		dataType:"json"
	});
});
</script>
</html>