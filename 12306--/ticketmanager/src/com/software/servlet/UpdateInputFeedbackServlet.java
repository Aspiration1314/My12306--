package com.software.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.feedbackDao;
import com.software.dao.ticketDao;
import com.software.model.feedback;
import com.software.model.ticket;

/**
 * Servlet implementation class UpdateInputFeedbackServlet
 */
@WebServlet("/UpdateInputFeedbackServlet")
public class UpdateInputFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**修改反馈信息
	 * @author 张圆梦
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	/**修改反馈信息
	 * @author 张圆梦
	 */
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取修改的反馈信息编号
		int informationID =Integer.parseInt(request.getParameter("informationID"));
		//2.创建数据库访问层对象
		feedbackDao FeedbackDao = new feedbackDao();
		//3.调用数据库访问层中的查询方法
		feedback Feedbacks =FeedbackDao.findfeedbackById(informationID);
		//4.跳转到修改页面
		request.setAttribute("obj", Feedbacks);
		request.getRequestDispatcher("updatefeedback.jsp").forward(request, response);
	}

}
