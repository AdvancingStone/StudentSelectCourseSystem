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

import com.bluehonour.sscs.entity.ClassInfo;
import com.bluehonour.sscs.entity.CriteriaStudent;
import com.bluehonour.sscs.entity.Student;
import com.bluehonour.sscs.service.StudentService;
import com.bluehonour.sscs.service.impl.StudentServiceImpl;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String servletPath = request.getServletPath();
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 3);
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
	
	/**
	 * 添加学生,得到所有班级信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void queryClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentService service = new StudentServiceImpl();
		List<ClassInfo> classList = service.getClassInfo();
		request.setAttribute("classList", classList);
		request.getRequestDispatcher("/admin/addStudent.jsp").forward(request, response);
	}
	
	/**
	 * 添加学生
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取添加管理员的表单数据
		String sname = request.getParameter("name");
		String password = request.getParameter("password");
		long phone = Long.parseLong(request.getParameter("tel"));
		String sex = request.getParameter("sex");
		Date birthday = java.sql.Date.valueOf(request.getParameter("birthday"));
		String classNo = request.getParameter("classno");
		classNo = classNo.substring(2,classNo.length()-3);
		int classno = Integer.parseInt(classNo);
		String remark = request.getParameter("remark");
		
		Student student = new Student(password, sname, phone, sex, birthday, classno, remark);
		//调用业务层进行添加操作
		StudentService studentSerivice = new StudentServiceImpl();
		try {
			int n = studentSerivice.add(student);
			if(n>0) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out =  response.getWriter();
				String result = "<script type=\"text/javascript\">alert('添加成功');location.href='/sscs/admin/addStudent.jsp';</script>";
				out.println(result);
				out.flush();
				out.close();
//				response.sendRedirect(request.getContextPath()+"/frame/right.jsp");
			} else {
				request.setAttribute("error", "学生添加失败");
				request.getRequestDispatcher("/admin/addStudent.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("error", "学生添加失败");
			request.getRequestDispatcher("/admin/addStudent.jsp").forward(request, response);
		}
	}
	
	/**
	 * 查询所有学生信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void queryAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//调用业务层获取所有学生
		StudentService service = new StudentServiceImpl();
		List<Student> stusList = service.findAll();
		
		//跳转到分页Servlet,分页后在跳转到jsp
		request.setAttribute("objList", stusList);
		request.setAttribute("toPage", "queryAllStudent");
		request.getRequestDispatcher("/PagingServlet").forward(request, response);
	}
	
	/**
	 * 模糊查询学生信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void queryCriteriaStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 模糊查询,给条件就查，不给全部查
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String sex = request.getParameter("sex");
		String	sclass = request.getParameter("sclass");
		String remark = request.getParameter("remark");
		
		CriteriaStudent student = new CriteriaStudent(sno,sname,sex,sclass,remark);
		
		//调用业务层获取所有学生
		StudentService service = new StudentServiceImpl();
		List<Student> stusList = service.getForListWithCriteriaStudent(student);
		
		//跳转到分页Servlet,分页后在跳转到jsp
		request.setAttribute("objList", stusList);
		request.setAttribute("toPage", "queryCriteriaStudent");
		request.getRequestDispatcher("/PagingServlet").forward(request, response);
	}
	
	/**
	 * 根据id查询学生
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void queryStudentById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sno = request.getParameter("sno");
		int no = 0;
		try {
			no = Integer.parseInt(sno);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		StudentService service = new StudentServiceImpl();
		
		try {
			Student student = service.findById(no);
			System.out.println(student);
			if(student != null) {
				request.setAttribute("student", student);
				StudentService sservice = new StudentServiceImpl();
				List<ClassInfo> classList = sservice.getClassInfo();
				request.setAttribute("classList", classList);
				request.getRequestDispatcher("/admin/updateStudent.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除某个学生
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void delStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sno = request.getParameter("sno");
		int no = 0;
		try {
			no = Integer.parseInt(sno);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		StudentService service = new StudentServiceImpl();
		
		try {
			int n = service.delete(no);
//			System.out.println(n);
			if(n>0) {
				request.getRequestDispatcher("/queryAllStudent.do").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改学生信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sno = Integer.parseInt(request.getParameter("sno"));
		String sname = request.getParameter("name");
		String password = request.getParameter("password");
		long phone = Long.parseLong(request.getParameter("tel"));
		String tel = request.getParameter("tel");
		
		String sex = request.getParameter("sex");
		Date birthday = java.sql.Date.valueOf(request.getParameter("birthday"));
		String classNo = request.getParameter("classno");
		classNo = classNo.substring(2,classNo.length()-3);
		int classno = Integer.parseInt(classNo);
		String remark = request.getParameter("remark");
		
		Student student = new Student(sno,password, sname, phone, sex, birthday, classno, remark);
		//调用业务层进行添加操作
		StudentService studentSerivice = new StudentServiceImpl();
		try {
			int n = studentSerivice.update(student);
			System.out.println(n);
			if(n>0) {
				request.getRequestDispatcher("/queryAllStudent.do").forward(request, response);
			} 
		} catch (Exception e) {
			request.setAttribute("error", "学生更新失败");
			request.getRequestDispatcher("/admin/updateStudent.jsp").forward(request, response);
		}
		
	}
}
