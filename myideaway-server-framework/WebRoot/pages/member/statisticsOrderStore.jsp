<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../common/base.jsp"></jsp:include>
</head>
<body>
<form id="myform" action="../member/canReferrer.action" method="post">
<table width="89%" cellpadding="0" cellspacing="0" class="formTable" style="margin:auto;">
	<tr >
		<td>商户名称</td>
		<td>会员登录名</td>
		<td>身份证号</td>
		<td>联系电话</td>
		<td>金额</td>
		<td>开户行</td>
		<td>开户卡号</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${list}" var="mem">
	<tr >
		<td>${mem.store_name}</td>
		<td>${mem.login_name}</td>
		<td>${mem.card_id}</td>
		<td>${mem.phone}</td>
		<td>${mem.own_money}元</td>
		<td>${mem.account_bank}</td>
		<td>${mem.bank_card_code}</td>
		<td><a href="../member/storeCheck.action?id=${mem.id}">结算</a>
		<a href="#" onclick="window.showModalDialog('../member/logList.action?id=${mem.id}','')">查看流水</a></td>
	</tr>
	</c:forEach>
</table>
<input type="hidden" id="currentPage" name="currentPage" value="">
<jsp:include page="../common/page.jsp"></jsp:include>
</form>
</body>
</html>