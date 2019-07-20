package com.software.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.feedbackDao;
import com.software.model.feedback;
import com.software.model.user;

/**
 * Servlet implementation class QueryFeedbackServlet
 */
@WebServlet("/QueryFeedbackServlet")
public class QueryFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
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
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		HttpSession session =request.getSession();
		Object obj =session.getAttribute("userobj");
		user user=(user)obj;
		int userID =user.getUserID();
		
		//1.�������ݿ���ʲ��еĲ�ѯ�û���Ϣ�ķ���
		feedbackDao feedbackDao = new feedbackDao();
		List result =feedbackDao.findAt(userID);
		//2.����ѯ�����û���Ϣ��ʾ���û���Ϣ��ʾҳ��
		//  2.1 ���ݵķ�װ
		request.setAttribute("data", result);
		//  2.2 ҳ�����ת
		request.getRequestDispatcher("customerservice.jsp").forward(request, response);
	}

}


