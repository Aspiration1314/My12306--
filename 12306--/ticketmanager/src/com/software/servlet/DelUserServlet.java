package com.software.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.orderDao;
import com.software.dao.userDao;

/**
 * Servlet implementation class DelUserServlet
 */
@WebServlet("/DelUserServlet")
public class DelUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**ɾ���û���ϢDelUserServlet
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
	/**ɾ���û���ϢDelUserServlet
	 * @return 
	 * @author ��Բ��
	 */   	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡҪɾ�����û���Ϣ���
		int userID = Integer.parseInt(request.getParameter("userID"));
		//2.�������ݿ���ʲ����
		userDao UserDao = new userDao();
		//3.�������ݿ���ʲ��е�ɾ������
		UserDao.deletuserByID(userID);
		//4.��ת����ѯҳ�棬��ʾɾ����ļ�¼��Ϣ
		//4.1 �ض���
		response.sendRedirect(request.getContextPath()+"/QueryUserServlet");
		
	}



}
