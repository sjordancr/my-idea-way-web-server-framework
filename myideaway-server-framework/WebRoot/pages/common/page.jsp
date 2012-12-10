<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${page.count == 0}">
	<div class="nodata">未查询到符合条件的数据</div>
</c:if>
<div id="pager"></div>
<script type="text/javascript">
$(document).ready(function() {
    $("#pager").pager({pagenumber: ${page.currentPage}, pagecount:${page.pageNum}, buttonClickCallback: PageClick });
});
PageClick = function(pageclickednumber) {
	$("#currentPage").val(pageclickednumber);
    $("#myform").submit();
}
</script>