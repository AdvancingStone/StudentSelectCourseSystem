<%@page import="com.bluehonour.sscs.entity.Admin"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>学生选课系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
</head>

<c:if test="${person == null }">
		 <script language="JavaScript"> 
			 top.location.href="${pageContext.request.contextPath }/login.jsp"; 
   		</script> 
	</c:if>

<frameset rows="15%,*" border="1">
	<frame src="<c:url value='/frame/top.jsp'/>" name="top">
	<frameset cols="13%,*" border="1">
		<frame src="<c:url value='/frame/left.jsp'/>" name="left">
		<frame src="<c:url value='/frame/right.jsp'/>" name="right">
	</frameset>
</frameset>
</html>
