<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加教师</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/add.css'/>">
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath }/scripts/teacher.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/kindeditor/kindeditor-all.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/kindeditor/lang/zh_CN.js"></script>
<script>
	KindEditor.ready(function(K) {
		filterMode: false,//是否开启过滤模式
		window.editor = K.create('#remark-id');
	});
</script>

</head>
<body>

	<div class="nav">
		<%
			if (request.getAttribute("error") != null) {
		%>
		<div><img src="${pageContext.request.contextPath }/images/add_teacher_error.jpg"></div>
		<%
			} else {
		%>
		<div><img src="${pageContext.request.contextPath }/images/register_teacher.jpg"></div>
		<%
			}
		%>

		<div class="nav1">
			<form action="${pageContext.request.contextPath }/addTeacher.do"
				method="post">
				<p>
					<label for="name">教师姓名：</label> <input type="text" id="name"
						name="name" value=""><span>请输入教师姓名</span>
				</p>
				<p>
					<label for="password">教师密码：</label> <input type="text"
						id="password" name="password" value=""><span>密码为6-16位</span>
				</p>

				<p>
					<label for="tel">联系方式：</label> <input type="text" id="tel"
						name="tel" value=""><span>请输入手机号</span>
				</p>
				<p>
					<label for="hiredate">入职时间：</label> <input type="text"
						id="hiredate" name="hiredate" value=""
						onfocus="WdatePicker({highLineWeekDay:true,isShowToday:true,isShowWeek:true})"><span>请输入入职时间</span>
				</p>
				<p>
					<label for="remark">评论：</label>
					<textarea class="no" name="remark" id="remark-id"
						style="width: 700px; height: 200px; visibility: hidden; display: block;">
					</textarea>
				</p>
				<button class="sub">
					<img src="${pageContext.request.contextPath }/images/submit.jpg">
				</button>
				<div align="center">${error }</div>
			</form>
		</div>
	</div>


</body>
</html>