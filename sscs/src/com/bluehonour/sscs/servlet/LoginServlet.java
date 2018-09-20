package com.bluehonour.sscs.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bluehonour.sscs.entity.Admin;
import com.bluehonour.sscs.entity.Student;
import com.bluehonour.sscs.entity.Teacher;
import com.bluehonour.sscs.service.AdminService;
import com.bluehonour.sscs.service.StudentService;
import com.bluehonour.sscs.service.TeacherService;
import com.bluehonour.sscs.service.impl.AdminServiceImpl;
import com.bluehonour.sscs.service.impl.StudentServiceImpl;
import com.bluehonour.sscs.service.impl.TeacherServiceImpl;

@WebServlet(name = "loginServlet", urlPatterns = { "/loginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 获取ServletPath ： /login.do /logout.do
		String servletPath = request.getServletPath();
		// 2. 去除 / 和 .do ，得到类似于 login 或 logout 这样的字符串
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 3);
		
		try {
			// 3. 利用反射获取methodName 对应的方法
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			// 4. 利用反射调用对应的方法
			method.invoke(this, request, response);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("错误");
			response.sendRedirect("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取来自视图层的数据
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String person = request.getParameter("person");
		
		//回显
		request.setAttribute("userid", userId);
		request.setAttribute("password", password);
		/**
		 * 校验验证码 1. 获取表单上的验证码 2. 获取图片上的文字
		 */
		String verifyCode = request.getParameter("verifyCode");
		System.out.println(verifyCode);
		String vcode = (String) request.getSession().getAttribute("vCode");
		System.out.println(vcode);
		if(userId == null || password == null) {
			request.setAttribute("error", "用户名或密码为空");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		if (!verifyCode.equalsIgnoreCase(vcode)) {
			request.setAttribute("error", "验证码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		if(person == null) {
			request.setAttribute("error", "请选择登录方式");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}

		// 2.调用业务层判断登录是否成功
		if(person.equals("administrator")) {
			AdminService adminService = new AdminServiceImpl();
			Admin admin = adminService.login(userId, password);
			// 3.根据登录是否成功跳转到不同视图层给出用户反馈
			if (admin != null) {
				request.getSession().setAttribute("user", admin);
				request.getSession().setAttribute("person", person);
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			} else {
				request.setAttribute("error", "管理员账号或密码错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} else if(person.equals("student")) {
			StudentService studentService = new StudentServiceImpl();
			Student student = studentService.login(userId,password);
			// 3.根据登录是否成功跳转到不同视图层给出用户反馈
			if (student != null) {
				request.getSession().setAttribute("user", student);
				request.getSession().setAttribute("person", person);
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			} else {
				request.setAttribute("error", "学生账号或密码错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} else if(person.equals("teacher")) {
			try {
				TeacherService teacherService = new TeacherServiceImpl();
				Teacher teacher = teacherService.findById(Integer.parseInt(userId));
				String tPassword = teacher.getPassword();
				if(password.equals(tPassword)) {
					request.getSession().setAttribute("user", teacher);
					request.getSession().setAttribute("person", person);
					response.sendRedirect(request.getContextPath() + "/index.jsp");
				}
			} catch (Exception e) {
				request.setAttribute("error", "教师账号或密码错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} 
		}
	}

	/**
	 * 退出登录
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);// 防止创建session
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		session.removeAttribute("user");
		session.invalidate();// 让session彻底失效
		response.sendRedirect(request.getContextPath() + "/login.jsp");

	}

}
