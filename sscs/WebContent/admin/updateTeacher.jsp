<%@page import="com.bluehonour.sscs.entity.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改教师信息</title>
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
	//简单模式初始化
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="remark"]', {
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			items : [ 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor',
					'bold', 'italic', 'underline', 'removeformat', '|',
					'justifyleft', 'justifycenter', 'justifyright',
					'insertorderedlist', 'insertunorderedlist', '|',
					'emoticons', 'image', 'link' ]
		});
	});
</script>
</head>
<body>

	<div class="nav">
		<%
			Teacher teacher = (Teacher) request.getAttribute("teacher");
			if (request.getAttribute("error") != null) {
		%>
		<div>
			<img
				src="${pageContext.request.contextPath }/images/add_teacher_error.jpg">
		</div>
		<%
			}
		%>
		<div>
			<img
				src="${pageContext.request.contextPath }/images/update_teacher.jpg">
		</div>


		<div class="nav1">
			<form action="${pageContext.request.contextPath }/updateTeacher.do"
				method="post">
				<input type="hidden" name="tno" value="${teacher.tno }">
				<p>
					<label for="name">教师姓名：</label> <input type="text" id="name"
						name="name" value="${teacher.tname }"><span>请输入教师姓名</span>
				</p>
				<p>
					<label for="password">密码：</label> <input type="text" id="password"
						name="password" value="${teacher.password }"><span>密码为6-16位</span>
				</p>
				<p>
					<label for="tel">关联手机号:</label> <input type="text" id="tel"
						name="tel" value="${teacher.phone }"><span>请输入手机号</span>
				</p>
				<p>
					<label for="birthday">雇佣时间:</label> <input type="text"
						id="hiredate" name="hiredate" value="${teacher.hiredate }"
						onfocus="WdatePicker({highLineWeekDay:true,isShowToday:true,isShowWeek:true})"><span>请输入出生年月日</span>
				</p>
					<p>
				<label for="remark">简介：</label>
                <textarea  class="no" name="remark" id="remark-id"
						style=" width: 550px; height: 200px; visibility: hidden; display: block;">
				${teacher.remark	}
				</textarea>
			</p>
				<button class="sub">
					<img src="${pageContext.request.contextPath }/images/confirm.jpg">
				</button>
			</form>
		</div>
	</div>

</body>
</html>