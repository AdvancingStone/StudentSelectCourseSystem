<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/kindeditor/kindeditor-all.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/kindeditor/lang/zh_CN.js"></script>
<title>查看教师个人信息</title>
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

		<div class="nav1">
			<p>
				<label for="sno">教师编号：</label> 
				<input type="text" id="tno" name="tno" value="${user.tno }">
			</p>
			<p>
				<label for="name">姓名：</label> 
				<input type="text" id="name" name="name" value="${user.tname }">
			</p>
			<p>
				<label for="password">密码：</label> 
				<input type="text" id="password" name="password" value="${user.password }">
			</p>
			<p>
				<label for="tel">关联手机号：</label> 
				<input type="text" id="tel" name="tel" value="${user.phone }">
			</p>
			<p>
				<label for="birthday">雇佣日期：</label> <input type="text"
					id="birthday" name="birthday" value="${user.hiredate }">
			</p>
			<p>
				<label for="remark">评论：</label> 
				<textarea  class="no" name="remark" id="remark-id"
						style=" width: 550px; height: 200px; visibility: hidden; display: block;">
				${user.remark }
				</textarea>
			</p>

		</div>
	</div>

</body>
</html>