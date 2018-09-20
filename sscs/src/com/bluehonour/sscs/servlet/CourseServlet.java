package com.bluehonour.sscs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluehonour.sscs.entity.Course;
import com.bluehonour.sscs.entity.Student;
import com.bluehonour.sscs.entity.Teacher;
import com.bluehonour.sscs.service.CourseService;
import com.bluehonour.sscs.service.StudentService;
import com.bluehonour.sscs.service.TeacherService;
import com.bluehonour.sscs.service.impl.CourseServiceImpl;
import com.bluehonour.sscs.service.impl.StudentServiceImpl;
import com.bluehonour.sscs.service.impl.TeacherServiceImpl;

@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletPath = request.getServletPath();
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 3);
		System.out.println(servletPath);
		System.out.println(methodName);
		try {
			// 3. 利用反射获取methodName 对应的方法
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			// 4. 利用反射调用对应的方法
			method.invoke(this, request, response);
		} catch (Exception e) {
			System.out.println("错误");
			response.sendRedirect("error.jsp");
		}
	}
	
	@SuppressWarnings("unused")
	private void addCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 接受表单数据
		String name = request.getParameter("name");
		int credit = Integer.parseInt(request.getParameter("credit"));
		Date periodStart = java.sql.Date.valueOf(request.getParameter("periodStart"));
		Date periodEnd = java.sql.Date.valueOf(request.getParameter("periodEnd"));
		
		Course cource = new Course(name, credit, periodStart, periodEnd);
		//2.调用业务层完成课程添加
		CourseService courceService = new CourseServiceImpl();

		//3.页面跳转
		try {
			int n = courceService.add(cource);
			if(n>0) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out =  response.getWriter();
				String result = "<script type=\"text/javascript\">alert('添加成功');location.href='/sscs/admin/addCourse.jsp';</script>";
				out.println(result);
				out.flush();
				out.close();
			} else {
				request.setAttribute("error", "课程添加失败");
				request.getRequestDispatcher("/admin/addCource.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("error", "课程添加失败");
			request.getRequestDispatcher("/admin/addCource.jsp").forward(request, response);
		}
	}


	/**
	 * 分配课程和老师 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void toDistributeCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//业务层、
		//获取所有课程信息
		CourseService courseService = new CourseServiceImpl();
		List<Course> courseList = courseService.findAll();
		//获取所有教师信息
		TeacherService teacherService = new TeacherServiceImpl();
		List<Teacher> teacherList = teacherService.findAll();
		//获取已分配教师的课程信息
		List<Course> tcList = courseService.findDistributedCourse();
		
		//跳转到分配老师的课程信息
		request.setAttribute("courseList", courseList);
		request.setAttribute("teacherList", teacherList);
		request.setAttribute("objList", tcList);
		request.setAttribute("toPage", "queryAllCourse");
		request.getRequestDispatcher("/PagingServlet").forward(request, response);
	}
	
	/**
	 * 给老师分配课程
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void distributeCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取课程编号和教师编号
		int cno = Integer.parseInt(request.getParameter("cno"));
		int tno = Integer.parseInt(request.getParameter("tno"));
		//2.调用业务层完成课程分配
		CourseService courseService = new CourseServiceImpl();
		int n = courseService.distributeCourse(cno,tno);
		
		//3.页面跳转
		request.getRequestDispatcher("/toDistributeCourse.do").forward(request, response);
	}
	
	/**
	 * 取消给老师分配课程
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void removeDistributedCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取课程编号和教师编号
		int cno = Integer.parseInt(request.getParameter("cno"));
		int tno = Integer.parseInt(request.getParameter("tno"));
		//2.调用业务层取消课程分配
		CourseService courseService = new CourseServiceImpl();
		int n = courseService.removeDistributedCourse(cno,tno);
		//3.页面跳转
		request.getRequestDispatcher("/toDistributeCourse.do").forward(request, response);
	}
	
	
	/**
	 * 查询可以选择的课程
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void toSelectCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Student stu = (Student)request.getSession().getAttribute("user");
		int sno = stu.getSno();
		//获取当前学生可以选择的课程
		CourseService courseService = new CourseServiceImpl();
//		List<Course> tcList = courseService.findDistributedCourse();//所有已经分配的课程
		List<Course> tcList = courseService.findSelectableCourse(sno);//可以选择的课程
		
		//页面跳转
		request.setAttribute("tcList", tcList);
		request.getRequestDispatcher("/student/courseSelectList.jsp").forward(request, response);
	}
	
	/**
	 * 学生选课
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void selectCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收cno,tno,sno
		String[] ctnoArr = request.getParameterValues("ctno");
		Student student = (Student) request.getSession().getAttribute("user");
		int sno = student.getSno();
		
		//获取可以选择的课程
		CourseService courseService = new CourseServiceImpl();
		courseService.selectCourse(ctnoArr,sno);
		
		//页面跳转
		request.getRequestDispatcher("/getSelectedCourse.do").forward(request, response);
	}
	
	/**
	 * 获取某个学生已经选择的课程（包括教师信息）
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void getSelectedCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取该学生
		Student stu = (Student)request.getSession().getAttribute("user");
		int sno = stu.getSno();
		
		CourseService courseService = new CourseServiceImpl();
		List<Course> scList = courseService.getSelectedCourse(sno);
		
		//页面跳转
		request.setAttribute("scList", scList);
		request.getRequestDispatcher("/student/courseSelectedList.jsp").forward(request, response);
	}
	
	/**
	 * 取消学生的课程
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void removeStudentDistributedCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取学号，课程编号和教师编号
		int sno = Integer.parseInt(request.getParameter("sno"));
		int cno = Integer.parseInt(request.getParameter("cno"));
		int tno = Integer.parseInt(request.getParameter("tno"));
		//2.调用业务层取消课程分配
		CourseService courseService = new CourseServiceImpl();
		int n = courseService.removeStudentDistributedCourse(sno,cno,tno);
		//3.页面跳转
		request.getRequestDispatcher("/getSelectedCourse.do").forward(request, response);
	}
}
