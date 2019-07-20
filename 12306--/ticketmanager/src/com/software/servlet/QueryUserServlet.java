package com.software.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.orderDao;
import com.software.dao.userDao;

import com.software.model.user;

/**
 * Servlet implementation class QueryUserServlet
 */
@WebServlet("/QueryUserServlet")
public class QueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * �û���Ϣ����/����������ҳ��ѯ 
	 * ������realname
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
		 *�û���Ϣ����/����������ҳ��ѯ 
		 * ������realname
		 * ��Բ��
		 */
		private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			userDao userDao = new userDao();
			// ��ȡ��ѯ����
			String realname = request.getParameter("realname");
	
			//1.��ȡ��ҳ��
			// 1.1 ��ȡ���������
			int rows =userDao.getCountUsers1(realname);
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
			
			userDao UserDao = new userDao();
			List<List> users =UserDao.findAll12(realname,currentpage,PAGEROWS);
			//2.����ѯ�����û���Ϣ��ʾ���û���Ϣ��ʾҳ��
			//  2.1 ���ݵķ�װ
			request.setAttribute("data", users);
			request.setAttribute("totalpage", totalPages);
			request.setAttribute("currentpage", currentpage);
		
			request.setAttribute("realname", realname);
	
			//  2.2 ҳ�����ת
			request.getRequestDispatcher("yong.jsp").forward(request, response);
		}

	}
