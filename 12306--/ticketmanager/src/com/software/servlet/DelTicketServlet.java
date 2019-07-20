package com.software.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.feedbackDao;
import com.software.dao.ticketDao;

/**
 * Servlet implementation class DelTicketServlet
 */
@WebServlet("/DelTicketServlet")
public class DelTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**删除车票DelTicketServlet
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
	/**删除车票DelTicketServlet
	 * @return 
	 * @author 张圆梦
	 */
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取要删除的车票信息编号
		int ticketID = Integer.parseInt(request.getParameter("ticketID"));
		//2.创建数据库访问层对象
		ticketDao TicketDao = new ticketDao();
		//3.调用数据库访问层中的删除方法
		TicketDao.deletticketByID(ticketID);
		//4.跳转到查询页面，显示删除后的记录信息
		//4.1 重定向
		response.sendRedirect(request.getContextPath()+"/QueryTicketServlet");
		
	}

}
