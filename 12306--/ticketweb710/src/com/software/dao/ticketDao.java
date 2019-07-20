package com.software.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import org.eclipse.jdt.internal.compiler.ast.AND_AND_Expression;

import com.software.model.ticket;
import com.software.util.DBHelp;

/**
 * ���ݿ���ʲ�--ʵ�ֳ�Ʊ����
 * @author Administrator
 *
 */

public class ticketDao {
	/**
	 *  ʵ�ֳ�Ʊ��Ӳ���
	 * @param  :��ӵ��û�����
	 * @return true:��ӳɹ� false:���ʧ��
	 */
	public boolean addticket(ticket ticket) {
		boolean flag = false;
		String sql = "insert into ticket(trainnumber,startstation,endstation,starttime,endtime,duration,softsleepernumber,"
				+ "softsleeperprice,hardsleepernumber,hardsleeperprice,hardseatnumber,hardseatprice,noseatnumber,noseatprice) "
				+ "values ('"+ticket.getTrainnumber()+"','"+ticket.getStartstation()+"','"+ticket.getEndstation()+"','"
				+ticket.getStarttime()+"','"+ticket.getEndtime()+"','"+ticket.getDuration()+"','"
				+ticket.getSoftsleepernumber()+"','"+ticket.getSoftsleeperprice()+"','"
				+ticket.getHardsleepernumber()+"','"+ticket.getHardsleeperprice()+"','"+ticket.getHardseatnumber()+"','"
				+ticket.getHardseatprice()+"','"+ticket.getNoseatnumber()+"','"+ticket.getNoseatprice()+"')";
		
		int count =DBHelp.executeSql(sql);
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	
	/*
	 * �޸ĳ�Ʊ��Ϣ
	 */
	public boolean updateticket() throws Exception {
		// �޸ĳ�Ʊ��Ϣ
		boolean flag = false;
		String sql = "update ticket set trainnumber = 'T86', endstation = '�Ĵ�' where ticketID =6;";
		int count = DBHelp.executeSql(sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	
	/*
	 * ɾ����Ʊ
	 */
	public boolean delticket(int ticketID) throws Exception {
		// ɾ����Ʊ��Ϣ
		boolean flag = false;
		String sql = "delete from ticket where ticketID = "+ ticketID;
		int count = DBHelp.executeSql(sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	
	/*
	 * ���ҳ�Ʊ
	 */
	public static void findAllticket() throws Exception {
		// ���ҳ�Ʊ��Ϣ
		String sql = "select ticketID,managerID,trainnumber,startstation,endstation,starttime,endtime,duration,softsleepernumber," + 
				"softsleeperprice,hardsleepernumber,hardsleeperprice,hardseatnumber,hardseatprice,noseatnumber,noseatprice from ticket";
		Connection conn = DBHelp.getConnect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			int ticketID = rs.getInt("ticketID");
			int managerID = rs.getInt("managerID");
			String startstation = rs.getString("startstation");
			String endstation = rs.getString("endstation");
			String starttime = rs.getString("starttime");
			String endtime = rs.getString("endtime");
			String duration = rs.getString("duration");
			int softsleepernumber = rs.getInt("softsleepernumber");
			double softsleeperprice = rs.getDouble("softsleeperprice");
			int hardsleepernumber = rs.getInt("hardsleepernumber");
			double hardsleeperprice = rs.getDouble("hardsleeperprice");
			int hardseatnumber = rs.getInt("hardseatnumber");
			double hardseatprice = rs.getDouble("hardseatprice");
			int noseatnumber = rs.getInt("noseatnumber");
			double noseatprice = rs.getDouble("noseatprice");
			System.out.println(ticketID + "," + managerID + "," + startstation + "," + endstation + "," + starttime + ","
					+ endtime + "," + softsleepernumber + "," + softsleeperprice + "," + hardsleepernumber + "," + hardsleeperprice + 
					"," + hardseatnumber + "," + hardseatprice + "," + noseatnumber + ","+ noseatprice);
		}
		  DBHelp.closeAll(rs, st, conn);
	}
	
	/**
	 * ���֮������ϲ�ѯ
	 * @return
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
			String sql = "select loginname,loginpwd,ticketID,startstation,endstation,"
					+ "starttime,endtime from ticket t,manager u " + 
					"where t.managerID = u.managerID";
			
			rs = st.executeQuery(sql);
			List data = null;
			while(rs.next()) {
				data = new ArrayList();
				data.add(rs.getString("loginname"));
				data.add(rs.getString("loginpwd"));
				data.add(rs.getInt("ticketID"));
				data.add(rs.getString("startstation"));
				data.add(rs.getString("endstation"));
				data.add(rs.getString("starttime"));
				data.add(rs.getString("endtime"));
			    
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
	 * ��������ѯ��Ʊ��Ϣ
	 * @return
	 */
	public  List<ticket> findAll1(String startstation,String endstation)  {
		List<ticket> tickets = new ArrayList<ticket>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select ticketID,trainnumber,startstation,endstation,starttime,endtime,duration,softsleepernumber,"
					+ "softsleeperprice,hardsleepernumber,hardsleeperprice,hardseatnumber,hardseatprice,noseatnumber,noseatprice from ticket where 1=1 ";
			if(startstation !=null && startstation.trim().length()>0) {
				sql = sql + " and startstation like '%" + startstation +"%'";
			}
			if(endstation !=null && endstation.trim().length()>0) {
				sql = sql + " and endstation like '%" + endstation +"%'";
			}
			//if(endstation !=null && endstation.trim().length()>0) {
				//sql = sql + " and endstation ='" + endstation +"'";
			//}
			
			 
			rs =st.executeQuery(sql);
			ticket ticket =null;
			while(rs.next()) {
				//������Ʊ����
				ticket = new ticket();
				ticket.setTicketID(Integer.parseInt(rs.getString("ticketID")));
				ticket.setTrainnumber(rs.getString("trainnumber"));
				ticket.setStartstation(rs.getString("startstation"));
				ticket.setEndstation(rs.getString("endstation"));
				ticket.setStarttime(rs.getString("starttime"));
				ticket.setEndtime(rs.getString("endtime"));
				ticket.setDuration(rs.getString("duration"));
				ticket.setSoftsleepernumber(rs.getInt("softsleepernumber"));
				ticket.setSoftsleeperprice(rs.getDouble("softsleeperprice"));
				ticket.setHardsleepernumber(rs.getInt("hardsleepernumber"));
				ticket.setHardsleeperprice(rs.getDouble("hardsleeperprice"));
				ticket.setHardseatnumber(rs.getInt("hardseatnumber"));
				ticket.setHardseatprice(rs.getDouble("hardseatprice"));
				ticket.setNoseatnumber(rs.getInt("noseatnumber"));
				ticket.setNoseatprice(rs.getDouble("noseatprice"));
				
				tickets.add(ticket);
			}
			// 5.�ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return tickets;
		
	}
	
	/**
	 * ��ҳ��ѯ
	 * @param currentPage :��ǰҳ
	 * @param pageSize :ÿҳ��ʾ�ļ�¼����
	 * @return
	 */
	public  List<ticket> findAll2(int currentPage,int pageSize)  {
		List<ticket> tickets = new ArrayList<ticket>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select ticketID,managerID,trainnumber,startstation,endstation,starttime,endtime,duration,softsleepernumber," + 
					"softsleeperprice,hardsleepernumber,hardsleeperprice,hardseatnumber,hardseatprice,noseatnumber,noseatprice from ticket "+
					" limit " + (currentPage-1)*pageSize + "," + pageSize;
			 
			rs =st.executeQuery(sql);
			ticket ticket =null;
			while(rs.next()) {
				//������Ʊ����
				ticket = new ticket();
				ticket.setTicketID(rs.getInt("ticketID"));
				ticket.setManagerID(rs.getInt("managerID"));
				ticket.setStartstation(rs.getString("startstation"));
				ticket.setEndstation(rs.getString("endstation"));
				ticket.setStarttime(rs.getString("starttime"));
				ticket.setEndtime(rs.getString("endtime"));
				ticket.setDuration(rs.getString("duration"));
				ticket.setSoftsleepernumber(rs.getInt("softsleepernumber"));
				ticket.setSoftsleeperprice(rs.getDouble("softsleeperprice"));
				ticket.setHardsleepernumber(rs.getInt("hardsleepernumber"));
				ticket.setHardsleeperprice(rs.getDouble("hardsleeperprice"));
				ticket.setHardseatnumber(rs.getInt("hardseatnumber"));
				ticket.setHardseatprice(rs.getDouble("hardseatprice"));
				ticket.setNoseatnumber(rs.getInt("noseatnumber"));
				ticket.setNoseatprice(rs.getDouble("noseatprice"));
				
				tickets.add(ticket);
			}
			// 5.�ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return tickets;
		
	}

	
	/**
	 * �������ķ�ҳ��ѯ
	 * @return
	 */
	public  List<ticket> findAll3(String startstation,String endstation,String starttime,String endtime,int currentPage,int pageSize)  {
		List<ticket> tickets = new ArrayList<ticket>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select ticketID,managerID,duration,startstation,endstation,starttime,endtime,softsleepernumber,"
					+ "softsleeperprice,hardsleepernumber,hardsleeperprice,hardseatnumber,hardseatprice,noseatnumber,noseatprice from ticket where 1=1 ";
			if(startstation !=null && startstation.trim().length()>0) {
				sql = sql + " and startstation like '%" + startstation +"%'";
			}
			if(endstation !=null && endstation.trim().length()>0) {
				sql = sql + " and endstation like '%" + endstation +"%'";
			}
			if(starttime !=null && starttime.trim().length()>0) {
				sql = sql + " and starttime like '%" + starttime +"%'";
			}
			if(endtime !=null && endtime.trim().length()>0) {
				sql = sql + " and endtime= '" + endtime +"'";
			}
			
			sql = sql + " limit " + (currentPage-1)*pageSize + "," + pageSize;
			rs =st.executeQuery(sql);
			ticket ticket =null;
			while(rs.next()) {
				//������Ʊ����
				ticket = new ticket();
				ticket.setTicketID(rs.getInt("ticketID"));
				ticket.setManagerID(rs.getInt("managerID"));
				ticket.setStartstation(rs.getString("startstation"));
				ticket.setEndstation(rs.getString("endstation"));
				ticket.setStarttime(rs.getString("starttime"));
				ticket.setEndtime(rs.getString("endtime"));
				ticket.setDuration(rs.getString("duration"));
				ticket.setSoftsleepernumber(rs.getInt("softsleepernumber"));
				ticket.setSoftsleeperprice(rs.getDouble("softsleeperprice"));
				ticket.setHardsleepernumber(rs.getInt("hardsleepernumber"));
				ticket.setHardsleeperprice(rs.getDouble("hardsleeperprice"));
				ticket.setHardseatnumber(rs.getInt("hardseatnumber"));
				ticket.setHardseatprice(rs.getDouble("hardseatprice"));
				ticket.setNoseatnumber(rs.getInt("noseatnumber"));
				ticket.setNoseatprice(rs.getDouble("noseatprice"));
				
				tickets.add(ticket);
			}
			// 5.�ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return tickets;
		
	}
	
	
	/**
	 * ����ƱID����λ���Ͳ�ѯ��Ʊ��Ϣ
	 * ʵ�ֵ������
	 */
	public  List findticketchoose(int ticketID, String seattype)  {
		List data =new ArrayList();
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = null;
			//System.out.println("Sql-->"+sql);
			
			
			if(seattype == "����")
			{
				sql = "select ticketID,softsleeperprice from ticket where ticketID=" +ticketID;
				
				rs =st.executeQuery(sql);
				
				if(rs.next()) {
					//�����û�����
					data.add(rs.getInt("ticketID"));
					data.add(rs.getString("softsleeperprice"));
				}
			}
			if(seattype == "Ӳ��")
			{
				sql = "select ticketID,hardsleeperprice from ticket where ticketID=" +ticketID;
				
				rs =st.executeQuery(sql);
				
				if(rs.next()) {
					//�����û�����
					data.add(rs.getInt("ticketID"));
					data.add(rs.getString("hardsleeperprice"));
				}
			}
			if(seattype == "Ӳ��")
			{
				sql = "select ticketID,hardseatprice from ticket where ticketID=" +ticketID;
				
				//System.out.println("Sql-->"+sql);
				
				rs =st.executeQuery(sql);
				
				if(rs.next()) {
					//�����û�����
					data.add(rs.getInt("ticketID"));
					data.add(rs.getString("hardseatprice"));
				}
				
			}
			if(seattype == "����")
			{
				sql = "select ticketID,noseatprice from ticket where ticketID=" +ticketID;
				
				rs =st.executeQuery(sql);
				
				if(rs.next()) {
					//�����û�����
					data.add(rs.getInt("ticketID"));
					data.add(rs.getString("noseatprice"));
				}
			}
			
			// 5.�ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return data;	
	}
	
	
	
	public  ticket findticketById(int ticketID)  {
		ticket ticket =new ticket();
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select ticketID,trainnumber,duration,startstation,endstation,starttime,endtime,"
					+ "softsleepernumber,softsleeperprice,hardsleepernumber,hardsleeperprice,"
					+ "hardseatnumber,hardseatprice,noseatnumber,noseatprice from ticket where ticketID=" +ticketID;
			
			//System.out.println("Sql-->"+sql);
			
			rs =st.executeQuery(sql);
			
			if(rs.next()) {
				//�����û�����
				ticket.setTicketID(Integer.parseInt(rs.getString("ticketID")));
				ticket.setTrainnumber(rs.getString("trainnumber"));
				ticket.setStartstation(rs.getString("startstation"));
				ticket.setEndstation(rs.getString("endstation"));
				ticket.setStarttime(rs.getString("starttime"));
				ticket.setEndtime(rs.getString("endtime"));
				ticket.setDuration(rs.getString("duration"));
				ticket.setSoftsleepernumber(rs.getInt("softsleepernumber"));
				ticket.setSoftsleeperprice(rs.getDouble("softsleeperprice"));
				ticket.setHardsleepernumber(rs.getInt("hardsleepernumber"));
				ticket.setHardsleeperprice(rs.getDouble("hardsleeperprice"));
				ticket.setHardseatnumber(rs.getInt("hardseatnumber"));
				ticket.setHardseatprice(rs.getDouble("hardseatprice"));
				ticket.setNoseatnumber(rs.getInt("noseatnumber"));
				ticket.setNoseatprice(rs.getDouble("noseatprice"));
				
			}
			// 5.�ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		return ticket;	
	}

	/** 
	 * 2019.7.10
	 * ��ȡ�������
	 * 
	 * @return
	 */
	public  int getCounttickets()  {
		int count = 0;	
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select count(*) from ticket";	
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
	
	/** 
	 * 2019.7.10
	 * ��ȡ�������
	 * 
	 * @return
	 */
	public  int getCounttickets(String startstation,String endstation)  {
		int count = 0;	
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select count(*) from ticket where 1=1 ";
			if(startstation !=null && startstation.trim().length()>0) {
				sql = sql + " and  startstation like '%" + startstation +"%'";
			}
			
			if(endstation !=null && endstation.trim().length()>0) {
				sql = sql + " and endstation='" + endstation +"'";
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
	/**
	 * �������ķ�ҳ��ѯ
	 * @return
	 */
	public  List<ticket> findAll(String startstation,String endstation,int currentPage,int pageSize)  {
		List<ticket> tickets = new ArrayList<ticket>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select ticketID,managerID,trainnumber,duration,startstation,endstation,starttime,endtime,softsleepernumber,"
					+ "softsleeperprice,hardsleepernumber,hardsleeperprice,hardseatnumber,hardseatprice,noseatnumber,noseatprice from ticket where 1=1 ";
			if(startstation !=null && startstation.trim().length()>0) {
				sql = sql + " and startstation like '%" + startstation +"%'";
			}
			if(endstation !=null && endstation.trim().length()>0) {
				sql = sql + " and endstation like '%" + endstation +"%'";
			}
			
			
			sql = sql + " limit " + (currentPage-1)*pageSize + "," + pageSize;
			rs =st.executeQuery(sql);
			ticket ticket =null;
			while(rs.next()) {
				//������Ʊ����
				ticket = new ticket();
				ticket.setTicketID(rs.getInt("ticketID"));
				ticket.setManagerID(rs.getInt("managerID"));
				ticket.setTrainnumber(rs.getString("trainnumber"));
				ticket.setStartstation(rs.getString("startstation"));
				ticket.setEndstation(rs.getString("endstation"));
				ticket.setStarttime(rs.getString("starttime"));
				ticket.setEndtime(rs.getString("endtime"));
				ticket.setDuration(rs.getString("duration"));
				ticket.setSoftsleepernumber(rs.getInt("softsleepernumber"));
				ticket.setSoftsleeperprice(rs.getDouble("softsleeperprice"));
				ticket.setHardsleepernumber(rs.getInt("hardsleepernumber"));
				ticket.setHardsleeperprice(rs.getDouble("hardsleeperprice"));
				ticket.setHardseatnumber(rs.getInt("hardseatnumber"));
				ticket.setHardseatprice(rs.getDouble("hardseatprice"));
				ticket.setNoseatnumber(rs.getInt("noseatnumber"));
				ticket.setNoseatprice(rs.getDouble("noseatprice"));
				
				tickets.add(ticket);
			}
			// 5.�ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return tickets;
		
	}
	

}



