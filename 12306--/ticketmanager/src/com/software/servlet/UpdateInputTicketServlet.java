package com.software.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.orderDao;
import com.software.dao.ticketDao;
import com.software.model.feedback;
import com.software.model.ticket;

/**
 * Servlet implementation class UpdateInputTicketServlet
 */
@WebServlet("/UpdateInputTicketServlet")
public class UpdateInputTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**�޸ĳ�Ʊ��Ϣ
	 * @author ��Բ��
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	/**�޸ĳ�Ʊ��Ϣ
	 * @author ��Բ��
	 */
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ�޸ĵ��û����
		int ticketID =Integer.parseInt(request.getParameter("ticketID"));
		//2.�������ݿ���ʲ����
		ticketDao TicketDao = new ticketDao();
		//3.�������ݿ���ʲ��еĲ�ѯ����
		ticket Ticket =TicketDao.findAllTicketByID(ticketID);
		//4.��ת���޸�ҳ��
		request.setAttribute("obj", Ticket);
		request.getRequestDispatcher("updateticket.jsp").forward(request, response);
	}

}
