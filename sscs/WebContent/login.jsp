<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生选课系统</title>
<link href="css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<script type="text/javascript">
	function _hyz() {
		var img = document.getElementById("verifyImg");
		img.src = "${pageContext.request.contextPath }/VerifyCodeServlet?a=" + new Date().getTime() ;
	}
</script>
</head>
<body>
	
<div class="header">
  <img alt="logo" src="images/logo.jpg">
</div>

<div class="banner">

<div class="login-aside">
  <div id="o-box-up"></div>
  <div id="o-box-down"  style="table-layout:fixed;">
   <div class="error-box">
   	<font size="3" color="red">${error }</font>
   </div>
   
   <form action="${pageContext.request.contextPath }/login.do" method="post">
   <div class="fm-item">
	   <label for="logonId" class="form-label">用户ID：</label>
	   <input type="text" maxlength="100" name="userId" class="i-text" value="${userid }" />    
  </div>
  
  <div class="fm-item">
	   <label for="logonId" class="form-label">登陆密码：</label>
	   <input type="password" maxlength="100" name="password" class="i-text" value="${password }" />    
  </div>
  
  <div class="fm-item pos-r">
	   <label for="logonId" class="form-label">验证码</label>
	   <input type="text" value="输入验证码" name="verifyCode" maxlength="100" id="yzm" class="i-text yzm" />    
       <img src="${pageContext.request.contextPath }/VerifyCodeServlet"  id="verifyImg">
       <a href="javascript:_hyz()">看不清</a>
  </div>
  
  <div class="fm-item pos-r" s>
  		<label style="display: inline; margin-left: 20px" for="logonId" class="form-label">管理员</label>
  		<input type="radio" name="person" value="administrator" checked="checked"/>
		<label style="display: inline; margin-left: 20px" for="logonId" class="form-label">老师</label>
		<input type="radio" name="person" value="teacher" />
		<label style="display: inline; margin-left: 20px" for="logonId" class="form-label">学生</label>
		<input type="radio" name="person" value="student" />
  </div>
  					
  
  <div class="fm-item">
	   <label for="logonId" class="form-label"></label>
	   <input type="submit" value="" tabindex="4" id="send-btn" class="btn-login"> 
       <div class="ui-form-explain"></div>
  </div>
  
  </form>
  
  </div>

<!-- 背景 -->
</div>
	<div class="bd">
		<ul>
			<li style="background:url(themes/theme-pic1.jpg) #CCE1F3 center 0 no-repeat;"></li>
			<li style="background:url(themes/theme-pic2.jpg) #BCE0FF center 0 no-repeat;"></li>
		</ul>
	</div>

	<div class="hd"><ul></ul></div>
</div>


<div class="banner-shadow"></div>

<div class="footer">
   <p>软工1525班 刘帅 友情制作<a target="_blank" href="http://www.bluehonour.com/">...</a></p>
</div>
	
	
</body>
</html>