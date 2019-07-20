package com.software.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.software.model.manager;
import com.software.model.ticket;
import com.software.util.DBHelp;

public class managerDao {
	/**
	 *  实现添加管理员操作
	 * @param manager :添加的管理员对象
	 * @return true:添加成功 false:添加失败
	 * @author 张圆梦
	 */
	public boolean addManager(manager manager) {
		boolean flag = false;
		
			String sql = "insert into manager(loginname,loginpwd) "
					+ "values ('"+manager.getLoginname()+"','"+manager.getLoginpwd()+"')";
			
			int count =DBHelp.executeSql(sql);
			if (count >0) {
				flag =true;
			}
			return flag;
		}
		

	/*
	 * 查找管理员
	 * @author 张圆梦
	 */
	public static void findAllmanager() throws Exception  {
		String sql = "select managerID,loginname,loginpwd from manager";
		Connection conn = DBHelp.getConnect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			int managerID = rs.getInt("managerID");
			String loginname= rs.getString("loginname");
			String loginpwd = rs.getString("loginpwd");
		
			System.out.println(managerID + "," + loginname + "," + loginpwd);
		}
		  DBHelp.closeAll(rs, st, conn);
	}
	
	/**
	 * 查询所有用户信息
	 * 实现单表操作
	 */
	public  List<manager> findAllManager(String loginname,String loginpwd)  {
		List<manager> managers = new ArrayList<manager>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select managerID,loginname,loginpwd from manager";
			 
			rs =st.executeQuery(sql);
			manager manager =null;
			while(rs.next()) {
				//创建用户对象
				manager = new manager();
				manager.setManagerID(rs.getInt("managerID"));				
				manager.setLoginname(rs.getString("loginname"));
				manager.setLoginpwd(rs.getString("loginpwd"));
			
				managers.add(manager);
			}
			// 5.关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return managers;
		
	}
	/** 
	 * 登录验证
	 * @param loginname
	 * @param loginpwd
	 * 张圆梦
	 * @return
	 */
	public  manager findAllManager1(String loginname,String loginpwd)  {
		manager manager = null;		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select managerID,loginname,loginpwd from manager"
					+ " where loginname='" + loginname 
					+"' and loginpwd='" + loginpwd +"'";



			
			 
			rs =st.executeQuery(sql);
			
			if(rs.next()) {	
				manager =new manager();
				manager.setManagerID(rs.getInt("managerID"));				
				manager.setLoginname(rs.getString("loginname"));
				manager.setLoginpwd(rs.getString("loginpwd"));
				
			}
			// 5.关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return manager;
		
	}

		
   }
	




