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
<script type="text/javascript">
function delCourse(sno,cno,tno) {
	var flag = window.confirm("您确定要取消该课程吗？");
	if (flag) {
		$(".delBtn").parent().parent().remove(); 
		location.href = "${pageContext.request.contextPath }/removeStudentDistributedCourse.do?sno="+ sno +"&cno=" + cno + "&tno=" + tno;
	}
}
</script>
</head>
<body>
<body>
	
	<form action="${pageContext.request.contextPath }/selectCourse.do" method="post">
	<table class="edtitable">
		<thead>
			<tr>
				<th colspan="8">已选择课程</th>
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
			<c:forEach var="sc" items="${scList}">
				<tr>
					<td>${sc.cno}</td>
					<td>${sc.name}</td>
					<td>${sc.credit}</td>
					<td><fmt:formatDate value="${sc.periodstart}" pattern="yyyy年MM月dd日" /></td>
					<td><fmt:formatDate value="${sc.periodend}" pattern="yyyy年MM月dd日" /></td>
					<td>${sc.teacher.tname}</td>
					<td>${sc.teacher.phone}</td>
					<td><a href="javascript:delCourse(${user.sno},${sc.cno},${sc.teacher.tno })" class="delBtn">取消已选择课程</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>

</body>
</html>

