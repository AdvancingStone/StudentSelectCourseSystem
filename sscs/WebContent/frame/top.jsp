<%@page import="com.bluehonour.sscs.entity.Admin"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>top</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<style type="text/css">
body {
	background: #1a6cb9;
	margin: 20px;
	color: #ffffff;
}

a {
	text-decoration: none;
	color: #ffffff;
	font-weight: 900;
}

a:hover {
	text-decoration: underline;
	color: #ff0000;
	font-weight: 900;
}
</style>
</head>

<body>

	<h1 style="text-align: center;" >学生选课系统</h1>
	<div style="font-size: 10pt; line-height: 10px;"></div>

	你好:
	<c:choose>
		<c:when test="${person == 'administrator'}">${user.userName }</c:when>
		<c:when test="${person == 'student'}">${user.sname }</c:when>
		<c:when test="${person == 'teacher'}">${user.tname }</c:when>
	</c:choose>
	
	&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath }/logout.do" target="_parent">注销</a>

</body>
</html>
