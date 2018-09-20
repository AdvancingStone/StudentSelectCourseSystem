<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询所有老师信息</title>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/jquery-3.3.1.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/editTable.js"></script>
<script type="text/javascript">
function delStudent(tno) {
	var flag = window.confirm("您确定要删除该老师信息吗？");
	if (flag) {
		$(".delBtn").parent().parent().remove(); 
		location.href = "${pageContext.request.contextPath }/delTeacher.do?tno=" + tno;
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
	<table class="edtitable">
		<thead>
			<tr>
				<th colspan="7">教师列表</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>教师编号</th>
				<th>姓名</th>
				<th>密码</th>
				<th>联系方式</th>
				<th>雇佣时间</th>
				<th>评论</th>
				<th>操作</th>
			</tr>
			<c:forEach var="teacher" items="${list}">
				<tr>
					<td>${teacher.tno}</td>
					<td>${teacher.tname}</td>
					<td>${teacher.password}</td>
					<td>${teacher.phone}</td>
					<td><fmt:formatDate value="${teacher.hiredate}" pattern="yyyy年MM月dd日" /></td>
					<td>${teacher.remark}</td>
					<td class="del-col">
						<!-- 刪除时加一个确认 -->
						<a href="javascript:delStudent(${teacher.tno})" class="delBtn">删除</a>&nbsp;&nbsp;&nbsp; 
						<a href="${pageContext.request.contextPath }/queryTeacherById.do?tno=${teacher.tno}" class="updateBtn">修改</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<!-- 分页操作 -->
	<div style="text-align: center">
		<p class="paging">
			<a href="queryAllTeacher.do?page=${paging.indexpage-1}">&lt;&lt;首页 </a> 
			<a href="queryAllTeacher.do?page=${paging.page-1 }"> &lt; 上一页</a> 
			<strong>第${paging.page+1}页/共${paging.pagenumber}页</strong> 
			<a href="queryAllTeacher.do?page=${paging.page+1}">下一页 &gt;</a> 
			<a href="queryAllTeacher.do?page=${paging.pagenumber-1}">末页 &gt;&gt;</a>
		</p>

	</div>

</body>
</html>

