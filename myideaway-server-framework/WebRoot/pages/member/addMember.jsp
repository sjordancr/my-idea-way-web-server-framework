<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../common/base.jsp"></jsp:include>
<script src="${basePath }scripts/common/calendar.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="p5" style="width:98%">
<form id="validateForm" method="post" action="../member/add.action">
<table width="100%" cellpadding="0" cellspacing="0" class="formTable" style="margin:auto;">
	<tr class="a1">
		<td>推荐人</td>
		<input type="hidden" id="referrerId" name="referrerId">
		<td><input id="referrer" name="referrer"  readonly="readonly" onclick="selectReferrer()"></td>
	</tr>
	<tr>
		<td>接收人</td>
		<td><input id="receiver" name="receiver" readonly="readonly"  onclick="selectReciver()"></td>
	</tr>
	<tr>
		<td>接收位置</td>
		<td><input type="radio" name="is_order_store" value="0" checked="checked">左边</input><input type="radio" name="is_order_store" value="0">右边</input></td>
	</tr>
	<tr>
		<td>接单商务店</td>
		<input type="hidden" id="recive_order_store_" name="recive_order_store">
		<td><input id="recive_order_store_name" readonly="readonly" onclick="selectOrderStore()"></td>
	</tr>
	<tr>
		<td>登陆名</td>
		<td><input id="login_name" name="login_name"></td>
	</tr>
	<tr>
		<td>真实姓名</td>
		<td><input id="real_name" name="real_name"></td>
	</tr>
	<tr>
		<td>身份证号码</td>
		<td><input id="card_id" name="card_id"></td>
	</tr>
	<tr class="a1">
		<td>联系电话</td>
		<td><input id="phone" name="phone"></td>
	</tr>
	<tr>
		<td>详细地址</td>
		<td><input id="detail_addres" name="detail_addres"></td>
	</tr>
	<tr>
		<td>邮件地址</td>
		<td><input id="email" name="email"></td>
	</tr>
	<tr class="a1">
		<td>是否商务店</td>
		<td><input type="radio" name="is_order_store" value="1" checked="checked">是</input><input type="radio" name="is_order_store" value="0">否</input></td>
	</tr>
	<tr>
		<td>商务店级别</td>
		<td>
		<input type="radio" name="store_level" value="1">省</input>
		<input type="radio" name="store_level" value="2">市</input>
		<input type="radio" name="store_level" value="3">区县</input>
		</td>
	</tr>
	<tr>
		<td>商务店名称</td>
		<td><input id="store_name" name="store_name"></td>
	</tr>
	<tr>
		<td>商务店代理地址</td>
		<td><span id="selectArea"></span></span><input id="store_agent_address" name="store_agent_address"></td>
	</tr>
	<tr>
		<td>开户银行</td>
		<td><input id="account_bank" name="account_bank"></td>
	</tr>
	<tr>
		<td>银行卡号码</td>
		<td><input id="bank_card_code" name="bank_card_code"></td>
	</tr>
	<tr>
		<td>开户银行所在省</td>
		<td>
			<select id="bank_province" name="bank_province">
				<option value="">请选择</option>
			</select>
		</td>
	</tr>
	<tr class="a1">
		<td>开户银行所在城市</td>
		<td>
			<select id="bank_city" name="bank_city">
			
			</select>
		</td>
	</tr>
	<tr>
		<td>汇入账户</td>
		<td><input id="remit_account" name="remit_account"></td>
	</tr>
	<tr>
		<td>汇入账户开户行</td>
		<td><input id="remit_account_bank" name="remit_account_bank"></td>
	</tr>
	<tr>
		<td>汇款时间</td>
		<td><input id="remit_datetime" name="remit_datetime" readonly="readonly"></td>
	</tr>
	<tr class="a1">
		<td>汇款金额</td>
		<td><input id="remit_money" name="remit_money"></td>
	</tr>
	<tr>
		<td>汇款人</td>
		<td><input id="remot_peple" name="remot_peple"></td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: 3px;">
<tr><td><input type="button" id="addinfo" value="提交"/></td></tr>
</table>

</form>
</div>
</body>
<script type="text/javascript" >
var unique;
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
		
		exist("login_name",$("#login_name").val(),'输入的登陆名已存在');
		if(!unique) return;
		exist("card_id",$("#card_id").val(),'银行卡号已存在');
		if(!unique) return;
		exist("email",$("#email").val(),'电子邮件地址已存在');
		if(!unique) return;
		exist("bank_card_code",$("#bank_card_code").val(),'开户银行卡号已存在');
		if(!unique) return;
		if(success && unique){
			$("#validateForm").submit();
		}
		
	});
	
	function exist(name, value,message){
		$.ajax({
			url:"../member/checkUnique.action",
			type: 'post',
			async:false,
			data:{
				name:name,
				value:value
			},
			success:function(data){
				unique = data.unique;
				if(!unique){
					$("#"+name).parent().append("<label class=\"error\" id=\"exits"+name+"\" generated=\"true\">"+message+"</label>");
				}
				else{
					$("#.exist"+name).remove();
				}
			},
			dataType:"json"
	    }
		);
	};
	
	function checkReferrer(){
		$.ajax({
			url:"../member/checkReferrer.action",
			type: 'post',
			async:false,
			data:{
				value:$("#referrer").val()
			},
			success:function(data){
				unique = data.canUse;
				if(!unique){
					$("#"+name).parent().append("<label class=\"error\" id=\"exits"+name+"\" generated=\"true\">推荐人已推荐了2名会员不能作为推荐人</label>");
				}
				else{
					$("#.exist"+name).remove();
				}
				
			},
			dataType:"json"
	    });
	};
	
	$("input[name='store_level']").click(function(){
		var level = $(":radio[name='store_level']:checked").val();
		
		$("#selectArea").empty();
		if( '1' == level){
			$("#selectArea").append("<select id='province' name='area_level_id'></select>");
			provinceList()
		}else if( '2'== level){
			$("#selectArea").append("<select id='province' onchange='provinceChange()'></select>");
			$("#selectArea").append("<select id='city' name='area_level_id'></select>");
			provinceList()
		}else if( '3' == level){
			$("#selectArea").append("<select id='province' onchange='provinceChange()'></select>");
			$("#selectArea").append("<select id='city' onchange='cityChange()'></select>");
			$("#selectArea").append("<select id='area' name='area_level_id'></select>");
			provinceList()
		}
	});
	
	$.ajax({
		url:"../common/province.action",
		type: 'get',
		async:false,
		success:function(data){
			$.each(data, function (i, o) {
	             $("#bank_province").append("<option value='"+o.provinceID+"'>"+o.province+"</option>")
	        });
		},
		dataType:"json"
    });
	
	$("#bank_province").change(function(){
		$.ajax({
			url:"../common/cityList.action",
			type: 'get',
			data:{
				'province':$("#bank_province").val()
			},
			async:false,
			success:function(data){
				$("#bank_city").empty();
				$.each(data, function (i, o) {
		             $("#bank_city").append("<option value='"+o.cityID+"'>"+o.city+"</option>")
		        });
			},
			dataType:"json"
	    });
	});
})

function provinceList(){
	$.ajax({
		url:"../common/province.action",
		type: 'get',
		async:false,
		success:function(data){
			$("#province").append("<option value=''>请选择</option>'");
			$.each(data, function (i, o) {
	             $("#province").append("<option value='"+o.provinceID+"'>"+o.province+"</option>")
	        });
		},
		dataType:"json"
    });
}

function provinceChange(){
	cityList();
}

function cityList(){
	$.ajax({
		url:"../common/cityList.action",
		type: 'get',
		async:false,
		data:{
			'province':$("#province").val()
		},
		success:function(data){
			$("#city").empty();
			$("#city").append("<option value=''>请选择</option>'");
			$.each(data, function (i, o) {
	             $("#city").append("<option value='"+o.cityID+"'>"+o.city+"</option>")
	        });
		},
		dataType:"json"
    });
}

function cityChange(){
	areaList();
}

function areaList(){
	$.ajax({
		url:"../common/areaList.action",
		type: 'get',
		async:false,
		data:{
			'city':$("#city").val()
		},
		success:function(data){
			$("#area").empty();
			$("#area").append("<option value=''>请选择</option>'");
			$.each(data, function (i, o) {
	             $("#area").append("<option value='"+o.areaID+"'>"+o.area+"</option>")
	        });
		},
		dataType:"json"
    });
}

function selectReferrer()
{
	r = window.showModalDialog('../member/canReferrer.action','',"dialogWidth=500px;dialogHeight=400px;center=yes");
	if( typeof(r) != 'undefined'){
		$("#referrerId").val(r.id);
		$("#referrer").val(r.name);
	}else{
		$("#referrerId").val(window.returnValue.id);
		$("#referrer").val(window.returnValue.name);
	}
}

function selectOrderStore()
{
	r = window.showModalDialog('../member/orderStoreList.action','',"dialogWidth=500px;dialogHeight=400px;center=yes");
	if( typeof(r) != 'undefined'){
		$("#recive_order_store_").val(r.id);
		$("#recive_order_store_name").val(r.name);
	}else{
		$("#recive_order_store_").val(window.returnValue.id);
		$("#recive_order_store_name").val(window.returnValue.name);
	}
}

function selectReciver(){
	r = window.showModalDialog('../member/canReferrer.action','',"dialogWidth=500px;dialogHeight=400px;center=yes");
	if( typeof(r) != 'undefined'){
		$("#receiver").val(r.name);
	}else{
		$("#receiver").val(window.returnValue.name);
	}
}
ESONCalendar.bind("remit_datetime");
</script>
</html>