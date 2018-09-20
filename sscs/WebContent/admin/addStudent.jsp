<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加学生</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/add.css'/>">
     <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/scripts/student.js"></script>
      <script type="text/javascript" src="${pageContext.request.contextPath }/My97DatePicker/WdatePicker.js"></script>
</head>
<body>

<div class="nav">
		<%
			if(request.getAttribute("error") != null){
		%>
				<div><img src="${pageContext.request.contextPath }/images/add_admin_error.jpg"></div>
		<%
			} else{
		%>
				<div><img src="${pageContext.request.contextPath }/images/register_student.jpg"></div>
		<%
			} 
		%>
    
    <div class="nav1">
        <form action="${pageContext.request.contextPath }/addStudent.do" method="post">
            <p>
                <label for="name">学生姓名：</label>
                <input type="text" id="name" name="name" value=""><span>请输入学生姓名</span>
            </p>
            <p>
                <label for="password">密码：</label>
                <input type="text" id="password" name="password" value=""><span>密码为6-16位</span>
            </p>
            <p>
                <label for="classno">班级：</label>
                <select name="classno" id="classno">
                	<option>--请选择班级--</option>
                	<c:forEach items="${classList }" var="clazz">
        				<option>--${clazz.classno}班--</option>
        			</c:forEach>
                </select>
               <span style="margin-left: 100px">请输入班级</span>
            </p>
            <p>
                <label>性别：</label>
                <input type="radio" name="sex" value="男" checked="checked" >男
                <input type="radio" name="sex" value="女">女 
            </p>
           
            <p>
            	<label for="tel">关联手机号:</label>
           	 <input type="text" id="tel" name="tel" value=""><span>请输入手机号</span>
            </p>
             <p>
            	<label for="birthday">出生年月日:</label>
           	 <input type="text" id="birthday" name="birthday" value="" onfocus="WdatePicker({highLineWeekDay:true,isShowToday:true,isShowWeek:true})"><span>请输入出生年月日</span>
            </p>
           	<p>
            	<label for="remark">评论:</label>
            	 <select name="remark" id="remark">
                	<option>--请选择--</option>
                	<option>优秀</option>
                	<option>良好</option>
                	<option>合格</option>
                	<option>差劲</option>
                </select>
               	<span style="margin-left: 100px">请对该学生进行评论</span>
            </p>
            <button class="sub">
                <img src="${pageContext.request.contextPath }/images/submit.jpg">
            </button>
            <div align="center">
				${error }
            </div>
        </form>
        
    </div>
</div>
    
</body>
</html>