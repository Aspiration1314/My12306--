package com.software.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.dao.orderDao;
import com.software.dao.userDao;

import com.software.model.user;

/**
 * Servlet implementation class QueryUserServlet
 */
@WebServlet("/QueryUserServlet")
public class QueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 用户信息（总/按条件）分页查询 
	 * 条件：realname
	 * 张圆梦
	 */
	 //每页显示的记录总数
		private static final int PAGEROWS = 4;

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			execute(request,response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			execute(request,response);
		}
		
		/**
		 *用户信息（总/按条件）分页查询 
		 * 条件：realname
		 * 张圆梦
		 */
		private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			userDao userDao = new userDao();
			// 获取查询条件
			String realname = request.getParameter("realname");
	
			//1.获取总页数
			// 1.1 获取表的总行数
			int rows =userDao.getCountUsers1(realname);
			int totalPages = rows / PAGEROWS;
			if(rows % PAGEROWS !=0) {
				totalPages ++;
			}
			//2.获取当前页
			int currentpage= 1; //默认值
			
			String getCurrentPage=request.getParameter("setcurrentpage");
			if(getCurrentPage!=null && getCurrentPage.trim().length()>0) {
				currentpage = Integer.parseInt(getCurrentPage);
			}
			
			
			//1.调用数据库访问层中的查询用户信息的方法
			
			userDao UserDao = new userDao();
			List<List> users =UserDao.findAll12(realname,currentpage,PAGEROWS);
			//2.将查询到的用户信息显示到用户信息显示页面
			//  2.1 数据的封装
			request.setAttribute("data", users);
			request.setAttribute("totalpage", totalPages);
			request.setAttribute("currentpage", currentpage);
		
			request.setAttribute("realname", realname);
	
			//  2.2 页面的跳转
			request.getRequestDispatcher("yong.jsp").forward(request, response);
		}

	}
