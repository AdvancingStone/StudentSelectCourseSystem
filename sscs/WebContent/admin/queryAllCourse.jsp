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
function delCourse(cno,tno) {
	var flag = window.confirm("您确定要删除该课程信息吗？");
	if (flag) {
		$(".delBtn").parent().parent().remove(); 
		location.href = "${pageContext.request.contextPath }/removeDistributedCourse.do?cno=" + cno + "&tno=" + tno;
	}
}
</script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/base.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/editTable.css'/>">

</head>
<body>
<body>

	<div style="margin-top:20px; margin-left: 70px;">
	<form action="${pageContext.request.contextPath }/distributeCourse.do" method="post">
		<select name="cno" id="cno">
        	<option>--请选择课程--</option>
        	<c:forEach items="${courseList }" var="course">
        		<option value="${course.cno }">${course.name }</option>
        	</c:forEach>
        </select>
        <select name="tno" id="tno" style=" margin-left: 20px;">
        	<option>--请选择教师--</option>
        	<c:forEach items="${teacherList }" var="teacher">
        		<option value="${teacher.tno }">${teacher.tname }</option>
        	</c:forEach>
        </select>
        <input type="submit" value="提交" style=" margin-left: 20px;"/>
    </form>
	</div>
	
	<table class="edtitable">
		<thead>
			<tr>
				<th colspan="8">课程列表</th>
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
				<th class="del-col">操作</th>
			</tr>
			<c:forEach var="tc" items="${list}">
				<tr>
					<td>${tc.cno}</td>
					<td>${tc.name}</td>
					<td>${tc.credit}</td>
					<td><fmt:formatDate value="${tc.periodstart}" pattern="yyyy年MM月dd日" /></td>
					<td><fmt:formatDate value="${tc.periodend}" pattern="yyyy年MM月dd日" /></td>
					
					<td>${tc.teacher.tname}</td>
					<td>${tc.teacher.phone}</td>
					
					<td>
						<!-- 刪除时加一个确认 -->
						<a href="javascript:delCourse(${tc.cno},${tc.teacher.tno })" class="delBtn">取消该课程</a>&nbsp;&nbsp;&nbsp; 
						<%-- <a href="${pageContext.request.contextPath }/removeDistributedCourse.do?cno=${tc.cno }&tno=${tc.teacher.tno } " class="delBtn">删除</a> --%>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<!-- 分页操作 -->
	<div style="text-align: center">
		<p class="paging">
			<a href="toDistributeCourse.do?page=${paging.indexpage-1}">&lt;&lt;首页 </a> 
			<a href="toDistributeCourse.do?page=${paging.page-1 }"> &lt; 上一页</a> 
			<strong>第${paging.page+1}页/共${paging.pagenumber}页</strong> 
			<a href="toDistributeCourse.do?page=${paging.page+1}">下一页 &gt;</a> 
			<a href="toDistributeCourse.do?page=${paging.pagenumber-1}">末页 &gt;&gt;</a>
		</p>

	</div>

</body>
</html>

