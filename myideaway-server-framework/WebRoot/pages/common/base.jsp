<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.getSession().setAttribute("basePath",basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="${basePath }css/zTreeStyle/zTreeStyle.css">
<link rel="stylesheet" type="text/css" href="${basePath }css/smoothness/jquery-ui-1.8.24.custom.css">
<link rel="stylesheet" type="text/css" href="${basePath }css/demo.css">
<link rel="stylesheet" type="text/css" href="${basePath }css/Pager.css">
<link rel="stylesheet" type="text/css" href="${basePath }css/default/base.css">
<link rel="stylesheet" type="text/css" href="${basePath }css/default/Desktop.css">
<script type="text/javascript" src="${basePath }scripts/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${basePath }scripts/jquery-ui-1.8.24.custom.min.js"></script>
<script type="text/javascript" src="${basePath }scripts/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${basePath }scripts/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="${basePath }scripts/jquery.validate.js"></script>
<script type="text/javascript" src="${basePath }scripts/messages_cn.js"></script>
<script src="${basePath }scripts/jquery.pager.js" type="text/javascript"></script>
<script type='text/javascript' src='${basePath}dwr/engine.js'></script>
<script type='text/javascript' src='${basePath}dwr/interface/DwrService.js'></script>
<title>Insert title here</title>