package com.software.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.feedbackDao;
import com.software.dao.ticketDao;
import com.software.model.feedback;
import com.software.model.ticket;

/**
 * Servlet implementation class UpdateInputFeedbackServlet
 */
@WebServlet("/UpdateInputFeedbackServlet")
public class UpdateInputFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**�޸ķ�����Ϣ
	 * @author ��Բ��
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	/**�޸ķ�����Ϣ
	 * @author ��Բ��
	 */
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ�޸ĵķ�����Ϣ���
		int informationID =Integer.parseInt(request.getParameter("informationID"));
		//2.�������ݿ���ʲ����
		feedbackDao FeedbackDao = new feedbackDao();
		//3.�������ݿ���ʲ��еĲ�ѯ����
		feedback Feedbacks =FeedbackDao.findfeedbackById(informationID);
		//4.��ת���޸�ҳ��
		request.setAttribute("obj", Feedbacks);
		request.getRequestDispatcher("updatefeedback.jsp").forward(request, response);
	}

}
