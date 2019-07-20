package com.software.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.software.dao.ticketDao;

import com.software.model.ticket;

/**
 * Servlet implementation class QueryTicketServlet
 */
@WebServlet("/QueryTicketServlet")
public class QueryTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * ��Ʊ��Ϣ����/����������ҳ��ѯ 
	 * ������trainnumber,startstation,endstation
	 * ��Բ��
	 */
	 //ÿҳ��ʾ�ļ�¼����
		private static final int PAGEROWS = 4;

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			execute(request,response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			execute(request,response);
		}
		
		/**
		 * ��Ʊ��Ϣ����/����������ҳ��ѯ 
		 * ������trainnumber,startstation,endstation
		 * ��Բ��
		 */
		private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ticketDao ticketDao = new ticketDao();
			// ��ȡ��ѯ����
			String trainnumber = request.getParameter("trainnumber");
			String startstation = request.getParameter("startstation");
			String endstation = request.getParameter("endstation");
	
			//1.��ȡ��ҳ��
			// 1.1 ��ȡ���������
			int rows =ticketDao.getCountTickets1(trainnumber,startstation,endstation);
			int totalPages = rows / PAGEROWS;
			if(rows % PAGEROWS !=0) {
				totalPages ++;
			}
			//2.��ȡ��ǰҳ
			int currentpage= 1; //Ĭ��ֵ
			
			String getCurrentPage=request.getParameter("setcurrentpage");
			if(getCurrentPage!=null && getCurrentPage.trim().length()>0) {
				currentpage = Integer.parseInt(getCurrentPage);
			}
			
			
			//1.�������ݿ���ʲ��еĲ�ѯ�û���Ϣ�ķ���
			
			List<ticket> tickets =ticketDao.findAllTicket1(trainnumber,startstation,endstation,currentpage,PAGEROWS);
			//2.����ѯ�����û���Ϣ��ʾ���û���Ϣ��ʾҳ��
			//  2.1 ���ݵķ�װ
			request.setAttribute("data", tickets);
			request.setAttribute("totalpage", totalPages);
			request.setAttribute("currentpage", currentpage);
			request.setAttribute("trainnumber", trainnumber);
			request.setAttribute("startstation", startstation);
			request.setAttribute("endstation", endstation);
	
			//  2.2 ҳ�����ת
			request.getRequestDispatcher("che.jsp").forward(request, response);
		}

	}
