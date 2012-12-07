<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
request.setAttribute("pepleType", request.getSession().getAttribute("pepleType"));
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../common/base.jsp"></jsp:include>
</head>
<body>
<div>
<form id="myform" action="../member/list.action" method="post">
<table >
<tr><td><a href="addPage.action">新增</a></td></tr>
</table>
<table width="89%">
	<tr>
		<td>会员姓名</td>
		<td>会员登录名</td>
		<td>身份证号</td>
		<td>联系电话</td>
		<td>电子邮件</td>
		<td>是否商务店</td>
		<c:if test="${pepleType==1}"><td>操作</td></c:if>
	</tr>
	<c:forEach items="${list}" var="mem">
	<tr >
		<td>${mem.real_name}</td>
		<td>${mem.login_name}</td>
		<td>${mem.card_id}</td>
		<td>${mem.phone}</td>
		<td>${mem.email}</td>
		<td>${mem.is_order_store_desc}<c:if test="mem.is_order_store == 1">asd </c:if></td>
		<c:if test="${pepleType==1&&mem.is_active!=1}"><td><a href="#" onclick="doChangeType(${mem.id});" id ="active_link">激活</a></td></c:if>
	</tr>
	</c:forEach>
</table>
<input type="hidden" id="currentPage" name="currentPage" value="">
</form>

<div id="pager"></div>
</div>
</body>
<script type="text/javascript">
$(document).ready(function() {
    $("#pager").pager({pagenumber: ${page.currentPage}, pagecount:${page.pageNum}, buttonClickCallback: PageClick });
});
PageClick = function(pageclickednumber) {
	$("#currentPage").val(pageclickednumber);
    $("#myform").submit();
}
function doChangeType(id){
	DwrService.chanageIsActive(id,function(data){if(data){alert("激活成功!");$("#active_link").hide();}else{alert("激活失败!");}});
}
</script>
</html>