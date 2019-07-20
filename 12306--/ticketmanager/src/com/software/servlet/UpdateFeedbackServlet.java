package com.software.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.dao.feedbackDao;
import com.software.dao.ticketDao;
import com.software.model.feedback;
import com.software.model.manager;
import com.software.model.ticket;

/**
 * Servlet implementation class UpdateFeedbackServlet
 */
@WebServlet("/UpdateFeedbackServlet")
public class UpdateFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**修改反馈信息
	 * @author 张圆梦
	 */
	
	 /**
     * Default constructor. 
     */
    //public AddTicketServlet() {
        // TODO Auto-generated constructor stub
    //}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session =request.getSession();
		Object obj = session.getAttribute("managerobj");
		if(obj == null) {
			//用户没有登录
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
		else {
			//可以啥也不做
			execute(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	private <Ticket> void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**添加车票AddTicketServlet
		 * @return 
		 * @author 张圆梦
		 */
		//1.获取车票信息
		HttpSession session =request.getSession();
		Object obj=session.getAttribute("managerobj");
		manager Manager=(manager)obj;
		int managerID=Manager.getManagerID();
				int informationID =Integer.parseInt(request.getParameter("informationID"));
				int userID =Integer.parseInt(request.getParameter("userID"));
		
				String information =request.getParameter("information");
				String operation =request.getParameter("operation");
				String operationresult =request.getParameter("operationresult");
			
				//创建车票对象
				feedback feedback=new feedback();
				feedback.setInformationID(informationID);
				feedback.setUserID(userID);
				feedback.setManagerID(managerID);
				feedback.setInformation(information);
				feedback.setOperation(operation);
				feedback.setOperationresult(operationresult);
				
		// 2.创建数据库访问层对象
				feedbackDao feedbackDao=new feedbackDao();
		//3.调用数据库访问层中的修改方法
				feedbackDao.updateFeedback(feedback);
		//4.跳转到查询页面
		response.sendRedirect(request.getContextPath() + "/QueryFeedbackServlet");
	}

}
