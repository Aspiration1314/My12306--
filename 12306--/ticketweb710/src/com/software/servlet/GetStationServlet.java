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
import javax.servlet.http.HttpSession;

import com.software.dao.orderDao;
import com.software.model.order;
import com.software.model.user;

/**
 * Servlet implementation class GetStationServlet
 */
@WebServlet("/GetStationServlet")
public class GetStationServlet extends HttpServlet {
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
		//1.��ȡ�ͻ�����������Ϣ
		int orderbh =Integer.parseInt(request.getParameter("orderID"));

		//2.�������ݿ���ʲ����
		orderDao orderDao = new orderDao();
		//3.�������ݿ���ʲ��е���ӷ���
		
		List station = new ArrayList();
		
		station = orderDao.findStation(orderbh);
		
		/*�������һ������Ψһ�ļ���*/
		request.setAttribute("start", station.get(0));
		request.setAttribute("end", station.get(1));
		request.setAttribute("ordernm", orderbh);
		
		
		
		request.getRequestDispatcher("/QueryCheCiServlet").forward(request, response);
	
		//response.setCharacterEncoding("utf-8");
//	   PrintWriter out =response.getWriter();
//	   out.print(station.get(0)); 
//	   out.print(station.get(1));
//	   out.print(orderid);
//	   out.flush();
//	   out.close();
//		
	}

}
