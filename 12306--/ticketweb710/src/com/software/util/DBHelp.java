package com.software.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * �������ݿ�����Ĺ�����
 * @author Administrator
 *
 */
public class DBHelp {

	// ���ݿ�����
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	// ���ݿ������ַ���
	private static final String DBCONN = "jdbc:mysql://localhost:3306/ticketmanager?useUnicode=true&characterEncoding=UTF-8";
	// �û���
	private static final String USER = "root";
	// ����
	private static final String PWD = "root";
	
	/**
	 *   get the connection 
	 * @return
	 */
	public static Connection getConnect() {
		Connection connection = null;
		try {
			Class.forName(DBDRIVER);
			connection = DriverManager.getConnection(DBCONN, USER, PWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	/**
	 *  ִ�е������ɾ�Ĳ����
	 * @param sql :ִ�е�sql���
	 *            eg: insert into tbl_user(loginname,pwd) values ('scott','123');
	 *                update tbl_user set loginname='sys' where id=2;
	 *                delete from tbl_user where id=2;
	 * @return ִ��sql��䷵�ص�Ӱ������
	 */
	public static int executeSql(String sql) {
		int count = 0;
		Connection connection = getConnect();
		Statement st = null;
		try {
			st = connection.createStatement();
			count=st.executeUpdate(sql);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//�ر���ص����ݿ����
			closeAll(null,st,connection);
		}
		return count;
	}
	
	/**
	 * �ر����ݿ����
	 */
	public static void closeAll(ResultSet rs,Statement st,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
