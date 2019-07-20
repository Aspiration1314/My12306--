package com.software.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class AddFeedbackServlet
 */
@WebServlet("/AddFeedbackServlet")
public class AddFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		Object obj = session.getAttribute("userobj");
		if(obj == null) {
			//�û�û�е�¼
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
		else {
			//����ɶҲ����
			execute(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		Object obj = session.getAttribute("userobj");
		if(obj == null) {
			//�û�û�е�¼
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
		else {
			//����ɶҲ����
			execute(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**��ӷ�����ϢAddFeedbackServlet
	      * @author ��÷ 
	      */
		//1.��ȡ�ͻ����ύ���û�ע����Ϣ
		HttpSession session =request.getSession();
		Object obj =session.getAttribute("userobj");
		feedback feedback = new feedback();
		
		user user=(user)obj;
		int userID =user.getUserID();
		
		request.setCharacterEncoding("UTF-8");
		
		String information = request.getParameter("information");
		
		System.out.println("information" + information);
		
		//�����û�����
				
				feedback.setUserID(userID);
				feedback.setInformation(information);
				feedback.setOperation("δ����");
					
				//2.�������ݿ���ʲ����
				feedbackDao feedbackDao = new feedbackDao();
				//3.�������ݿ���ʲ��е���ӷ���
				try {
					feedbackDao.addfeedback(feedback);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				response.sendRedirect(request.getContextPath() + "/index.jsp");		
			  
	}

}
