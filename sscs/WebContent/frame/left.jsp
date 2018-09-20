<%@page import="com.bluehonour.sscs.entity.Admin"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>树型菜单</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/left.css'/>">
</head>
<body>

	<div class="treebox">
		<ul class="menu">
			<c:choose>
				<c:when test="${person == 'administrator'}">
					<li class="level1"><a href="#none">管理员功能<i class="down"></i></a>
						<ul class="level2">
							<li><a href="../admin/queryAdmin.jsp" target="right">查看个人信息</a></li>
							<li><a href="../admin/addAdmin.jsp" target="right">添加新的管理员</a></li>
						</ul></li>
					<li class="level1"><a href="#none">学生功能<i></i></a>
						<ul class="level2">
							<li><a href="${pageContext.request.contextPath }/queryClass.do" target="right">添加学生</a></li>
							<li><a href="${pageContext.request.contextPath }/queryAllStudent.do" target="right">获取所有学生</a></li>
						</ul></li>  
					<li class="level1"><a href="#none">课程功能<i></i></a>
						<ul class="level2">
							<li><a href="../admin/addCourse.jsp" target="right">添加课程</a></li>
							<li><a href="${pageContext.request.contextPath }/toDistributeCourse.do" target="right">查询课程
							</a></li>
						</ul></li>
					<li class="level1"><a href="#none">教师功能<i></i></a>
						<ul class="level2">
							<li><a href="../admin/addTeacher.jsp" target="right">添加教师</a></li>
							<li><a href="${pageContext.request.contextPath }/queryAllTeacher.do" target="right">获取所有教师</a></li>
						</ul></li>
				</c:when>

				<c:when test="${person == 'student'}">
					<li class="level1"><a href="#none">学生功能<i></i></a>
						<ul class="level2">
							<li><a href="../student/queryStudent.jsp" target="right">插看个人信息</a></li>
							<li><a href="${pageContext.request.contextPath }/toSelectCourse.do" target="right">选课 </a></li>
							<li><a href="${pageContext.request.contextPath }/getSelectedCourse.do" target="right">查看已选课程</a></li>
						</ul>
					</li>
				</c:when>

				<c:when test="${person == 'teacher'}">
					<li class="level1"><a href="#none">教师功能<i></i></a>
						<ul class="level2">
							<li><a href="../teacher/queryTeacher.jsp" target="right">查看个人信息</a></li>
							<li><a href="${pageContext.request.contextPath }/getStudentCourseDescription.do" target="right">评分</a></li>
							<li><a href="${pageContext.request.contextPath }/queryAssumeCourse.do" target="right">查看任课课程</a></li>
						</ul>
					</li>
				</c:when>

			</c:choose>

		</ul>
	</div>

	<!-- 引入 jQuery -->
	<script src="../scripts/jquery-3.3.1.js"></script>
	<script src="../scripts/easing.js"></script>
	<script>
		//等待dom元素加载完毕.
		$(function() {
			$(".treebox .level1>a").click(
					function() {
						$(this).addClass('current') //给当前元素添加"current"样式
						.find('i').addClass('down') //小箭头向下样式
						.parent().next().slideDown('slow', 'easeOutQuad') //下一个元素显示
						.parent().siblings().children('a').removeClass(
								'current')//父元素的兄弟元素的子元素去除"current"样式
						.find('i').removeClass('down').parent().next().slideUp(
								'slow', 'easeOutQuad');//隐藏
						return false; //阻止默认时间
					});
		})
	</script>
</body>

</html>