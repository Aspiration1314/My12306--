package com.software.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.orderDao;
import com.software.dao.ticketDao;
import com.software.model.ticket;

/**
 * Servlet implementation class OrderInputServlet
 */
@WebServlet("/OrderInputServlet")
public class OrderInputServlet extends HttpServlet {
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
		//1.获取修改的用户编号
		int ticketID =Integer.parseInt(request.getParameter("ticketID"));
		//2.创建数据库访问层对象
		ticketDao ticketDao = new ticketDao();
		//3.调用数据库访问层中的查询方法
		ticket ticket =ticketDao.findticketById(ticketID);
		
		//4.跳转到修改页面
		request.setAttribute("obj", ticket);
		request.getRequestDispatcher("goupiao.jsp").forward(request, response);
	}

}
