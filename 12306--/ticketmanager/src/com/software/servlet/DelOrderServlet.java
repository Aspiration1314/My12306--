package com.software.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.orderDao;
import com.software.dao.ticketDao;
import com.software.model.order;

/**
 * Servlet implementation class DelOrderServlet
 */
/**����DelOrderServlet
 * @return 
 * @author ��Բ��
 */
@WebServlet("/DelOrderServlet")
public class DelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
	/**����DelOrderServlet
	 * @return 
	 * @author ��Բ��
	 */
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡҪɾ���Ķ�����Ϣ���
		int orderID = Integer.parseInt(request.getParameter("orderID"));
		//2.�������ݿ���ʲ����
		orderDao OrderDao = new orderDao();
		//3.�������ݿ���ʲ��е�ɾ������
		OrderDao.deletordrByID(orderID);
		//4.��ת����ѯҳ�棬��ʾɾ����ļ�¼��Ϣ
		//4.1 �ض���
		response.sendRedirect(request.getContextPath()+"/QueryOrderServlet");
		
	}

}
