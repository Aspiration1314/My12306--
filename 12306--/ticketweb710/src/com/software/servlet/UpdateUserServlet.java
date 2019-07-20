package com.software.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.userDao;
import com.software.model.user;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.��ȡ�û��޸ĵ���Ϣ(��ȡform���е�Ԫ��ֵ)
		// 1.��ȡ�ͻ����ύ���û�ע����Ϣ
		int userID = Integer.parseInt(request.getParameter("userID"));
		String loginname = request.getParameter("loginname");
		String loginpwd = request.getParameter("loginpwd");
		String realname = request.getParameter("realname");
		String gender = request.getParameter("gender");
		String telnumber = request.getParameter("telnumber");
		String cardtype = request.getParameter("cardtype");
		String cardno = request.getParameter("cardno");
		int usertype = Integer.parseInt(request.getParameter("usertype"));

		// �����û�����
		user user = new user();
		user.setUserID(userID);
		user.setLoginname(loginname);
		user.setLoginpwd(loginpwd);
		user.setRealname(realname);
		user.setGender(gender);
		user.setTelnumber(telnumber);
		user.setCardtype(cardtype);
		user.setCardno(cardno);
		user.setUsertype(usertype);
		

		// 2.�������ݿ���ʲ����
		userDao userDao = new userDao();
		//3.�������ݿ���ʲ��е��޸ķ���
		userDao.updateUser(user);
		//4.��ת����ѯҳ��
		response.sendRedirect(request.getContextPath() + "/QueryUserServlet");
	}

}
