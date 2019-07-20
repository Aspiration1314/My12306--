package com.software.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.orderDao;
import com.software.model.user;

/**
 * Servlet implementation class QueryOrderServlet
 */
@WebServlet("/QueryOrderServlet")
public class QueryOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		// TODO Auto-generated method stub
		execute(request,response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.�������ݿ���ʲ��еĲ�ѯ�û���Ϣ�ķ���
		//int userID = 1;
		//String orderstat = "δ֧��";
		HttpSession session =request.getSession();
		Object obj = session.getAttribute("userobj");
		if(obj == null) {
			//�û�û�е�¼
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			
		}
		else {
		user user=(user)obj;
		int userID =user.getUserID();
		String orderstate = "δ֧��";
		
		orderDao orderDao = new orderDao();
		List<List> orders =orderDao.findAll1(userID, orderstate);
		//2.����ѯ�����û���Ϣ��ʾ���û���Ϣ��ʾҳ��
		//  2.1 ���ݵķ�װ
		request.setAttribute("data", orders);
		//  2.2 ҳ�����ת
		request.getRequestDispatcher("wwc.jsp").forward(request, response);
		}
	}

}
