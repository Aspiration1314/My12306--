package com.software.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.ticketDao;
import com.software.model.ticket;

/**
 * Servlet implementation class UpdateTicketServlet
 */
@WebServlet("/UpdateTicketServlet")
public class UpdateTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**�޸ĳ�Ʊ��Ϣ
	 * @author ��Բ��
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
	/**�޸ĳ�Ʊ��Ϣ
	 * @author ��Բ��
	 */
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.��ȡ�û��޸ĵ���Ϣ(��ȡform���е�Ԫ��ֵ)

		//1.��ȡ��Ʊ��Ϣ
		        int ticketID =Integer.parseInt(request.getParameter("ticketID"));
				int managerID =Integer.parseInt(request.getParameter("managerID"));
				String trainnumber =request.getParameter("trainnumber");
				String startstation =request.getParameter("startstation");
				String endstation =request.getParameter("endstation");
				String starttime =request.getParameter("starttime");
				String endtime =request.getParameter("endtime");
				String duration =request.getParameter("duration");
				int softsleepernumber =Integer.parseInt(request.getParameter("softsleepernumber"));
				int hardsleepernumber =Integer.parseInt(request.getParameter("hardsleepernumber"));
				int hardseatnumber =Integer.parseInt(request.getParameter("hardseatnumber"));
				int noseatnumber = Integer.parseInt(request.getParameter("noseatnumber"));
				double softsleeperprice =Double.parseDouble(request.getParameter("softsleeperprice"));
				double hardsleeperprice =Double.parseDouble(request.getParameter("hardsleeperprice"));
				double hardseatprice =Double.parseDouble(request.getParameter("hardseatprice"));
				double noseatprice =Double.parseDouble(request.getParameter("noseatprice"));
			
				//������Ʊ����
				ticket ticket=new ticket();
				ticket.setTicketID(ticketID);
				ticket.setManagerID(managerID);
				ticket.setTrainnumber(trainnumber);
				ticket.setStartstation(startstation);
				ticket.setEndstation(endstation);
				ticket.setStarttime(starttime);
				ticket.setEndtime(endtime);
				ticket.setDuration(duration);
				ticket.setSoftsleepernumber(softsleepernumber);
				ticket.setHardsleepernumber(hardsleepernumber);
				ticket.setHardseatnumber(hardseatnumber);
				ticket.setNoseatnumber(noseatnumber);
				ticket.setSoftsleeperprice(softsleeperprice);
				ticket.setHardsleeperprice(hardsleeperprice);
				ticket.setHardseatprice(hardseatprice);
				ticket.setNoseatprice(noseatprice);
		// 2.�������ݿ���ʲ����
				ticketDao ticketDao=new ticketDao();
		//3.�������ݿ���ʲ��е��޸ķ���
		ticketDao.updateticket(ticket);
		//4.��ת����ѯҳ��
		response.sendRedirect(request.getContextPath() + "/QueryTicketServlet");
	}

}
