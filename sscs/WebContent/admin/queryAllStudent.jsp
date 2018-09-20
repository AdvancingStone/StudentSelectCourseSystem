<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询所有学生信息</title>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/jquery-3.3.1.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/editTable.js"></script>
<script type="text/javascript">
function delStudent(sno) {
	var flag = window.confirm("您确定要删除该学生信息吗？");
	if (flag) {
		$(".delBtn").parent().parent().remove(); 
		location.href = "${pageContext.request.contextPath }/delStudent.do?sno=" + sno;
	}
}
function submitForm() {
	var page = $("#toPageNum");
	$("#form").attr("action","${pageContext.request.contextPath }/queryAllStudent.do?page="+(page.val()-1));
	$("#form").submit();
}
</script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/base.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/editTable.css'/>">

</head>
<body>
<body>
	
	<div  style="margin-top:20px; margin-left: 70px;">
		<form action="${pageContext.request.contextPath }/queryCriteriaStudent.do" method="post">
			学号：<input type="text" name="sno" style="width:60px" />&nbsp;&nbsp;&nbsp;&nbsp;
			姓名：<input type="text" name="sname" style="width:60px" />&nbsp;&nbsp;&nbsp;&nbsp;
			性别：<select name="sex" id="sex">
                	<option></option>
                	<option>男</option>
                	<option>女</option>
                </select>&nbsp;&nbsp;&nbsp;&nbsp;
			班级：<input type="text" name="sclass" style="width:60px" />&nbsp;&nbsp;&nbsp;&nbsp;
			评论：<select name="remark" id="remark">
                	<option></option>
                	<option>优秀</option>
                	<option>良好</option>
                	<option>合格</option>
                	<option>差劲</option>
                </select>&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" value="查询" />
		</form>
	</div>
	
	<table class="edtitable">
		<thead>
			<tr>
				<th colspan="8">学生列表</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>班级</th>
				<th>密码</th>
				<th>出生年月日</th>
				<th>评论</th>
				<th class="del-col">操作</th>
			</tr>
			<c:forEach var="student" items="${list}">
				<tr>
					<td>${student.sno}</td>
					<td>${student.sname}</td>
					<td>${student.sex}</td>
					<td>${student.classno}</td>
					<td>${student.password}</td>
					<td><fmt:formatDate value="${student.birthday}" pattern="yyyy年MM月dd日" /></td>
					<td>${student.remark}</td>
					<td class="del-col">
						<!-- 刪除时加一个确认 -->
						<a href="javascript:delStudent(${student.sno})" class="delBtn">删除</a>&nbsp;&nbsp;&nbsp; 
<%-- 					<a href="${pageContext.request.contextPath }/delStudent.do?sno=${student.sno}" class="delBtn">删除</a>&nbsp;&nbsp;&nbsp;  --%>
						<a href="${pageContext.request.contextPath }/queryStudentById.do?sno=${student.sno}" class="updateBtn">修改</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<!-- 分页操作 -->
	<div style="text-align: center">
		<p class="paging">
			<a href="queryAllStudent.do?page=${paging.indexpage-1}">&lt;&lt;首页 </a> 
			<a href="queryAllStudent.do?page=${paging.page-1 }"> &lt; 上一页</a> 
			<strong>第${paging.page+1}页/共${paging.pagenumber}页</strong>
			<a href="queryAllStudent.do?page=${paging.page+1}">下一页 &gt;</a> 
			<a href="queryAllStudent.do?page=${paging.pagenumber-1}">末页 &gt;&gt;</a>&nbsp;
			
			<form method="post" id="form" action="" >
			
				到 <input type="text" id="toPageNum" name="toPageNum" style="width:30px" /> 页
				<input type="button" id="btn"  value="确认" onclick="submitForm()">
			</form>
			
		</p>

	</div>
</body>
</html>

