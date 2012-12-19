<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../common/base.jsp"></jsp:include>
</head>
<body>
<div class="p5" style="width:98%">
<form id="myform" action="../member/orderStoreList.action" method="post" target="_top">
<table windth="89%" cellpadding="0" cellspacing="0" class="formTable" style="margin:auto;">
	<tr >
		<td>会员登录名</td>
	</tr>
	<c:forEach items="${list}" var="mem">
	<tr >
		<td onclick="selectId(${mem.id},this)" id="${mem.id}">${mem.store_name}</td>
	</tr>
	</c:forEach>
</table>
<input type="hidden" id="currentPage" name="currentPage" value="">
<jsp:include page="../common/page.jsp"></jsp:include>
</form>
</div>
<script type="text/javascript">
function selectId(id,a){
	var r = {};
	r.id = id;
	r.name = $("#"+id+"").text();
	window.returnValue = r;
	window.opener.returnValue = r;
	window.close();
}
</script>
</body>
</html>