<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'test.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="scripts/common/calendar.js"></script>

</head>

<body>
	This is my JSP page.
	<br>
<body>
	<div>
			<input type="text" name="riqi" id="Text1" size="31" style="margin:2px auto 2px auto;" value="2009-03-26" /><br />
		
	</div>
	
<script type="text/javascript"> 
    /*绑定日历到Text1*/
    ESONCalendar.bind("Text1");
</script>
</body>

</html>
