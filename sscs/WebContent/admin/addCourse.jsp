<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加学生</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/add.css'/>">
    <script type="text/javascript" src="${pageContext.request.contextPath }/My97DatePicker/WdatePicker.js"></script>
</head>
<body>

<div class="nav">
		<%
			if(request.getAttribute("error") != null){
		%>
				<div><img src="${pageContext.request.contextPath }/images/add_course_error.jpg"></div>
		<%
			} else{
		%>
				<div><img src="${pageContext.request.contextPath }/images/register_course.jpg"></div>
		<%
			} 
		%>
    
    <div class="nav1">
        <form action="${pageContext.request.contextPath }/addCourse.do" method="post">
            <p>
                <label for="name">课程名称：</label>
                <input type="text" id="name" name="name" value="">
            </p>
             <p>
                <label for="name">学分：</label>
                <input type="text" id="credit" name="credit" value="">
            </p>
             <p>
            	<label for="periodStart">开课日期:</label>
           	 <input type="text" id="periodStart" name="periodStart" value="" onfocus="WdatePicker({highLineWeekDay:true,isShowToday:true,isShowWeek:true})">
            </p>
             <p>
            	<label for="periodEnd">结课日期:</label>
           	 <input type="text" id="periodEnd" name="periodEnd" value="" onfocus="WdatePicker({highLineWeekDay:true,isShowToday:true,isShowWeek:true})">
            </p>
            <div align="center">
	            <input type="submit" value="保存"  />
            </div>
            <div align="center">
				${error }
            </div>
        </form>
    </div>
</div>
    
</body>
</html>