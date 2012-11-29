<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../common/base.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
<form id="validateForm" method="post" action="../../member/add.action">
<table class="t1d">
	<tr class="a1">
		<td>推荐人</td>
		<td><input id="referrer" name="referrer"></td>
		<td>接收人</td>
		<td><input id="receiver" name="receiver"></td>
		<td>接收位置</td>
		<td><input id=""></td>
	</tr>
	<tr>
		<td>登陆名</td>
		<td><input id="login_name" name="login_name"></td>
		<td>真实姓名</td>
		<td><input id="real_name" name="real_name"></td>
		<td>身份证号码</td>
		<td><input id="card_id" name="card_id"></td>
	</tr>
	<tr class="a1">
		<td>联系电话</td>
		<td><input id="phone" name="phone"></td>
		<td>详细地址</td>
		<td><input id="detail_addres" name="detail_addres"></td>
		<td>邮件地址</td>
		<td><input id="email" name="email"></td>
	</tr>
	<tr class="a1">
		<td>接单商务店</td>
		<td><input type="radio" name="is_order_store" value="0" checked="checked">是</input><input type="radio" name="is_order_store" value="0">否</input></td>
		<td>商务店名称</td>
		<td><input id="store_name" name="store_name"></td>
		<td>商务店代理地址</td>
		<td><input id="store_agent_address" name="store_agent_address"></td>
	</tr>
	<tr>
		<td>开户银行</td>
		<td><input id="account_bank" name="account_bank"></td>
		<td>银行卡号码</td>
		<td><input id="bank_card_code" name="bank_card_code"></td>
		<td>开户银行所在省</td>
		<td><input id="bank_province" name="bank_province"></td>
	</tr>
	<tr class="a1">
		<td>开户银行所在城市</td>
		<td><input id="bank_city" name="bank_city"></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td>汇入账户</td>
		<td><input id="remit_account" name="remit_account"></td>
		<td>汇入账户开户行</td>
		<td><input id="remit_account_bank" name="remit_account_bank"></td>
		<td>汇款时间</td>
		<td><input id="remit_datetime" name="remit_datetime"></td>
	</tr>
	<tr class="a1">
		<td>汇款金额</td>
		<td><input id="remit_money" name="remit_money"></td>
		<td>汇款人</td>
		<td><input id="remot_peple" name="remot_peple"></td>
		<td></td>
		<td></td>
	</tr>
</table>
<input type="button" id="addinfo" value="提交"/>
</form>
</body>
<script type="text/javascript" >
$(document).ready(function(){
	$("#validateForm").validate({
		rules:{
			referrer:{
				required:true
			},
			receiver:{
				required:true
			},
			login_name:{
				required:true
			},
			real_name:{
				required:true
			},
			card_id:{
				required:true,
				stringCheck:true
			},
			phone:{
				required:true,
				isPhone:true
			},
			email:{
				email:true
			},			
			detail_addres:{
				required:true
			},
			account_bank:{
				required:true
			},
			bank_card_code:{
				required:true
			},
			bank_province:{
				required:true
			},
			bank_city:{
				required:true
			},
			remit_datetime:{
				required:true
			},
			remit_money:{
				required:true
			}
		}
	});
	
	$("#addinfo").click(function(){
		var success = $("#validateForm").valid();
		if(success){
			$("#validateForm").submit();
		}
		
	})
})
</script>
</html>