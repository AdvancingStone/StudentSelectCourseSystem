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
import com.bluehonour.sscs.entity.StudentCourse;
import com.bluehonour.sscs.entity.Teacher;
import com.bluehonour.sscs.service.CourseService;
import com.bluehonour.sscs.service.StudentService;
import com.bluehonour.sscs.service.TeacherService;
import com.bluehonour.sscs.service.impl.CourseServiceImpl;
import com.bluehonour.sscs.service.impl.StudentServiceImpl;
import com.bluehonour.sscs.service.impl.TeacherServiceImpl;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletPath = request.getServletPath();
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 3);
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			System.out.println("错误");
			response.sendRedirect("error.jsp");
		}
	}

	/**
	 * 添加教师
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void addTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取添加管理员的表单数据
		String tname = request.getParameter("name");
		String password = request.getParameter("password");
		long phone = Long.parseLong(request.getParameter("tel"));
		Date hiredate = java.sql.Date.valueOf(request.getParameter("hiredate"));
		String remark = request.getParameter("remark");

		Teacher teacher = new Teacher(tname, password, phone, hiredate, remark);
		// 调用业务层进行添加操作
		TeacherService teacherService = new TeacherServiceImpl();
		try {
			int n = teacherService.add(teacher);
			if (n > 0) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				String result = "<script type=\"text/javascript\">alert('添加成功');location.href='/sscs/admin/addTeacher.jsp';</script>";
				out.println(result);
				out.flush();
				out.close();
			} else {
				request.setAttribute("error", "教师添加失败");
				request.getRequestDispatcher("/admin/addTeacher.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("error", "教师添加失败");
			request.getRequestDispatcher("/admin/addTeacher.jsp").forward(request, response);
		}
	}

	/**
	 * 查询所有教师信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void queryAllTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 调用业务层获取所有学生
		TeacherService service = new TeacherServiceImpl();
		List<Teacher> teaList = service.findAll();
		// 跳转到分页Servlet,分页后在跳转到jsp
		request.setAttribute("objList", teaList);
		request.setAttribute("toPage", "queryAllTeacher");
		request.getRequestDispatcher("/PagingServlet").forward(request, response);
	}

	/**
	 * 根据id查询老师
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void queryTeacherById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tno = request.getParameter("tno");
		int no = 0;
		try {
			no = Integer.parseInt(tno);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		TeacherService service = new TeacherServiceImpl();

		try {
			Teacher teacher = service.findById(no);
			if (teacher != null) {
				request.setAttribute("teacher", teacher);
				request.getRequestDispatcher("/admin/updateTeacher.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除某个老师
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void delTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tno = request.getParameter("tno");
		int no = 0;
		try {
			no = Integer.parseInt(tno);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		TeacherService service = new TeacherServiceImpl();

		try {
			int n = service.delete(no);
			if (n > 0) {
				request.getRequestDispatcher("/queryAllTeacher.do").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改教师信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void updateTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int tno = Integer.parseInt(request.getParameter("tno"));
		String tname = request.getParameter("name");
		String password = request.getParameter("password");
		long phone = Long.parseLong(request.getParameter("tel"));
		Date hiredate = java.sql.Date.valueOf(request.getParameter("hiredate"));
		String remark = request.getParameter("remark");

		Teacher teacher = new Teacher(tno, tname, password, phone, hiredate, remark);
		// 调用业务层进行添加操作
		TeacherService teacherService = new TeacherServiceImpl();
		try {
			int n = teacherService.update(teacher);
			System.out.println(n);
			if (n > 0) {
				request.getRequestDispatcher("/queryAllTeacher.do").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("error", "教师更新失败");
			request.getRequestDispatcher("/admin/updateTeacher.jsp").forward(request, response);
		}

	}

	/**
	 * 评分前的查询学生课程等信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void getStudentCourseDescription(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取该老师
		Teacher teacher = (Teacher) request.getSession().getAttribute("user");
		int tno = teacher.getTno();
		
		TeacherService Service = new TeacherServiceImpl();
		List<StudentCourse> scList = Service.getSelectedStudentAndCourse(tno);

		// 页面跳转
		request.setAttribute("objList", scList);
		request.setAttribute("toPage", "remarkList");
		request.getRequestDispatcher("/PagingServlet").forward(request, response);

	}
	
	/**
	 * 老师对学生所选课程进行评分
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void courseRemark(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int sno = Integer.parseInt(request.getParameter("sno"));
		System.out.println(sno);
		int cno = Integer.parseInt(request.getParameter("cno"));
		int tno = Integer.parseInt(request.getParameter("tno"));
		System.out.println(request.getParameter("score"));
		double score = Double.parseDouble(request.getParameter("score"));
		TeacherService Service = new TeacherServiceImpl();
		int n = Service.courseRemark(sno,cno,tno,score);
		
		request.getRequestDispatcher("/getStudentCourseDescription.do").forward(request, response);

	}
	/**
	 * 查看某老师的任课课程信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void queryAssumeCourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Teacher teacher = (Teacher) request.getSession().getAttribute("user");
		int tno = teacher.getTno();
		TeacherService teacherService = new TeacherServiceImpl();
		List<Course> courseList = teacherService.getAssumeCourse(tno);
		System.out.println(courseList);
		request.setAttribute("objList", courseList);
		request.setAttribute("toPage", "queryAssumeCourse");
		request.getRequestDispatcher("/PagingServlet").forward(request, response);
		
	}

}
