<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看学生个人信息</title>
<style type="text/css">
.nav {
	width: 800px;
	margin: auto;
}
.nav1 {
	border: 1px solid #666666;
	border-radius: 5px;
}
label {
	width: 150px;
	height: 30px;
	line-height: 30px;
	text-align: right;
	font-size: 14px;
	display: inline-block;
}
</style>
</head>
<body>

	<div class="nav">

		<div class="nav1">
			<p>
				<label for="sno">学号：</label> 
				<input type="text" id="sno" name="sno" value="${user.sno }">
			</p>
			<p>
				<label for="name">学生姓名：</label> 
				<input type="text" id="name" name="name" value="${user.sname }">
			</p>
			<p>
				<label for="password">密码：</label> 
				<input type="text" id="password" name="password" value="${user.password }">
			</p>
			<p>
				<label for="classno">班级：</label> 
				<input type="text" id="classno" name="classno" value="${user.classno }">
			</p>
				<p>
				<label for="tel">关联手机号：</label> 
				<input type="text" id="tel" name="tel" value="${user.phone }">
			</p>
			<p>
				<label>性别：</label> 
				<input type="text" name="sex" value="${user.sex }" >
			</p>

			<p>
				<label for="birthday">出生年月日：</label> <input type="text"
					id="birthday" name="birthday" value="${user.birthday }">
			</p>
			<p>
				<label for="remark">评论：</label> 
				<input type="text" id="remark" name="remark" value="${user.remark }">
			</p>

		</div>
	</div>

</body>
</html>