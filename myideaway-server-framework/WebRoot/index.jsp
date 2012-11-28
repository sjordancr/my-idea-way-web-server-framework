<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <jsp:include page="pages/common/base.jsp"></jsp:include>    
  </head>
  
  <body>
    <input type="text" id="name">
    <span id="message"></span>
    <input type="password" id="password">
    <input type="button" id="sub" value="登陆"/>
  </body>
  <script type="text/javascript">
  $(document).ready(function(){
	  $("#sub").click(function(){
		  $.ajax({
			  	type: 'post',
		  		url:"login.action",
		  		data:{
		  			name:$("#name").val(),
		  			password:$("#password").val()
		  		},
		  		success:function(data){
		  			if(data.success) {
		  				window.location.href="pages/main.jsp";
		  			}else{
		  				$("#message").val(data.message);
		  			}	  			
		  		},
		  		dataType:"json"
		  	});
	  });
  });
  </script>
</html>
