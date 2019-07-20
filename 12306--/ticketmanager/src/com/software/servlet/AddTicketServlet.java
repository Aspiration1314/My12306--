package com.software.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.ticketDao;
import com.software.model.manager;
import com.software.model.ticket;
/**
 * Servlet implementation class AddTicketServlet
 * @param <Ticket>
 * @param <Ticket>
 */
/**添加车票AddTicketServlet
 * @return 
 * @author 张圆梦
 */
@WebServlet("/AddTicketServlet")
public class AddTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    //public AddTicketServlet() {
        // TODO Auto-generated constructor stub
    //}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session =request.getSession();
		Object obj = session.getAttribute("managerobj");
		if(obj == null) {
			//用户没有登录
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
		else {
			//可以啥也不做
			execute(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	private <Ticket> void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**添加车票AddTicketServlet
		 * @return 
		 * @author 张圆梦
		 */
		//1.获取车票信息
		HttpSession session =request.getSession();
		Object obj=session.getAttribute("managerobj");
		manager Manager=(manager)obj;
		int managerID=Manager.getManagerID();

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
		double softsleeperprice =Integer.parseInt(request.getParameter("softsleeperprice"));
		double hardsleeperprice =Integer.parseInt(request.getParameter("hardsleeperprice"));
		double hardseatprice =Integer.parseInt(request.getParameter("hardseatprice"));
		double noseatprice =Integer.parseInt(request.getParameter("noseatprice"));
	
		//创建车票对象
		ticket ticket=new ticket();
	
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
		
		
		
		
		//创建数据库层访问对象
		ticketDao ticketDao=new ticketDao();
		//调用数据库访问层中的添加
		ticketDao.addticket(ticket);
	
		
		
      response.sendRedirect(request.getContextPath() + "/succeed.jsp");
		
	}
}
