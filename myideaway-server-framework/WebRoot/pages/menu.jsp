<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${basePath }scripts/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${basePath }scripts/js/jquery.ztree.core-3.5.min.js"></script>
<link rel="stylesheet" type="text/css" href="${basePath }css/zTreeStyle/zTreeStyle.css">
<link rel="stylesheet" type="text/css" href="${basePath }css/demo.css">
</head>
<body>
	<ul id="treeDemo" class="ztree"></ul>
	<input type="hidden" id="id" value="${sessionScope.peple.t_peple_info_id}">
</body>
<script type="text/javascript">
	
	var setting = {
			data: {
				simpleData: {
					enable: true
				}
			}
		};
	var zNodes = [
	    {id:1, pId:0, name:'人员信息', url:"${basePath }member/list.action", target:'fun'},
	    {id:3, pId:0, name:'商务店提成', url:"${basePath }member/moneyOrderStoreList.action", target:'fun'},
	    {id:4, pId:0, name:'已结算会员信息', url:"${basePath }member/queryCheckLog.action", target:'fun'},
	    {id:5, pId:0, name:'人员组织树', url:"${basePath }member/structTreePage.action", target:'fun'}
	];
	
	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	
</script>
</html>