package com.software.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.orderDao;
import com.software.model.user;

/**
 * Servlet implementation class QueryOrder1Servlet
 */
@WebServlet("/QueryOrder1Servlet")
public class QueryOrder1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request,response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.调用数据库访问层中的查询用户信息的方法
		/*int userID = 1;
		String orderstate = "已付款";*/
		HttpSession session =request.getSession();
		Object obj = session.getAttribute("userobj");
		if(obj == null) {
			//用户没有登录
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
		else {
		user user=(user)obj;
		int userID =user.getUserID();
		String orderstate = "已付款";
		
		orderDao orderDao = new orderDao();
		List<List> orders =orderDao.findAll1(userID, orderstate);
		//2.将查询到的用户信息显示到用户信息显示页面
		//  2.1 数据的封装
		request.setAttribute("data", orders);
		//  2.2 页面的跳转
		request.getRequestDispatcher("wcx.jsp").forward(request, response);
		}
	}

}
