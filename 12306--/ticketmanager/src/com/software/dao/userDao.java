package com.software.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.software.model.ticket;
import com.software.model.user;
import com.software.util.DBHelp;


public class userDao {
	
	/**按照用户真实姓名查询用户信息(分页查询)
	 * @param realname 
	 * @return 
	 * @author 张圆梦
	 */
	
//	findAll12
	public   List<List> findAll12(String realname, int currentPage,int pageSize)  {
		List<List> buffer = new ArrayList<List>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select userID,loginname,loginpwd,realname,gender,telnumber,cardtype,cardno,"
			+ "usertypename from usertype t,user u"
			+ " where t.usertypeid = u.usertype ";
			if(realname !=null && realname.trim().length()>0) {
				sql = sql + " and realname ='"+realname+"'";
				
			}
			
			sql = sql + "and u.remarks1 = '1'";
			
			sql = sql + " limit " + (currentPage-1)*pageSize + "," + pageSize;
			rs =st.executeQuery(sql);
			List data = null;
			while(rs.next()) {
				data = new ArrayList();	
				data.add(rs.getInt("userID"));
				data.add(rs.getString("loginname"));
				data.add(rs.getString("loginpwd"));
				data.add(rs.getString("realname"));
				data.add(rs.getString("gender"));
				data.add(rs.getString("telnumber"));
				data.add(rs.getString("cardtype"));
				data.add(rs.getString("cardno"));
				data.add(rs.getString("usertypename"));
			    
				buffer.add(data);
			}
			// 5.关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return buffer;
		
	}

	/**
	 * 按照userID删除用户信息
	 * @author 张圆梦
	 */
	
	//deletuserByID
	public static  boolean deletuserByID(int userID) {
		// 删除反馈信息
		boolean flag = false;
		
		/*update user set remarks1 = '0'
				where userID = '1'*/
		String sql = "update user set remarks1 = '0' where userID = "+userID;
		int count = DBHelp.executeSql(sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}			
	/** 
	 *
	 * 获取表的行数
	 * 张圆梦
	 * @return
	 */
	public  int getCountUsers()  {
		int count = 0;	
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select count(*) from user";	
			rs =st.executeQuery(sql);			
			if(rs.next()) {			
				count = rs.getInt(1);
			}
			// 5.关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return count;
		
	}
	
	/** 
	 * 
	 * 条件查询获取表的行数
	 * 张圆梦
	 * @return
	 */
	public   int getCountUsers1(String realname)  {
		int count = 0;	
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select count(*) from user where 1=1 ";
			if(realname !=null && realname.trim().length()>0) {
				sql = sql + " and realname='" + realname +"'";
			}
			
			rs =st.executeQuery(sql);			
			if(rs.next()) {			
				count = rs.getInt(1);
			}
			// 5.关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return count;
	}
	
	
	


	/**
	 *  实现用户添加操作
	 * @param user :添加的用户对象
	 * @return true:添加成功 false:添加失败
	 * @author 张玲 
	 */
	/*
	public boolean addUser(user user) {
		boolean flag = false;
		String sql = "insert into user(loginname,loginpwd,realname,gender,telnumber,cardtype,cardno,usertype) "
				+ "values ('"+user.getLoginname()+"','"+user.getLoginpwd()+"','"+user.getRealname()+"','"+user.getGender()
				+"','"+user.getTelnumber()+"','"+user.getCardtype()+"','"+user.getCardno()+"','"+user.getUsertype()+"')";
		
		int count =DBHelp.executeSql(sql);
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	*/
	/*
	 * 修改用户
	 * @author 张玲 
	 */
	/*
	public boolean updateuser() throws Exception {
		// 修改用户信息
		boolean flag = false;
		String sql = "update user set loginname = 'ddd',loginpwd = '444' where userID =15;";
		int count = DBHelp.executeSql(sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	*/
	/*
	  * 删除用户
	 * @author 张玲 
	 */
	public boolean deluser(int userID) throws Exception {
		// 删除用户信息
		boolean flag = false;
		String sql = "delete from user where userID = "+ userID;
		int count = DBHelp.executeSql(sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	
	/*
	 * 查找用户
	 * @author 张玲 
	 */
	public static void findAlluser() throws Exception {
		// 查找用户信息
		String sql = "select userID,loginname,loginpwd,realname,gender,telnumber,cardtype,cardno,usertype from user";
		Connection conn = DBHelp.getConnect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			int userID = rs.getInt("userID");
			String loginname = rs.getString("loginname");
			String loginpwd = rs.getString("loginpwd");
			String realname = rs.getString("realname");
			String gender = rs.getString("gender");
			String telnumber = rs.getString("telnumber");
			String cardtype = rs.getString("cardtype");
			String cardno = rs.getString("cardno");
			int usertype = rs.getInt("usertype");
			System.out.println(userID + "," + loginname + "," + loginpwd + "," + realname + "," + gender + ","
					+ telnumber + "," + cardtype + "," + cardno + "," + usertype);
		}
		  DBHelp.closeAll(rs, st, conn);
   }
	/**
	 * 多表之间的联合查询
	 * @return
	 * @author 张玲 
	 */
	/*public List<List> findAll(){
		List<List> buffer = new ArrayList<List>();
		
		//连接数据库实现查询操作
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			connection = DBHelp.getConnect();
			st = connection.createStatement();
			String sql = "select userID,loginname,loginpwd,realname,"
					+ "usertypeid,usertypename from usertype t,user u " + 
					"where t.usertypeid = u.usertype";
			
			rs = st.executeQuery(sql);
			List data = null;
			while(rs.next()) {
				data = new ArrayList();				
				data.add(rs.getInt("userID"));
				data.add(rs.getString("loginname"));
				data.add(rs.getString("loginpwd"));
				data.add(rs.getString("realname"));
				data.add(rs.getInt("usertypeid"));
				data.add(rs.getString("usertypename"));
			    
				buffer.add(data);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return buffer;
	}
	
	/**
	 * 按条件查询用户信息
	 * @param loginname
	 * @param realname
	 * @return
	 * @author 张玲 
	 */
	public  List<user> findAll1(String loginname,String realname)  {
		List<user> useres = new ArrayList<user>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select userID,loginname,loginpwd,realname,gender,telnumber,"
					+ "cardtype,cardno,usertype from user where 1=1 ";
			if(loginname !=null && loginname.trim().length()>0) {
				sql = sql + " and  loginname like '%" + loginname +"%'";
			}
			if(realname !=null && realname.trim().length()>0) {
				sql = sql + " and realname like '%" + realname +"%'";
			}
		
			 
			rs =st.executeQuery(sql);
			user user =null;
			while(rs.next()) {
				//创建用户对象
				user = new user();
				user.setUserID(rs.getInt("userID"));				
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpwd(rs.getString("loginpwd"));
				user.setRealname(rs.getString("realname"));
				user.setGender(rs.getString("gender"));
				user.setTelnumber(rs.getString("telnumber"));
				user.setCardtype(rs.getString("cardtype"));
				user.setCardno(rs.getString("cardno"));
				user.setUsertype( rs.getInt("usertype"));
				useres.add(user);
			}
			// 5.关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return useres;
		
	}

	/**
	 * 分页查询
	 * @param currentPage :当前页
	 * @param pageSize :每页显示的记录总数
	 * @return
	 * @author 张玲 
	 */
	public  List<user> findAllUser(int currentPage,int pageSize)  {
		List<user> useres = new ArrayList<user>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select userID,loginname,loginpwd,realname,gender,telnumber," + 
					"cardtype,cardno,usertype from user "+
					" limit " + (currentPage-1)*pageSize + "," + pageSize;
			 
			rs =st.executeQuery(sql);
			user user =null;
			while(rs.next()) {
				//创建用户对象
				user = new user();
				user.setUserID(rs.getInt("userID"));				
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpwd(rs.getString("loginpwd"));
				user.setRealname(rs.getString("realname"));
				user.setGender(rs.getString("gender"));
				user.setTelnumber(rs.getString("telnumber"));
				user.setCardtype(rs.getString("cardtype"));
				user.setCardno(rs.getString("cardno"));
				user.setUsertype( rs.getInt("usertype"));
				useres.add(user);
			}
			// 5.关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return useres;
		
	}

	
	/**
	 * 按条件的分页查询
	 * @param loginname
	 * @param realname
	 * @param cardno
	 * @return
	 * @author 张玲 
	 */
	public  List<user> findAllUser(String loginname,String realname,String cardno,int currentPage,int pageSize)  {
		List<user> useres = new ArrayList<user>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select userID,loginname,loginpwd,realname,gender,telnumber,"
					+ "cardtype,cardno,usertype from user where 1=1 ";
			if(loginname !=null && loginname.trim().length()>0) {
				sql = sql + " and  loginname like '%" + loginname +"%'";
			}
			if(realname !=null && realname.trim().length()>0) {
				sql = sql + " and realname like '%"+realname +"%'";
			}
			if(cardno !=null && cardno.trim().length()>0) {
				sql = sql + " and cardno='" + cardno +"'";
			}
			
			sql = sql + " limit " + (currentPage-1)*pageSize + "," + pageSize;
			rs =st.executeQuery(sql);
			user user =null;
			while(rs.next()) {
				//创建用户对象
				user = new user();
				user.setUserID(rs.getInt("userID"));				
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpwd(rs.getString("loginpwd"));
				user.setRealname(rs.getString("realname"));
				user.setGender(rs.getString("gender"));
				user.setTelnumber(rs.getString("telnumber"));
				user.setCardtype(rs.getString("cardtype"));
				user.setCardno(rs.getString("cardno"));
				user.setUsertype( rs.getInt("usertype"));
				useres.add(user);
			}
			// 5.关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return useres;
		
	}
	

}
