package com.software.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.userDao;
import com.software.model.user;

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
		//1.��ȡ��¼�û���������
		String loginname =request.getParameter("loginname");
		String loginpwd = request.getParameter("loginpwd");
		//2.�������ݿ���ʲ����
		userDao userDao = new userDao();
		//3.�������ݿ���ʲ��еĲ�ѯ����
		user user =userDao.findAllUser(loginname, loginpwd);
		if(user!=null) {
			//4.�û���¼�ɹ����û���Ϣ�洢��Session������
			HttpSession session =request.getSession();
			session.setAttribute("userobj", user);
			//5.��ת��ǰ����ҳ����
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else {
			//6.�ض��򵽵�¼ҳ��
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		
	}

}
