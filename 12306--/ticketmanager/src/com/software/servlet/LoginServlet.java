package com.software.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.managerDao;

import com.software.model.manager;


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
		String loginname =request.getParameter("loginname");
		String loginpwd = request.getParameter("loginpwd");
		//2.创建数据库访问层对象
		managerDao managerDao = new managerDao();
		//3.调用数据库访问层中的查询方法
		manager manager =managerDao.findAllManager1(loginname, loginpwd);
		if(manager!=null) {
			//4.用户登录成功后将用户信息存储在Session对象中
			HttpSession session =request.getSession();
			session.setAttribute("managerobj",manager);
			//5.跳转到前端首页界面
			response.sendRedirect(request.getContextPath()+"/shouye.jsp");
		}else {
			//6.重定向到登录页面
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		
	}

}
