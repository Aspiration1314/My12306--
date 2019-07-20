package com.software.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.managerDao;

import com.software.model.manager;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginname =request.getParameter("loginname");
		String loginpwd = request.getParameter("loginpwd");
		//2.�������ݿ���ʲ����
		managerDao managerDao = new managerDao();
		//3.�������ݿ���ʲ��еĲ�ѯ����
		manager manager =managerDao.findAllManager1(loginname, loginpwd);
		if(manager!=null) {
			//4.�û���¼�ɹ����û���Ϣ�洢��Session������
			HttpSession session =request.getSession();
			session.setAttribute("managerobj",manager);
			//5.��ת��ǰ����ҳ����
			response.sendRedirect(request.getContextPath()+"/shouye.jsp");
		}else {
			//6.�ض��򵽵�¼ҳ��
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		
	}

}
