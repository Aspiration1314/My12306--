package com.software.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.orderDao;
import com.software.model.order;
import com.software.model.user;

/**
 * Servlet implementation class GaiQianServlet
 */
@WebServlet("/GaiQianServlet")
public class GaiQianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取客户订单产生信息
		int orderid =Integer.parseInt(request.getParameter("orderID"));
		int ticketid =Integer.parseInt(request.getParameter("ticketID"));
		String seattype =request.getParameter("seattype");

		//创建订单对象
		order order = new order();
		HttpSession session =request.getSession();
		Object obj =session.getAttribute("userobj");
		user user=(user)obj;
		int userID =user.getUserID();
		
		order.setUserID(userID);
		
		//2.创建数据库访问层对象
		orderDao orderDao = new orderDao();
		//3.调用数据库访问层中的添加方法
		orderDao.gaiqian(orderid, ticketid, seattype);
		
		List<List> orders =orderDao.findAll1(userID, "已付款");
		//2.将查询到的用户信息显示到用户信息显示页面
		//  2.1 数据的封装
		request.setAttribute("data", orders);
		
		response.sendRedirect(request.getContextPath() + "/QueryOrder1Servlet");
	/*	
	 PrintWriter out =response.getWriter();
	   out.print(databao); 
	   out.print(databao.get(1));
	   out.flush();
	   out.close();*/
		
	}

}
