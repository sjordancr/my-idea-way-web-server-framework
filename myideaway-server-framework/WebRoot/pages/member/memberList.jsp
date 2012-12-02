<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../common/base.jsp"></jsp:include>
</head>
<body>
<div>
<form action="../../member/list.action" method="post">
<table >
	<th >
		<td>会员姓名</td>
		<td>会员登录名</td>
		<td>身份证号</td>
		<td>联系电话</td>
		<td>电子邮件</td>
		<td>是否商务店</td>
	</th>
	<c:forEach items="${list}" var="mem">
	<tr >
		<td>${mem.real_name}</td>
		<td>${mem.login_name}</td>
		<td>${mem.card_id}</td>
		<td>${mem.phone}</td>
		<td>${mem.email}</td>
		<td>${mem.is_order_store_desc}</td>
	</tr>
	</c:forEach>
</table>
</form>
<div id="pager"></div>
</div>
</body>
<script type="text/javascript">
$(document).ready(function() {
    $("#pager").pager({pagenumber: ${page.currentPage}, pagecount:${page.pageNum}, buttonClickCallback: PageClick });
});
PageClick = function(pageclickednumber) {
    $("#pager").pager({ pagenumber: pageclickednumber, pagecount: ${page.onePageCount}, buttonClickCallback: PageClick });
    
}
</script>
</html>