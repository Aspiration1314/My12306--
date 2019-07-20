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

import com.software.dao.orderDao;
import com.software.model.user;
import com.software.model.order;
import com.software.model.user;

/**
 * Servlet implementation class /AddOrderServlet
 */
@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		Object obj = session.getAttribute("userobj");
		if(obj == null) {
			//用户没有登录
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
		else {
			//可以啥也不做
			exectue(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		exectue(request, response);
	}
	
	private void exectue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取客户订单产生信息
		int ticketid =Integer.parseInt(request.getParameter("ticketID"));
		String seattype =request.getParameter("seattype");

		//创建订单对象
		order order = new order();
		HttpSession session =request.getSession();
		Object obj =session.getAttribute("userobj");
		user user=(user)obj;
		int userID =user.getUserID();
		
		order.setUserID(userID);
		
		order.setTicketID(ticketid);
		order.setOrderstate("未支付");
		order.setSeattype(seattype);
		
		
		//2.创建数据库访问层对象
		orderDao orderDao = new orderDao();
		//3.调用数据库访问层中的添加方法
		orderDao.addorder(order);
		
		List<Integer> databao = new ArrayList<Integer>();
		databao.add(ticketid);
		databao.add(userID);
		
		/*这里存在一个订单唯一的假设*/
		request.setAttribute("data", databao);
		request.getRequestDispatcher("pay.jsp").forward(request, response);
	/*	
	 PrintWriter out =response.getWriter();
	   out.print(databao); 
	   out.print(databao.get(1));
	   out.flush();
	   out.close();*/
		
	}

}
