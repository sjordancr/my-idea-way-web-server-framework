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
<div class="p5" style="width:98%">
<form id="myform" action="../member/list.action" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: 3px;">
<tr><td><a href="addPage.action">新增</a></td></tr>
</table>
<table width="100%" cellpadding="0" cellspacing="0" class="formTable" style="margin:auto;">
	<tbody>
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
		<td>${mem.is_order_store_desc}<c:if test="${ mem.is_order_store == 1}"><a href="#" onclick="window.showModalDialog('../member/logList.action?id=${mem.id}','')">查看流水</a></c:if></td>
		<c:if test="${pepleType==1&&mem.is_active!=1}"><td><a href="#" onclick="doChangeType(${mem.id});" id ="active_link">激活</a></td></c:if>
	</tr>
	</c:forEach>
	</tbody>
</table>
<input type="hidden" id="currentPage" name="currentPage" value="">
<jsp:include page="../common/page.jsp"></jsp:include>
</form>
</div>
<script type="text/javascript">
function doChangeType(id){
	DwrService.chanageIsActive(id,function(data){if(data){alert("激活成功!");$("#active_link").hide();}else{alert("激活失败!");}});
}
</script>
</body>
</html>