package com.software.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.ticketDao;
import com.software.model.ticket;

/**
 * Servlet implementation class QueryTicketServlet
 */
@WebServlet("/QueryTicketServlet")
public class QueryTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 //每页显示的记录总数
		private static final int PAGEROWS = 4;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}
	/*
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.调用数据库访问层中的查询车票信息的方法
		//String startstation = "shanghai";
		//String endstation = "beijing";
		String startstation = request.getParameter("startstation");
		String endstation = request.getParameter("endstation");
		ticketDao ticketDao = new ticketDao();
		List<ticket> tickets =ticketDao.findAll1(startstation,endstation);
		//2.将查询到的用户信息显示到用户信息显示页面
		//  2.1 数据的封装
		request.setAttribute("data", tickets);
		//  2.2 页面的跳转
		request.getRequestDispatcher("displaychepiao.jsp").forward(request, response);
	}*/
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.获取总页数
				// 1.1 获取表的总行数
				ticketDao ticketDao = new ticketDao();
				String startstation = request.getParameter("startstation");
				String endstation = request.getParameter("endstation");
				int rows =ticketDao.getCounttickets(startstation,endstation);
				int totalPages = rows / PAGEROWS;
				if(rows % PAGEROWS !=0) {
					totalPages ++;
				}
				//2.获取当前页
				int currentpage= 1; //默认值
				
				String getCurrentPage=request.getParameter("setcurrentpage");
				if(getCurrentPage!=null && getCurrentPage.trim().length()>0) {
					currentpage = Integer.parseInt(getCurrentPage);
				}
		
		//1.调用数据库访问层中的查询车票信息的方法
		//String startstation = "shanghai";
		//String endstation = "beijing";
		
		
		List<ticket> tickets =ticketDao.findAll(startstation,endstation,currentpage,PAGEROWS);
		//2.将查询到的用户信息显示到用户信息显示页面
		//  2.1 数据的封装
		request.setAttribute("data", tickets);
		request.setAttribute("totalpage", totalPages);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("startstation", startstation);
		request.setAttribute("endstation", endstation);
		//  2.2 页面的跳转
		request.getRequestDispatcher("displaychepiao.jsp").forward(request, response);
	}

}
