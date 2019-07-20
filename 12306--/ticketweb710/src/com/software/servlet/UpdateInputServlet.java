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
 * Servlet implementation class UpdateInputServlet
 */
@WebServlet("/UpdateInputServlet")
public class UpdateInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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

	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取修改的用户编号
		int userId =Integer.parseInt(request.getParameter("userID"));
		//2.创建数据库访问层对象
		userDao userDao = new userDao();
		//3.调用数据库访问层中的查询方法
		user user =userDao.findUserById(userId);
		
		//4.跳转到修改页面
		request.setAttribute("obj", user);
		request.getRequestDispatcher("gerenxinxixiugai.jsp").forward(request, response);
	}

}
