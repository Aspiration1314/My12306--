package com.software.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.orderDao;
import com.software.dao.userDao;

/**
 * Servlet implementation class DelUserServlet
 */
@WebServlet("/DelUserServlet")
public class DelUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**删除用户信息DelUserServlet
	 * @return 
	 * @author 张圆梦
	 */     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	/**删除用户信息DelUserServlet
	 * @return 
	 * @author 张圆梦
	 */   	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取要删除的用户信息编号
		int userID = Integer.parseInt(request.getParameter("userID"));
		//2.创建数据库访问层对象
		userDao UserDao = new userDao();
		//3.调用数据库访问层中的删除方法
		UserDao.deletuserByID(userID);
		//4.跳转到查询页面，显示删除后的记录信息
		//4.1 重定向
		response.sendRedirect(request.getContextPath()+"/QueryUserServlet");
		
	}



}
