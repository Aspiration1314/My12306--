package com.software.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 连接数据库操作的工具类
 * @author Administrator
 *
 */
public class DBHelp {

	// 数据库驱动
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	// 数据库连接字符串
	private static final String DBCONN = "jdbc:mysql://localhost:3306/ticketmanager?useUnicode=true&characterEncoding=UTF-8";
	// 用户名
	private static final String USER = "root";
	// 密码
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
	 *  执行单表的增删改查操作
	 * @param sql :执行的sql语句
	 *            eg: insert into tbl_user(loginname,pwd) values ('scott','123');
	 *                update tbl_user set loginname='sys' where id=2;
	 *                delete from tbl_user where id=2;
	 * @return 执行sql语句返回的影响行数
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
			//关闭相关的数据库对象
			closeAll(null,st,connection);
		}
		return count;
	}
	
	/**
	 * 关闭数据库对象
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
