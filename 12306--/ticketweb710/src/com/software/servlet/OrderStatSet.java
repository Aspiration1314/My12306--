package com.software.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.orderDao;
import com.software.model.order;

/**
 * Servlet implementation class OrderStatSet
 */
@WebServlet("/OrderStatSet")
public class OrderStatSet extends HttpServlet {
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
		//1.��ȡ��¼�û���������
		
		int ticketid =Integer.parseInt(request.getParameter("ticketID"));
		int userid =Integer.parseInt(request.getParameter("userID"));
		
		//2.�������ݿ���ʲ����
		orderDao orderDao = new orderDao();
		//3.�������ݿ���ʲ��еĲ�ѯ����
		orderDao.updateorder1(ticketid, userid);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
