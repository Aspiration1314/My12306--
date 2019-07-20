package com.software.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.feedbackDao;

import com.software.model.feedback;

/**
 * Servlet implementation class QueryFeedbackServlet
 */
@WebServlet("/QueryFeedbackServlet")
public class QueryFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * ������Ϣ����/����������ҳ��ѯ 
	 * ����������״̬operation
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
		 * ������Ϣ����/����������ҳ��ѯ 
		 * ����������״̬operation
		 * ��Բ��
		 */
		private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			feedbackDao feedbackDao = new feedbackDao();
			// ��ȡ��ѯ����
			String operation = request.getParameter("operation");
	
			//1.��ȡ��ҳ��
			// 1.1 ��ȡ���������
			int rows =feedbackDao.getCountFeedbacks1(operation);
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
			
			List<feedback> feedbacks =feedbackDao.findAllFeedback1(operation,currentpage,PAGEROWS);
			//2.����ѯ�����û���Ϣ��ʾ���û���Ϣ��ʾҳ��
			//  2.1 ���ݵķ�װ
			request.setAttribute("data", feedbacks);
			request.setAttribute("totalpage", totalPages);
			request.setAttribute("currentpage", currentpage);
			request.setAttribute("operation", operation);
	
			//  2.2 ҳ�����ת
			request.getRequestDispatcher("feedback.jsp").forward(request, response);
		}

	}
