<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加管理员</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/add.css'/>">
 <script type="text/javascript" src="${pageContext.request.contextPath }/My97DatePicker/WdatePicker.js"></script>
 <script type="text/javascript"
	src="${pageContext.request.contextPath }/kindeditor/kindeditor-all.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/kindeditor/lang/zh_CN.js"></script>
 <script>
	KindEditor.ready(function(K) {
		filterMode: false,//是否开启过滤模式
		window.editor = K.create('#introduction-id');
	});
</script>
</head>
<body>

	<div class="nav">
	<%-- 	${error }
		<div><img src="${pageContext.request.contextPath }/images/register_admin.jpg"></div> --%>
		
		<%
			if(request.getAttribute("error") != null){
		%>
				<div><img src="${pageContext.request.contextPath }/images/add_admin_error.jpg"></div>
		<%
			} else{
		%>
				<div><img src="${pageContext.request.contextPath }/images/register_admin.jpg"></div>
		<%
			} 
		%>
		<div class="nav1">
			<form action="${pageContext.request.contextPath }/addAdmin.do" method="post">
				<p>
					<label for="userId">管理员账号：</label> <input type="text" name="userId" id="userId""><span>请输入4-10位用户名</span>
				</p>
				<p>
					<label for="userName">真实姓名：</label> <input type="text" name="userName"
					 	id="userName" value=""><span>请输入您的真实姓名</span>
				</p>
				<p>
					<label for="passWord">密码：</label> <input type="password" name="passWord"
						id="passWord" value="" size="20px"><span>密码为6-16位</span>
				</p>
				<p>
					<label for="rePassWord">确认密码：</label> <input type="password" name="rePassWord"
						id="rePassWord" value="" size="20px"><span>请再次输入密码</span>
				</p>
				<p>
					<label for="age">年龄：</label> <input type="text" name="age" id="age" value=""><span>请输入年龄</span>
				</p>
				<p>
					<label for="score">成绩：</label> <input type="text" name="score" id="score" value=""><span>请输入成绩</span>
				</p>
				<p>
					<label for="enterDate">入职时间：</label> <input type="text" name="enterDate"
						id="enterDate" value="" onfocus="WdatePicker({highLineWeekDay:true,isShowToday:true,isShowWeek:true})"><span>请输入入职时间</span>
				</p>
				<p>
					<label for="introduction">简介：</label>
                	<textarea  class="no" name="introduction" id="introduction-id"
						style=" width: 700px; height: 200px; visibility: hidden; display: block;">
					</textarea>
				</p>
				<button class="sub">
					<img src="${pageContext.request.contextPath }/images/button.gif">
				</button>
			</form>
		</div>
	</div>
	<script>
		window.onload = function(e) {
			var form = document.querySelector('form');
			var userId = document.querySelector('#userId');
			var userName = document.querySelector('#userName');
			var passWord = document.querySelector('#passWord');
			var rePassWord = document.querySelector('#rePassWord');
			var age = document.querySelector('#age');
			var score = document.querySelector('#score');
			var enterDate = document.querySelector('#enterDate');
			var span = document.querySelectorAll('span');

			//onsubmit事件
			form.onsubmit = function(e) {
				var userId = checkUserId();
				if (!userId) {
					return false;
				}
				var username = checkUserName();
				if (!username) {
					return false;
				}
				var password = checkPassWord();
				if (!password) {
					return false;
				}
				var rePassWord = checkRePassWord();
				if (!rePassWord) {
					return false;
				}
				var age = checkAge();
				if (!age) {
					return false;
				}
				var score = checkScore();
				if (!score) {
					return false;
				}
				var enterDate = checkEnterDate();
				if (!enterDate) {
					return false;
				}
				return true;
			};

			//onblur失去焦点事件
			userId.onblur = function(e) {
				checkUserId();
			};
			userName.onblur = function(e) {
				checkUserName();
			};
			passWord.onblur = function(e) {
				checkPassWord();
			};
			rePassWord.onblur = function(e) {
				checkRePassWord();
			};
			age.onblur = function(e) {
				checkAge();
			};
			score.onblur = function(e) {
				checkScore();
			};
			enterDate.onblur = function(e) {
				checkEnterDate();
			};

			//---------------------------------函数封装-------------------------------------------------------------
			//管理员账户（3-10位）
			function checkUserId(e) {
				if (userId.value.length == 0) {
					span[0].innerText = '账户不能为空';
					span[0].className = 'danger';
					return false;
				}
				var pattern = /^[A-Za-z0-9]{3,10}$/;
				if (!pattern.test(userId.value)) {
					span[0].innerText = '账户格式错误，请重新输入';
					span[0].className = 'danger';
					return false;
				}
				span[0].innerText = '管理员账户输入正确';
				span[0].className = 'success';
				return true;
			}

			//真实姓名（2-4位汉字）
			function checkUserName(e) {
				if (userName.value.length == 0) {
					span[1].innerText = '真实姓名不能为空';
					span[1].className = 'danger';
					return false;
				}
				var pattern = /^[\u4e00-\u9fa5]{2,4}$/;
				if (!pattern.test(userName.value)) {
					span[1].innerText = '真实姓名格式错误，请重新输入';
					span[1].className = 'danger';
					return false;
				}
				span[1].innerText = '真实姓名输入正确';
				span[1].className = 'success';
				return true;
			}
			//登录密码（6-16位）
			function checkPassWord(e) {
				if (passWord.value.length == 0) {
					span[2].innerText = '密码不能为空';
					span[2].className = 'danger';
					return false;
				}
				var pattern = /^[A-Za-z0-9]{6,16}$/;
				if (!pattern.test(passWord.value)) {
					span[2].innerText = '密码不符合格式，请重新输入';
					span[2].className = 'danger';
					return false;
				}
				span[2].innerText = '密码输入正确';
				span[2].className = 'success';
				return true;
			}

			//重复登录密码
			function checkRePassWord(e) {
				if (rePassWord.value.length == 0) {
					span[3].innerText = '重复密码不能为空';
					span[3].className = 'danger';
					return false;
				}
				if (rePassWord.value != passWord.value) {
					span[3].innerText = '两次输入的密码不一致，请重新输入';
					span[3].className = 'danger';
					return false;
				}
				span[3].innerText = '两次密码一致';
				span[3].className = 'success';
				return true;
			}

			//年龄（1-3位）
			function checkAge(e) {
				if (age.value.length == 0) {
					span[4].innerText = '年龄不能为空';
					span[4].className = 'danger';
					return false;
				}
				var pattern = /^[1-9]{1,3}$/;
				if (!pattern.test(age.value)) {
					span[4].innerText = '年龄格式错误，请重新输入';
					span[4].className = 'danger';
					return false;
				}
				span[4].innerText = '年龄输入正确';
				span[4].className = 'success';
				return true;
			}

			//成绩
			function checkScore(e) {
				if (score.value.length == 0) {
					span[5].innerText = '成绩不能为空';
					span[5].className = 'danger';
					return false;
				}
				/*   var pattern = /^[0-9]+\.?[0-9]*$/; */
				var pattern = /^[0-9]+\.?[0-9]*$/;
				if (!pattern.test(score.value)) {
					span[5].innerText = '成绩格式错误，请重新输入';
					span[5].className = 'danger';
					return false;
				}
				span[5].innerText = '成绩输入正确';
				span[5].className = 'success';
				return true;
			}

			//入职时间（格式xxxx-xx-xx)
			function checkEnterDate(e) {
				if (enterDate.value.length == 0) {
					span[6].innerText = '入职时间不能为空';
					span[6].className = 'danger';
					return false;
				}
				var pattern = /^[0-9]{4}\-?[0-9]{1,2}\-?[0-9]{1,2}$/;
				if (!pattern.test(enterDate.value)) {
					span[6].innerText = '时间格式：xxxx-xx-xx';
					span[6].className = 'danger';
					return false;
				}
				span[6].innerText = '时间格式正确';
				span[6].className = 'success';
				return true;
			}

		}
	</script>
</body>
</html>