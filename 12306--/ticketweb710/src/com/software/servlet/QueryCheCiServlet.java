package com.software.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.orderDao;
import com.software.dao.ticketDao;
import com.software.model.ticket;

/**
 * Servlet implementation class QueryCheCiServlet
 */
@WebServlet("/QueryCheCiServlet")
public class QueryCheCiServlet extends HttpServlet {
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
		
//		request.setAttribute("start", station.get(0));
//		request.setAttribute("end", station.get(1));
		
		int orderid = Integer.parseInt(request.getAttribute("ordernm").toString());
		
		String st = request.getAttribute("start").toString();
		String en = request.getAttribute("end").toString();
		
		
		ticketDao ticketDao = new ticketDao();
		
		List<ticket> tickets =ticketDao.findAll1(st, en);
		
		request.setAttribute("data", tickets);
		request.setAttribute("orderID", orderid);
		//  2.2 页面的跳转
		request.getRequestDispatcher("gaiqian.jsp").forward(request, response);
		
		//String end =request.getParameter("");
		
//		response.setCharacterEncoding("utf-8");
//		 PrintWriter out =response.getWriter();
//		   out.print(tickets.get(0)); 
//		   out.print(tickets.get(1));
//		  out.print(orderid);
//		   out.flush();
//		   out.close();
		
	}

}
