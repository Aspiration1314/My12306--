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
	 * ɾ������
	 * @author ��Բ��
	 */
	public static boolean delorder(int orderID) throws Exception {
		// ɾ��������Ϣ
		boolean flag = false;
		String sql = "delete from tbl_order where orderID = "+ orderID;
		int count = DBHelp.executeSql(sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	
	

	/**
	 * �����ѯ����
	 * @return
	 * @author ��Բ��
	 */

public static void findAllorder() throws Exception {
		// ���Ҷ�����Ϣ
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
	 * ���֮������ϲ�ѯ����
	 * @return
	 * @author ��Բ��
	 */
public List<List> findAll(){
		List<List> buffer = new ArrayList<List>();
		
		//�������ݿ�ʵ�ֲ�ѯ����
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
	 * ��������ѯ������Ϣ
	 * @param orderstate userID
	 * @return
	 * @author ��Բ�� 
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
				//�����û�����
				order = new order();
				order.setOrderID(rs.getInt("orderID"));	
				order.setUserID(rs.getInt("userID"));
				order.setTicketID(rs.getInt("ticketID"));
				order.setSeattype(rs.getString("seattype"));
				order.setOrdertime(rs.getString("ordertime"));
				order.setOrderstate(rs.getString("orderstate"));
				orders.add(order);
			}
			// �ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return orders;
		
	}
	/**
	 * * ��ҳ��ѯ
	 * @param currentPage :��ǰҳ
	 * @param pageSize :ÿҳ��ʾ�ļ�¼����
	 * @return
	 * @author ��Բ�� 
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
				//�����û�����
				order = new order();
				order.setOrderID(rs.getInt("orderID"));	
				order.setUserID(rs.getInt("userID"));
				order.setTicketID(rs.getInt("ticketID"));
				order.setSeattype(rs.getString("seattype"));
				order.setOrdertime(rs.getString("ordertime"));
				order.setOrderstate(rs.getString("orderstate"));
				orders.add(order);
			}
			// �ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return orders;
		
	}

	/**
	 * �������ķ�ҳ��ѯ
	 * @param orderstate userID
	 * @return
	 * @author ��Բ��
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
				//�����û�����
				order = new order();
				order.setOrderID(rs.getInt("orderID"));	
				order.setUserID(rs.getInt("userID"));
				order.setTicketID(rs.getInt("ticketID"));
				order.setSeattype(rs.getString("seattype"));
				order.setOrdertime(rs.getString("ordertime"));
				order.setOrderstate(rs.getString("orderstate"));
				orders.add(order);
			}
			// 5.�ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return orders;
		
	}
/**������ʵ������ѯ������Ϣ
 * @param realname 
 * @return 
 * @author ��Բ��
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
		// 5.�ر����ݿ����Ӷ���
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		DBHelp.closeAll(rs, st, connection);
	}
	return buffer;
	
}
/**���ն���״̬��ѯ������Ϣ
 * @param orderstate 
 * @return 
 * @author ��Բ��
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
		// 5.�ر����ݿ����Ӷ���
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		DBHelp.closeAll(rs, st, connection);
	}
	return buffer;
	
}
/**
	 * ����orderIDɾ����Ʊ��Ϣ
	 * @author ��Բ��
	 */
	public static  boolean deletordrByID(int orderID) {
		// ɾ��������Ϣ
		boolean flag = false;
		String sql = "delete from tbl_order where orderID = "+ orderID;
		int count = DBHelp.executeSql(sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	/**�����û���ʵ����/����״̬��ѯ�û���Ϣ(��ҳ��ѯ)
	 * @param realname 
	 * @return 
	 * @author ��Բ��
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
			// 5.�ر����ݿ����Ӷ���
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
	 * ������ѯ��ȡ�������
	 * ��Բ��
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
			// 5.�ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return count;
	}
	
	
	

	
}


	