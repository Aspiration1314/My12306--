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
			//用户没有登录
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
		else {
			//可以啥也不做
			execute(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		Object obj = session.getAttribute("userobj");
		if(obj == null) {
			//用户没有登录
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
		else {
			//可以啥也不做
			execute(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**添加反馈信息AddFeedbackServlet
	      * @author 张梅 
	      */
		//1.获取客户端提交的用户注册信息
		HttpSession session =request.getSession();
		Object obj =session.getAttribute("userobj");
		feedback feedback = new feedback();
		
		user user=(user)obj;
		int userID =user.getUserID();
		
		request.setCharacterEncoding("UTF-8");
		
		String information = request.getParameter("information");
		
		System.out.println("information" + information);
		
		//创建用户对象
				
				feedback.setUserID(userID);
				feedback.setInformation(information);
				feedback.setOperation("未处理");
					
				//2.创建数据库访问层对象
				feedbackDao feedbackDao = new feedbackDao();
				//3.调用数据库访问层中的添加方法
				try {
					feedbackDao.addfeedback(feedback);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				response.sendRedirect(request.getContextPath() + "/index.jsp");		
			  
	}

}
