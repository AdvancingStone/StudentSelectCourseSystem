package com.bluehonour.sscs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluehonour.sscs.entity.Admin;
import com.bluehonour.sscs.service.AdminService;
import com.bluehonour.sscs.service.impl.AdminServiceImpl;


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
	 * 添加管理员
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void addAdmin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取添加管理员的表单数据
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("passWord");
		String rePassword = request.getParameter("rePassWord");
		int age = Integer.parseInt(request.getParameter("age"));
		double score = Double.parseDouble(request.getParameter("score"));
		Date enterDate = java.sql.Date.valueOf(request.getParameter("enterDate"));
		String introduction = request.getParameter("introduction");
		
		Admin admin = new Admin(userId, userName, password, age, score, enterDate, introduction);
		
		//调用业务层进行添加操作
		AdminService adminService = new AdminServiceImpl();
		try {
			int n = adminService.add(admin);
			if(n>0) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out =  response.getWriter();
				String result = "<script type=\"text/javascript\">alert('添加成功');location.href='/sscs/admin/addAdmin.jsp';</script>";
				out.println(result);
				out.flush();
				out.close();
//				response.sendRedirect(request.getContextPath()+"/frame/right.jsp");
			} else {
				request.setAttribute("error", "管理员添加失败");
				request.getRequestDispatcher("/admin/addAdmin.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("error", "管理员添加失败");
			request.getRequestDispatcher("/admin/addAdmin.jsp").forward(request, response);
		}
		
	}
	
	/**
	 * 修改管理员信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void updateAdmin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}
	
	
}