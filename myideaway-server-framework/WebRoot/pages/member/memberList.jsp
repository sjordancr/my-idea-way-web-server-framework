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
		<td>a</td>
		<td>a</td>
		<td>a</td>
		<td>a</td>
		<td>a</td>
		<td>a</td>
	</th>
	<c:forEach items="${list}" var="mem">
	<tr >
		<td>${mem.referrer}</td>
		<td>${mem.receiver}</td>
		<td>${mem.referrer}</td>
		<td>${mem.referrer}</td>
		<td>${mem.referrer}</td>
		<td>${mem.referrer}</td>
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