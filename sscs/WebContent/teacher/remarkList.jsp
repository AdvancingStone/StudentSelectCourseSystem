<%@page import="java.util.List"%>
<%@page import="com.bluehonour.sscs.entity.StudentCourse"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评分</title>
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
</script>
<script type="text/javascript">
	function submitForm(sno,cno) {
		var formId = "form"+sno+cno;
		document.getElementById(formId).submit();
	}
	
	var change2Text = true;
	function changeContent(sno,cno) {
		var btnId = "#btn"+sno+cno;
		var content = "#content"+sno+cno; 
		var formId = "#form"+sno+cno;
		if(change2Text){
			$(content).replaceWith("<input type='text' id='content"+sno+cno+"' maxlength='6' style='width:60px' value='"+$(content).text() +"' />"); 
			$(btnId).text("确认");
		} else{
			$(btnId).text("修改");
			$(formId).append("<input type='hidden' name='score' value='"+ $(content).val() +"' />"); 
			$(content).replaceWith("<span id='content"+sno+cno+"'>"+$(content).val()+"</span>"); 
			
			$(formId).submit();  
		}
		change2Text = !change2Text;
	}
	
</script>
</head>
<body>
<body>
	
	<table class="edtitable">
		<thead>
			<tr>
				<th colspan="9">学生课程评分</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>班级</th>
				<th>专业</th>
				<th>课程编号</th>
				<th>课程名</th>
				<th>学分</th>
				<th>成绩</th>
				<th>选择</th>
			</tr>
			<c:forEach var="sc" items="${objList }">
				<tr>
					<td>${sc.sno}</td>
					<td>${sc.sname}</td>
					<td>${sc.classno}</td>
					<td>${sc.cname}</td>
					<td>${sc.cno}</td>
					<td>${sc.name}</td>
					<td>${sc.credit}</td>
					<form id="form${sc.sno }${sc.cno}" action="${pageContext.request.contextPath }/courseRemark.do" method="post">
						<input type="hidden" name="sno" value="${sc.sno }" />
						<input type="hidden" name="cno" value="${sc.cno}" />
						<input type="hidden" name="tno" value="${user.tno }" />
						<c:if test="${sc.score <= 0 }">
							<td>
								<input type="text" name="score" id="content" maxlength="6" style="width:60px"/>
							</td>
							<td>
								<%-- <a href="javascript:void(0)" onclick="submitForm(${sc.sno },${sc.cno})" >评分</a> --%>
								<input type="submit" value="评分" />
							</td>
						</c:if>
						
						<c:if test="${sc.score > 0 }">
							<td>
								<span id="content${sc.sno }${sc.cno}">${sc.score }</span>
							</td>
							<td>
								<button id="btn${sc.sno }${sc.cno}" type="button" onclick="changeContent(${sc.sno },${sc.cno})">修改</button>
							</td>
						</c:if>
					</form>
						
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<!-- 分页操作 -->
	<div style="text-align: center">
		<p class="paging">
			<a href="getStudentCourseDescription.do?page=${paging.indexpage-1}">&lt;&lt;首页 </a> 
			<a href="getStudentCourseDescription.do?page=${paging.page-1 }"> &lt; 上一页</a> 
			<strong>第${paging.page+1}页/共${paging.pagenumber}页</strong> 
			<a href="getStudentCourseDescription.do?page=${paging.page+1}">下一页 &gt;</a> 
			<a href="getStudentCourseDescription.do?page=${paging.pagenumber-1}">末页 &gt;&gt;</a>
		</p>

	</div>
</body>
</html>

