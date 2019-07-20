package com.software.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.feedbackDao;

/**
 * Servlet implementation class DelFeedbackServlet
 */
/**删除反馈信息DelFeedbackServlet
 * @return 
 * @author 张圆梦
 */
@WebServlet("/DelFeedbackServlet")
public class DelFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	/**删除反馈信息DelFeedbackServlet
	 * @return 
	 * @author 张圆梦
	 */
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取要删除的反馈信息编号
		int informationID = Integer.parseInt(request.getParameter("informationID"));
		//2.创建数据库访问层对象
		feedbackDao FeedbackDao = new feedbackDao();
		//3.调用数据库访问层中的删除方法
		FeedbackDao.deletinformationByID(informationID);
		//4.跳转到查询页面，显示删除后的记录信息
		//4.1 重定向
		response.sendRedirect(request.getContextPath()+"/QueryFeedbackServlet");
		
	}

}
