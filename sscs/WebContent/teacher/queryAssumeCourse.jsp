<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询任课课程</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/base.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/editTable.css'/>">
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/editTable.js"></script>
</head>
<body>
<body>
	<table class="edtitable">
		<thead>
			<tr>
				<th colspan="5">任课列表</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>课程编号</th>
				<th>课程名</th>
				<th>学分</th>
				<th>开课日期</th>
				<th>结课日期</th>
			</tr>
			<c:forEach var="course" items="${objList}">
				<tr>
					<td>${course.cno}</td>
					<td>${course.name}</td>
					<td>${course.credit}</td>
					<td><fmt:formatDate value="${course.periodstart}" pattern="yyyy年MM月dd日" /></td>
					<td><fmt:formatDate value="${course.periodend}" pattern="yyyy年MM月dd日" /></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<!-- 分页操作 -->
	<div style="text-align: center">
		<p class="paging">
			<a href="queryAssumeCourse.do?page=${paging.indexpage-1}">&lt;&lt;首页 </a> 
			<a href="queryAssumeCourse.do?page=${paging.page-1 }"> &lt; 上一页</a> 
			<strong>第${paging.page+1}页/共${paging.pagenumber}页</strong> 
			<a href="queryAssumeCourse.do?page=${paging.page+1}">下一页 &gt;</a> 
			<a href="queryAssumeCourse.do?page=${paging.pagenumber-1}">末页 &gt;&gt;</a>
		</p>

	</div>

</body>
</html>

