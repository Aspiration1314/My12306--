package com.software.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.orderDao;

/**
 * Servlet implementation class DelUserServlet
 */
@WebServlet("/CancelTicketServlet")
public class CancelTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
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
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取要删除的用户编号
		int orderID = Integer.parseInt(request.getParameter("orderID"));
		//2.创建数据库访问层对象
		orderDao orderDao = new orderDao();
		//3.调用数据库访问层中的删除方法
		try {
			orderDao.delorder(orderID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4.跳转到查询页面，显示删除后的记录信息
		//4.1 重定向
		response.sendRedirect(request.getContextPath()+"/QueryOrderServlet");
		
	}

}
