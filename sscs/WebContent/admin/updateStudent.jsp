<%@page import="com.bluehonour.sscs.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改学生信息</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/add.css'/>">
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath }/scripts/student.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath }/My97DatePicker/WdatePicker.js"></script>
</head>
<body>

<div class="nav">
		<%	
			Student student = (Student) request.getAttribute("student");
			System.out.println(student);
			if(request.getAttribute("error") != null){
		%>
				<div><img src="${pageContext.request.contextPath }/images/add_student_error.jpg"></div>
		<%
			} 
		%>
		<div><img src="${pageContext.request.contextPath }/images/update_student.jpg"></div>
		
    
    <div class="nav1">
        <form action="${pageContext.request.contextPath }/updateStudent.do" method="post">
        	<input type="hidden" name="sno" value="${student.sno }">
            <p>
                <label for="name">学生姓名：</label>
                <input type="text" id="name" name="name" value="${student.sname }"><span>请输入学生姓名</span>
            </p>
            <p>
                <label for="password">密码：</label>
                <input type="text" id="password" name="password" value="${student.password }"><span>密码为6-16位</span>
            </p>
            <p>
                <label for="classno">班级：</label>
                <select name="classno" id="classno">
                	<option>--${student.classno }班--</option>
                	<c:forEach items="${classList }" var="clazz">
        				<option>--${clazz.classno}班--</option>
        			</c:forEach>
                </select>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>请输入班级</span>
            </p>
            <p>
                <label>性别：</label>
                <input type="radio" id="man" name="sex" value="男" ${(student.sex=='男')?'checked' : ''} >男
                <input type="radio" id="woman" name="sex" value="女" ${(student.sex=='女')?'checked' : ''}>女 
            </p>
           
            <p>
            	<label for="tel">关联手机号:</label>
           	 <input type="text" id="tel" name="tel" value="${student.phone }"><span>请输入手机号</span>
            </p>
             <p>
            	<label for="birthday">出生年月日:</label>
           	 <input type="text" id="birthday" name="birthday" value="${student.birthday }" onfocus="WdatePicker({highLineWeekDay:true,isShowToday:true,isShowWeek:true})"><span>请输入出生年月日</span>
            </p>
            <p>
            	<label for="remark">评论:</label>
            	 <select name="remark" id="remark">
                	<option>优秀</option>
                	<option>良好</option>
                	<option>合格</option>
                	<option>差劲</option>
                </select>
               	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>请对该学生进行评论</span>
            </p>
            <button class="sub">
                <img src="${pageContext.request.contextPath }/images/confirm.jpg">
            </button>
        </form>
    </div>
</div>

</body>
</html>