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
import com.software.model.order;

/**
 * Servlet implementation class QueryOrderServlet
 */
@WebServlet("/QueryOrderServlet")
public class QueryOrderServlet extends HttpServlet {
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
			orderDao orderDao = new orderDao();
			// ��ȡ��ѯ����
			String realname = request.getParameter("realname");
			String orderstate = request.getParameter("orderstate");
	
			//1.��ȡ��ҳ��
			// 1.1 ��ȡ���������
			int rows =orderDao.getCountOrders1(realname,orderstate);
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
			
		    orderDao OrderDao = new orderDao();
			List<List> orders =OrderDao.findAll12(realname,orderstate,currentpage,PAGEROWS);
			//2.����ѯ�����û���Ϣ��ʾ���û���Ϣ��ʾҳ��
			//  2.1 ���ݵķ�װ
			request.setAttribute("data", orders);
			request.setAttribute("totalpage", totalPages);
			request.setAttribute("currentpage", currentpage);
			request.setAttribute("realname", realname);
			request.setAttribute("orderstate", orderstate);
	
			//  2.2 ҳ�����ת
			request.getRequestDispatcher("dd.jsp").forward(request, response);
		}

	}
