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
		//1.��ȡ�޸ĵ��û����
		int ticketID =Integer.parseInt(request.getParameter("ticketID"));
		//2.�������ݿ���ʲ����
		ticketDao ticketDao = new ticketDao();
		//3.�������ݿ���ʲ��еĲ�ѯ����
		ticket ticket =ticketDao.findticketById(ticketID);
		
		//4.��ת���޸�ҳ��
		request.setAttribute("obj", ticket);
		request.getRequestDispatcher("goupiao.jsp").forward(request, response);
	}

}
