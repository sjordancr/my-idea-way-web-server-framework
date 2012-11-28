<%@ page language="java" contentType="text/html; charset=UTf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="base.jsp"></jsp:include>
</head>
<body>
	<div class="zTreeDemoBackground left">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	<input type="hidden" id="id" value="${sessionScope.peple.t_peple_info_id}">
</body>
<script type="text/javascript">
	function ajaxDataFilter(treeId, parentNode, responseData) {
	    if (responseData) {
	      for(var i =0; i < responseData.length; i++) {
	        responseData[i].isParent = true;
	      }
	    }
	    return responseData;
	};
	$(document).ready(function(){
		var setting = {
			async: {
				enable: true,
				url: "../../common/treeJson.action",
				autoParam: ["id"],
				dataFilter: ajaxDataFilter
			},
			data: {
				key: {
					name: "peple_name"
				}
			},
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey: "pId",
				rootPId: 0
			}
		};
		
		$.ajax({
	 		type: 'post',
			url:"../../peple/getPepleInfo.action",
			data:{
				id:$("#id").val()
			},
			success:function(data){
				var root = [{}];
				root[0].id = data.t_peple_info_id;
				root[0].pid = 0;
				root[0].peple_name = data.name;
				root[0].isParent = true;
				$.fn.zTree.init($("#treeDemo"), setting,root)
			},
			dataType:"json"
		});
		
	});
	
</script>
</html>