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
	/**ɾ����ƱDelTicketServlet
	 * @return 
	 * @author ��Բ��
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
	/**ɾ����ƱDelTicketServlet
	 * @return 
	 * @author ��Բ��
	 */
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡҪɾ���ĳ�Ʊ��Ϣ���
		int ticketID = Integer.parseInt(request.getParameter("ticketID"));
		//2.�������ݿ���ʲ����
		ticketDao TicketDao = new ticketDao();
		//3.�������ݿ���ʲ��е�ɾ������
		TicketDao.deletticketByID(ticketID);
		//4.��ת����ѯҳ�棬��ʾɾ����ļ�¼��Ϣ
		//4.1 �ض���
		response.sendRedirect(request.getContextPath()+"/QueryTicketServlet");
		
	}

}
