package com.software.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.feedbackDao;

/**
 * Servlet implementation class DelFeedbackServlet
 */
/**ɾ��������ϢDelFeedbackServlet
 * @return 
 * @author ��Բ��
 */
@WebServlet("/DelFeedbackServlet")
public class DelFeedbackServlet extends HttpServlet {
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
	/**ɾ��������ϢDelFeedbackServlet
	 * @return 
	 * @author ��Բ��
	 */
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡҪɾ���ķ�����Ϣ���
		int informationID = Integer.parseInt(request.getParameter("informationID"));
		//2.�������ݿ���ʲ����
		feedbackDao FeedbackDao = new feedbackDao();
		//3.�������ݿ���ʲ��е�ɾ������
		FeedbackDao.deletinformationByID(informationID);
		//4.��ת����ѯҳ�棬��ʾɾ����ļ�¼��Ϣ
		//4.1 �ض���
		response.sendRedirect(request.getContextPath()+"/QueryFeedbackServlet");
		
	}

}
