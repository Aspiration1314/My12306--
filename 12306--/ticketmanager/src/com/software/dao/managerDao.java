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
	 *  ʵ����ӹ���Ա����
	 * @param manager :��ӵĹ���Ա����
	 * @return true:��ӳɹ� false:���ʧ��
	 * @author ��Բ��
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
	 * ���ҹ���Ա
	 * @author ��Բ��
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
	 * ��ѯ�����û���Ϣ
	 * ʵ�ֵ������
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
				//�����û�����
				manager = new manager();
				manager.setManagerID(rs.getInt("managerID"));				
				manager.setLoginname(rs.getString("loginname"));
				manager.setLoginpwd(rs.getString("loginpwd"));
			
				managers.add(manager);
			}
			// 5.�ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return managers;
		
	}
	/** 
	 * ��¼��֤
	 * @param loginname
	 * @param loginpwd
	 * ��Բ��
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
			// 5.�ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return manager;
		
	}

		
   }
	




