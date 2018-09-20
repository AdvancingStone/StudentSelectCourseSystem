<%@page import="com.bluehonour.sscs.entity.Admin"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看管理员</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/kindeditor/kindeditor-all.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/kindeditor/lang/zh_CN.js"></script>
<script>
        //简单模式初始化
        var editor;
        KindEditor.ready(function(K) {
            editor = K.create('textarea[name="introduction"]', {
                resizeType : 1,
                allowPreviewEmoticons : false,
                allowImageUpload : false,
                items : [
                    'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                    'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                    'insertunorderedlist', '|', 'emoticons', 'image', 'link']
            });
        });
</script>
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
	<%
		Admin admin = (Admin) request.getSession().getAttribute("user");
	%>
	<div class="nav">
		<div>
			<img src="${pageContext.request.contextPath }/images/adminHead.jpg">
		</div>
		<div class="nav1">
			<p>
				<label for="userId">管理员账号：</label> <input type="text" name="userId"
					id="userId" value="<%=admin.getUserId()%>">
			</p>
			<p>
				<label for="userName">真实姓名：</label> <input type="text"
					name="userName" id="userName" value="<%=admin.getUserName()%>">
			</p>
			<p>
				<label for="passWord">密码：</label> <input type="text"
					name="passWord" id="passWord" value="<%=admin.getPassword()%>">
			</p>
			<p>
				<label for="age">年龄：</label> <input type="text" name="age" id="age"
					value="<%=admin.getAge()%>">
			</p>
			<p>
				<label for="score">成绩：</label> <input type="text" name="score"
					id="score" value="<%=admin.getScore() %>" >
			</p>
			<p>
				<label for="enterDate">入职时间：</label> <input type="text"
					name="enterDate" id="enterDate" value="<%=admin.getEnterDate() %>" >
			</p>
			<p>
				<label for="introduction">简介：</label>
                <textarea  class="no" name="introduction" id="introduction-id"
						style=" width: 550px; height: 200px; visibility: hidden; display: block;">
					<%=admin.getIntroduction() %>
				</textarea>
			</p>
		</div>
	</div>
</body>
</html>