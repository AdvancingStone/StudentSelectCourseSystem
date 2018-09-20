<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询所有课程信息</title>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/jquery-3.3.1.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/editTable.js"></script>
<script type="text/javascript">
</script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/base.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/editTable.css'/>">

</head>
<body>
<body>
	
	<form action="${pageContext.request.contextPath }/selectCourse.do" method="post">
	<table class="edtitable">
		<thead>
			<tr>
				<th colspan="8">以下可选课程</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>课程编号</th>
				<th>课程名</th>
				<th>学分</th>
				<th>开课时间</th>
				<th>结课时间</th>
				<th>任课老师</th>
				<th>教师联系方式</th>
				<th>选择</th>
			</tr>
			<c:forEach var="tc" items="${tcList}">
				<tr>
					<td>${tc.cno}</td>
					<td>${tc.name}</td>
					<td>${tc.credit}</td>
					<td><fmt:formatDate value="${tc.periodstart}" pattern="yyyy年MM月dd日" /></td>
					<td><fmt:formatDate value="${tc.periodend}" pattern="yyyy年MM月dd日" /></td>
					<td>${tc.teacher.tname}</td>
					<td>${tc.teacher.phone}</td>
					<td><input type="checkbox" name="ctno" value="${tc.cno }#${tc.teacher.tno }"></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div align="center" >
		<input type="submit" value="提交" /> 
	</div>
	</form>

</body>
</html>

