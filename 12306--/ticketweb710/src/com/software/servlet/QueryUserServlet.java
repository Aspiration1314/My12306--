package com.software.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.userDao;
import com.software.model.user;

/**
 * ��ѯ�û���Ϣ
 */
@WebServlet("/QueryUserServlet")
public class QueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		Object obj = session.getAttribute("userobj");
		if(obj == null) {
			//�û�û�е�¼
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}else {
			execute(request,response);	}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		Object obj = session.getAttribute("userobj");
		
			user user = (user)obj;
			String loginname = user.getLoginname();
			String realname = user.getRealname();
			
			List<List> users = new ArrayList<List>();
			try {
				users = userDao.findAll1(loginname,realname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//2.����ѯ�����û���Ϣ��ʾ���û���Ϣ��ʾҳ��
			//  2.1 ���ݵķ�װ
			request.setAttribute("data", users);
			//  2.2 ҳ�����ת
			request.getRequestDispatcher("displaygerenxinxi.jsp").forward(request, response);
		
		
	}

}
