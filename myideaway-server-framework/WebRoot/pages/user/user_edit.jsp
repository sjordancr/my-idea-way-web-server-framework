<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'user_edit.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form:form method="post" action="addUser.action">

	<table>
	<tr>
		<td><form:label path="loginName">First Name</form:label></td>
		<td><form:input path="loginName" /></td>
	</tr>
	<tr>
		<td><form:label path="loginPassword">password</form:label></td>
		<td><form:password path="loginPassword" /></td>
	</tr>
	<tr>
		<td><form:label path="nickName">nick name</form:label></td>
		<td><form:input path="nickName" /></td>
	</tr>
	<form:hidden path="entityId"/>
	<tr>
		<td colspan="2">
			<input type="submit" value="Add Contact"/>
		</td>
	</tr>
</table>	

</form:form>
</body>
</html>
