<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../common/base.jsp"></jsp:include>
</head>
<body>
<div>
<form id="myform" action="../member/queryCheckLog.action" method="post">
<table windth="89%" cellpadding="0" cellspacing="0" class="formTable" style="margin:auto;">
	<tr>
		<td>登录名</td>
		<td width="50%" align="center">结算日期</td>
		<td width="30%">结算金额</td>
	</tr>
	<c:forEach items="${list}" var="log">
	<tr >
		<td>${log.member_name }</td>
		<td><fmt:formatDate value="${log.check_datetime}" type="time" timeStyle="full" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td>${log.money}元</td>
	</tr>
	</c:forEach>
</table>
<input type="hidden" id="currentPage" name="currentPage" value="">
<jsp:include page="../common/page.jsp"></jsp:include>
</form>
</div>
</body>
</html>