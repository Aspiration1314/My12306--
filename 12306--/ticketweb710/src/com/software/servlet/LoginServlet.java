package com.software.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.userDao;
import com.software.model.user;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取登录用户名和密码
		String loginname =request.getParameter("loginname");
		String loginpwd = request.getParameter("loginpwd");
		//2.创建数据库访问层对象
		userDao userDao = new userDao();
		//3.调用数据库访问层中的查询方法
		user user =userDao.findAllUser(loginname, loginpwd);
		if(user!=null) {
			//4.用户登录成功后将用户信息存储在Session对象中
			HttpSession session =request.getSession();
			session.setAttribute("userobj", user);
			//5.跳转到前端首页界面
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else {
			//6.重定向到登录页面
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		
	}

}
