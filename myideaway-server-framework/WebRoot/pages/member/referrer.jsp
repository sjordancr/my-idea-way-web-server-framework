<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../common/base.jsp"></jsp:include>
</head>
<body>
<div>
<form id="myform" action="../member/canReferrer.action" method="post">
<table >
	<th >
		<td>会员登录名</td>
	</th>
	<c:forEach items="${list}" var="mem">
	<tr >
		<td onclick="selectId(${mem.id},this)">${mem.login_name}</td>
	</tr>
	</c:forEach>
</table>
<input type="hidden" id="currentPage" name="currentPage" value="">
<div id="pager"></div>
</form>
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
function selectId(id,a){
	var r = {};
	r.id = id;
	r.name = a.textContent;
	window.returnValue = r;
	window.close();
}
</script>
</html>