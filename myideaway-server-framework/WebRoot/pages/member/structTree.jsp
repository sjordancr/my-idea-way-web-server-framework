<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.getSession().setAttribute("basePath",basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="${basePath }scripts/jquery-1.7.2.js"></script>
</head>
<body>
<table id="structTree" width="98%" border="1">
	<tr level='0'><td style="text-align:center" onclick=""></td></tr>
</table>
</body>
<script type="text/javascript">
	function loadCell(){
		$.post(
				'../member/structTree.action',
				{level:0},
				function(data){
					var list = data.list;
					var lastLevel = data.maxlevel;
					makeCell(lastLevel);
					
					fillData(list);
					$.post(
						'../member/statistics.action',
						function(data){
							var memberid = $("tr[level='0'] td").attr("memberid");
							if(data.member.id == parseInt(memberid)){
								var cell = $("tr[level='0'] td[memberid='"+memberid+"']");
								cell.append("<a href='#' onclick='check("+memberid+")'>结算</a>");
							}
						}
					)
				}
			);
	}
	
	function makeCell(maxlevel){
		var lastLevel = maxlevel;
		var html = "";
		var htmllevel = $("#structTree tr:last-child").attr("level");
		for(var i= parseInt(htmllevel)+1;i<= lastLevel;i++){
			html = html +"<tr level='"+i+"'>"
			for(var inner = 0;inner< Math.pow(2,i);inner++){
				html=html+"<td></td>";
			}
			
			html = html+"</tr>";
		}
		
		
		$("#structTree").append(html);
		$("tr[level='0'] td").attr({"colspan":Math.pow(2,lastLevel),style:"text-align:center"});
		for(var i = 1 ;i<lastLevel;i++){
			
			var o = $("tr[level='"+i+"'] td");
			o.each(function(){
				$(this).attr({"colspan":Math.pow(2,lastLevel-i),style:"text-align:center;"});
			});
		}
		$("tr[level='"+lastLevel+"'] td").each(function(){
			$(this).attr("style","text-align:center");
		});
	}
	
	function fillData(data){
		var level = 0;
		var index = 0;
		for(var i=0;i<data.length;i++){
			var temp = data[i];
			if(temp.nlevel != level){
				level = temp.nlevel;
				index = 0;
			}
			$("tr[level='"+level+"'] td:eq("+index+")").text(temp.login_name);
			$("tr[level='"+level+"'] td:eq("+index+")").attr("memberid",temp.id);
			index++;
		}
	}
	
	$(function(){
		loadCell();
	});
	
	function check(id){
		$.post(
			'../member/check.action',
			{'id':id},
			function(data){
				$("td").text("");
				loadCell();
			}
		);
	}
	
</script>
</html>