package com.software.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.software.model.order;


import com.software.test.OrderDaoTest;
import com.software.util.DBHelp;

public class orderDao {

	/**
	 * 删除订单
	 * @author 张圆梦
	 */
	public static boolean delorder(int orderID) throws Exception {
		// 删除订单信息
		boolean flag = false;
		String sql = "delete from tbl_order where orderID = "+ orderID;
		int count = DBHelp.executeSql(sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	
	

	/**
	 * 单表查询订单
	 * @return
	 * @author 张圆梦
	 */

public static void findAllorder() throws Exception {
		// 查找订单信息
		String sql = "select orderID,userID,ticketID,orderstate,seattype,ordertime from tbl_order";
		Connection conn = DBHelp.getConnect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			int orderID = rs.getInt("orderID");
			int userID = rs.getInt("userID");
			int ticketID = rs.getInt("ticketID");
			String orderstate = rs.getString("orderstate");
			String seattype = rs.getString("seattype");
			String ordertime = rs.getString("ordertime");
			System.out.println(orderID + "," + userID + "," + ticketID + "," + orderstate + "," + seattype +"," +ordertime);
		}
		  DBHelp.closeAll(rs, st, conn);
   }
	/**
	 * 多表之间的联合查询订单
	 * @return
	 * @author 张圆梦
	 */
public List<List> findAll(){
		List<List> buffer = new ArrayList<List>();
		
		//连接数据库实现查询操作
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			connection = DBHelp.getConnect();
			st = connection.createStatement();
			String sql = "select u.userID,loginname,loginpwd,realname,"
					+ "trainnumber,startstation,"
					+ "endstation,starttime,endtime,duration,ordertime from user u ,ticket m , tbl_order d "
					+ "where m.ticketID=d.ticketID "
					+ "and d.userID=u.userID";
			
			rs = st.executeQuery(sql);
			List data = null;
			while(rs.next()) {
				data = new ArrayList();				
				data.add(rs.getInt("userID"));
				data.add(rs.getString("loginname"));
				data.add(rs.getString("loginpwd"));
				data.add(rs.getString("realname"));
				data.add(rs.getString("trainnumber"));
				data.add(rs.getString("startstation"));
				data.add(rs.getString("endstation"));
				data.add(rs.getInt("starttime"));
				data.add(rs.getString("endtime"));
				data.add(rs.getString("duration"));
				data.add(rs.getString("ordertime"));
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
	 * 按条件查询订单信息
	 * @param orderstate userID
	 * @return
	 * @author 张圆梦 
	 */
public  List<order> findAll(int userID,String orderstate)  {
		List<order> orders = new ArrayList<order>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			
			String sql ="select orderID,userID,ticketID,seattype,ordertime,orderstate from tbl_order";
			sql = sql + " where userId=" + userID;
			if(orderstate !=null && orderstate.trim().length()>0) {
				sql = sql + " and orderstate='" + orderstate +"'";
			}
			
			rs =st.executeQuery(sql);
			order order =null;
			while(rs.next()) {
				//创建用户对象
				order = new order();
				order.setOrderID(rs.getInt("orderID"));	
				order.setUserID(rs.getInt("userID"));
				order.setTicketID(rs.getInt("ticketID"));
				order.setSeattype(rs.getString("seattype"));
				order.setOrdertime(rs.getString("ordertime"));
				order.setOrderstate(rs.getString("orderstate"));
				orders.add(order);
			}
			// 关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return orders;
		
	}
	/**
	 * * 分页查询
	 * @param currentPage :当前页
	 * @param pageSize :每页显示的记录总数
	 * @return
	 * @author 张圆梦 
	 */
public  List<order> findAllOrder(int currentPage,int pageSize)  {
		List<order> orders = new ArrayList<order>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select orderID,userID,ticketID,seattype,ordertime,orderstate from tbl_order"+
					" limit " + (currentPage-1)*pageSize + "," + pageSize;
			 
			rs =st.executeQuery(sql);
			order order =null;
			while(rs.next()) {
				//创建用户对象
				order = new order();
				order.setOrderID(rs.getInt("orderID"));	
				order.setUserID(rs.getInt("userID"));
				order.setTicketID(rs.getInt("ticketID"));
				order.setSeattype(rs.getString("seattype"));
				order.setOrdertime(rs.getString("ordertime"));
				order.setOrderstate(rs.getString("orderstate"));
				orders.add(order);
			}
			// 关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return orders;
		
	}

	/**
	 * 按条件的分页查询
	 * @param orderstate userID
	 * @return
	 * @author 张圆梦
	 */
public  List<order> findAllOrder(int currentPage,int pageSize,int userID)  {
		List<order> orders = new ArrayList<order>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			
			String sql ="select orderID,userID,ticketID,seattype,ordertime,orderstate from tbl_order";
			sql = sql + " where userId=" + userID;
			sql = sql + " limit " + (currentPage-1)*pageSize + "," + pageSize;
			rs =st.executeQuery(sql);
			order order =null;
			while(rs.next()) {
				//创建用户对象
				order = new order();
				order.setOrderID(rs.getInt("orderID"));	
				order.setUserID(rs.getInt("userID"));
				order.setTicketID(rs.getInt("ticketID"));
				order.setSeattype(rs.getString("seattype"));
				order.setOrdertime(rs.getString("ordertime"));
				order.setOrderstate(rs.getString("orderstate"));
				orders.add(order);
			}
			// 5.关闭数据库连接对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return orders;
		
	}
/**按照真实姓名查询订单信息
 * @param realname 
 * @return 
 * @author 张圆梦
 */
public   List<List> findAllorder(String realname)  {
	List<List> buffer = new ArrayList<List>();
	
	Connection connection = null;
	Statement st = null;
	ResultSet rs = null;
	try {
		connection = DBHelp.getConnect();		
		st = connection.createStatement();
		
		String sql = "select orderID,trainnumber,startstation,endstation,starttime,endtime,"
				+ "realname,cardtype,seattype,usertypename,o.remark1,ordertime,orderstate " + 
				"	from usertype t,user u,ticket z, tbl_order o " + 
				"	where t.usertypeid = u.usertype " + 
				"	and z.ticketID = o.ticketID " + 
				"	and o.userID = u.userID ";
		
		if(realname !=null && realname.trim().length()>0) {
			sql = sql + " and realname ='"+realname+"'";
			
		}
		 
		rs =st.executeQuery(sql);
		List data = null;
		while(rs.next()) {
			data = new ArrayList();				
			data.add(rs.getInt("orderID"));
			data.add(rs.getString("trainnumber"));
			data.add(rs.getString("startstation"));
			data.add(rs.getString("endstation"));
			data.add(rs.getString("starttime"));
			data.add(rs.getString("endtime"));
			data.add(rs.getString("realname"));
			data.add(rs.getString("cardtype"));
			data.add(rs.getString("seattype"));
			data.add(rs.getString("usertypename"));
			data.add(rs.getDouble("o.remark1"));
			data.add(rs.getString("ordertime"));
			data.add(rs.getString("orderstate"));
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
/**按照订单状态查询订单信息
 * @param orderstate 
 * @return 
 * @author 张圆梦
 */
public   List<List> findAllorder1(String orderstate)  {
	List<List> buffer = new ArrayList<List>();
	
	Connection connection = null;
	Statement st = null;
	ResultSet rs = null;
	try {
		connection = DBHelp.getConnect();		
		st = connection.createStatement();
		
		String sql = "select orderID,trainnumber,startstation,endstation,starttime,endtime,"
				+ "realname,cardtype,seattype,usertypename,o.remark1,ordertime,orderstate " + 
				"	from usertype t,user u,ticket z, tbl_order o " + 
				"	where t.usertypeid = u.usertype " + 
				"	and z.ticketID = o.ticketID " + 
				"	and o.userID = u.userID ";
		
		if(orderstate !=null && orderstate.trim().length()>0) {
			sql = sql + " and orderstate ='"+orderstate+"'";
			
		}
		 
		rs =st.executeQuery(sql);
		List data = null;
		while(rs.next()) {
			data = new ArrayList();				
			data.add(rs.getInt("orderID"));
			data.add(rs.getString("trainnumber"));
			data.add(rs.getString("startstation"));
			data.add(rs.getString("endstation"));
			data.add(rs.getString("starttime"));
			data.add(rs.getString("endtime"));
			data.add(rs.getString("realname"));
			data.add(rs.getString("cardtype"));
			data.add(rs.getString("seattype"));
			data.add(rs.getString("usertypename"));
			data.add(rs.getDouble("o.remark1"));
			data.add(rs.getString("ordertime"));
			data.add(rs.getString("orderstate"));
	
		    
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
	 * 按照orderID删除车票信息
	 * @author 张圆梦
	 */
	public static  boolean deletordrByID(int orderID) {
		// 删除反馈信息
		boolean flag = false;
		String sql = "delete from tbl_order where orderID = "+ orderID;
		int count = DBHelp.executeSql(sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	/**按照用户真实姓名/订单状态查询用户信息(分页查询)
	 * @param realname 
	 * @return 
	 * @author 张圆梦
	 */
	public   List<List> findAll12(String realname,String orderstate, int currentPage,int pageSize)  {
		List<List> buffer = new ArrayList<List>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select orderID,trainnumber,startstation,endstation,starttime,endtime,"
					+ "realname,cardtype,seattype,usertypename,o.remark1,ordertime,orderstate " + 
					"	from usertype t,user u,ticket z, tbl_order o " + 
					"	where t.usertypeid = u.usertype " + 
					"	and z.ticketID = o.ticketID " + 
					"	and o.userID = u.userID and 1=1";
					if(realname !=null && realname.trim().length()>0) {
						sql = sql + " and realname='" + realname +"'";
					}
					if(orderstate !=null && orderstate.trim().length()>0) {
						sql = sql + " and orderstate='" + orderstate +"'";
					}
					
			sql = sql + " limit " + (currentPage-1)*pageSize + "," + pageSize;
			rs =st.executeQuery(sql);
			List data = null;
			while(rs.next()) {
				data = new ArrayList();				
				data.add(rs.getInt("orderID"));
				data.add(rs.getString("trainnumber"));
				data.add(rs.getString("startstation"));
				data.add(rs.getString("endstation"));
				data.add(rs.getString("starttime"));
				data.add(rs.getString("endtime"));
				data.add(rs.getString("realname"));
				data.add(rs.getString("cardtype"));
				data.add(rs.getString("seattype"));
				data.add(rs.getString("usertypename"));
				data.add(rs.getDouble("o.remark1"));
				data.add(rs.getString("ordertime"));
				data.add(rs.getString("orderstate"));
		
			    
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
	 * 
	 * 条件查询获取表的行数
	 * 张圆梦
	 * @return
	 */
	public   int getCountOrders1(String realname,String orderstate)  {
		int count = 0;	
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select count(*) from usertype t,user u,ticket z, tbl_order o "
			+ "	where t.usertypeid = u.usertype "
			 +"	and z.ticketID = o.ticketID " 
			+ "	and o.userID = u.userID and 1=1";
			if(realname !=null && realname.trim().length()>0) {
				sql = sql + " and realname='" + realname +"'";
			}
			if(orderstate !=null && orderstate.trim().length()>0) {
				sql = sql + " and orderstate='" + orderstate +"'";
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
	
	
	

	
}


	