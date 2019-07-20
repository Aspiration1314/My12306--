package com.software.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.software.model.order;
import com.software.util.DBHelp;

/**
 * ���ݿ���ʲ�--ʵ�ֶ�����ز���
 * @author ������ 
 *
 */

public class orderDao {
	/**
	 *  ������Ӳ���
	 * @param order :��ӵĶ�������
	 * @return true:��ӳɹ� false:���ʧ��
	 * @author ������ 
	 */
	public boolean addorder(order order) {
		
		String seattype=order.getSeattype();
		int ticketID = order.getTicketID();
		
		//��Ӷ�����Ϣ
		boolean flag = false;
		String sql1 = "insert into tbl_order(userID,ticketID,orderstate,seattype,ordertime,remark1) " + 
				"values ('"+order.getUserID()+"','"+order.getTicketID()+"','"+order.getOrderstate()+"','"+
				order.getSeattype()+"',now(),'"+getTicketPrice(ticketID, seattype)+"')";
		
		int count =DBHelp.executeSql(sql1);
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	
	public double getTicketPrice(Integer ticketID ,String seattype){
		Statement st = null;
		ResultSet rs = null;
		String sql = null;	
		double ticketPrice = 0;
		if("����".equals(seattype))
		{
			sql = "select softsleeperprice from ticket where ticketID=" +ticketID;
		
		}
		if("Ӳ��".equals(seattype))
		{
			sql = "select hardsleeperprice from ticket where ticketID=" +ticketID;
		}
		if("Ӳ��".equals(seattype))
		{
			sql = "select hardseatprice from ticket where ticketID=" +ticketID;		
		}
		
		if("����".equals(seattype))
		{
			sql = "select noseatprice from ticket where ticketID=" +ticketID;
		}
		
		Connection connection = DBHelp.getConnect();
		try {
			st = connection.createStatement();
			rs =st.executeQuery(sql);
			if(rs.next()) {
				ticketPrice=rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return ticketPrice;
		
	}
	
	/**
	 * �������²���
	 * @return	true:ɾ���ɹ� false:ɾ��ʧ��
	 * @throws Exception
	 * @author ������
	 */
	public boolean updateorder1(Integer ticketID, Integer userID) {
		// �����û���Ϣ
		boolean flag = false;
		String sql = "update tbl_order set orderstate = '�Ѹ���'  where ticketID='"+ticketID+"' and userID=" +userID;
		int count = DBHelp.executeSql(sql);
		
		//System.out.println("Sql-->"+sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	
	/**
	 * �������²���
	 * @return	true:ɾ���ɹ� false:ɾ��ʧ��
	 * @throws Exception
	 * @author ������
	 */
	public boolean updateorder(Integer orderID){
		// �����û���Ϣ
		boolean flag = false;
		String sql = "update tbl_order set orderstate = '�Ѹ���' where orderID ="+orderID;
		int count = DBHelp.executeSql(sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	
	public boolean gaiqian(Integer orderID, Integer ticketID, String seattype){
		// �����û���Ϣ
		boolean flag = false;
		
		/* update user set loginname='"+user.getLoginname()+
				"',loginpwd='"+user.getLoginpwd()+"',realname='"+user.getRealname()+
				"',gender='"+user.getGender()+"',telnumber='"+user.getTelnumber()+ 
				"',cardtype='"+user.getCardtype()+"',cardno='"+user.getCardno()+
				"',usertype='"+user.getUsertype()+"' where userId="+user.getUserID();*/
		
//		update tbl_order set ticketID='1',orderstate='δ֧��',seattype='����',ordertime='12:43', remark1='456'
//				where orderID = '4'
		
		String sql = "update tbl_order set ticketID='"+ticketID+"',orderstate='δ֧��', seattype='"+seattype+"',ordertime=now(),remark1="+getTicketPrice(ticketID, seattype)+" "
				+ "where orderID ="+orderID;
		
		System.out.println("Sql-->"+sql);
		
		int count = DBHelp.executeSql(sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	
	
	/**
	 * ����ɾ������
	 * @param orderID �������
	 * @return	true:ɾ���ɹ� false:ɾ��ʧ��
	 * @throws Exception
	 * @author ������
	 */
	public boolean delorder(int orderID) throws Exception {
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
	 * �����ѯ���ж�����Ϣ
	 * @throws Exception
	 * @author ������
	 */
	public static List<order> findAllorder() throws Exception {
		// �����ѯ
		List<order> buffer = new ArrayList<order>();
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			connection = DBHelp.getConnect();
			st = connection.createStatement();
			String sql = "select orderID,userID,ticketID,orderstate,seattype,ordertime,remark1 from tbl_order";
			
			rs = st.executeQuery(sql);
			order order = null;
			while(rs.next()) {
				order = new order();			
				order.setOrderID(rs.getInt("orderID"));
				order.setUserID(rs.getInt("userID"));
				order.setTicketID(rs.getInt("ticketID"));
				order.setOrderstate(rs.getString("orderstate"));
				order.setSeattype(rs.getString("seattype"));
				order.setOrdertime(rs.getString("ordertime"));
				order.setRemark1(rs.getString("remark1"));
			    
				buffer.add(order);
				
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
	 * ������ϲ�ѯ������Ϣ
	 * @return �������
	 * @author ������ 
	 */
	public List<List> findAll(){
		List<List> buffer = new ArrayList<List>();
		//���϶����в�ѯ
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			connection = DBHelp.getConnect();
			st = connection.createStatement();
			String sql = "select orderID,trainnumber,startstation,endstation,starttime,endtime,"
					+ "realname,cardtype,seattype,usertypename,o.remark1,orderstate " + 
					"	from usertype t,user u,ticket z, tbl_order o " + 
					"	where t.usertypeid = u.usertype" + 
					"	and z.ticketID = o.ticketID " + 
					"	and o.userID = u.userID";
			
			rs = st.executeQuery(sql);
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
				data.add(rs.getString("o.remark1"));
				data.add(rs.getString("orderstate"));
			    
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

	/**���ն���״̬��ѯ������Ϣ
	 * @param orderstate ����״̬
	 * @return �������
	 * @author ������
	 */
	public  List<List> findAll1(int userID, String orderstate)  {
		List<List> buffer = new ArrayList<List>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select orderID,trainnumber,startstation,endstation,starttime,endtime,"
					+ "realname,cardtype,seattype,usertypename,o.remark1,orderstate " + 
					"	from usertype t,user u,ticket z, tbl_order o " + 
					"	where t.usertypeid = u.usertype " + 
					"	and z.ticketID = o.ticketID " + 
					"	and o.userID = u.userID ";
			
			if(userID != 0 ) {
				sql = sql + " and o.userID ='"+userID+"'";
			}
			if(orderstate !=null && orderstate.trim().length()>0) {
				sql = sql + " and orderstate ='"+orderstate+"'";
				//sql = sql + " and cardno='" + cardno +"'";
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
				data.add(rs.getString("o.remark1"));
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
	
	
	/**���ն�����Ų�ѯ����վ����ʼվ
	 * @param orderstate ����״̬
	 * @return �������
	 * @author ������
	 */
	public  List findStation(int orderID)  {
		List data = new ArrayList();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			/*select startstation,endstation 
			from tbl_order,ticket
			where tbl_order.ticketID = ticket.ticketID
			and orderID = '3';*/
			
			String sql = "select startstation,endstation from ticket, tbl_order " + 
					"	where ticket.ticketID = tbl_order.ticketID " + 
					"	and orderID ="+orderID;
			
			rs =st.executeQuery(sql);
			if(rs.next()) {		
				data.add(rs.getString("startstation"));
				data.add(rs.getString("endstation"));
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
	
	/**
	 * �������ķ�ҳ��ѯ������Ϣ
	 * @param orderstate ����״̬
	 * @param currentPage ��ǰҳ
	 * @param pageSize ��ǰҳ��ʾ��¼��
	 * @return ����ļ���
	 * @author ������
	 */
	public  List<List> findAll2(String orderstate,int currentPage,int pageSize)  {
		List<List> buffer = new ArrayList<List>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select orderID,trainnumber,startstation,endstation,starttime,endtime,"
					+ "realname,cardtype,seattype,usertypename,o.remark1,orderstate " + 
					"	from usertype t,user u,ticket z, tbl_order o " + 
					"	where 1=1 ";
			if(orderstate !=null && orderstate.trim().length()>0) {
				sql = sql + " and orderstate ='"+orderstate+"'";
			}
			
			sql = sql + " limit " + (currentPage-1)*pageSize + "," + pageSize;
			
			//System.out.println("Sql-->"+sql);
			
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
				data.add(rs.getString("o.remark1"));
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

//end
}
