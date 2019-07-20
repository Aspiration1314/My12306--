package com.software.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.software.model.user;
import com.software.util.DBHelp;

/**
 * ���ݿ���ʲ�--ʵ���û�����
 * @author ���� 
 *
 */
public class userDao {
	/**
	 *  ʵ���û���Ӳ���
	 * @param user :��ӵ��û�����
	 * @return true:��ӳɹ� false:���ʧ��
	 * @author ���� 
	 */
	
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
	
	/*
	 * �޸��û�
	 * @author ���� 
	 */
	/*
	public boolean updateuser() throws Exception {
		// �޸��û���Ϣ
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
	  * ɾ���û�
	 * @author ���� 
	 */
	public boolean deluser(int userID) throws Exception {
		// ɾ���û���Ϣ
		boolean flag = false;
		String sql = "delete from user where userID = "+ userID;
		int count = DBHelp.executeSql(sql);
		
		if (count >0) {
			flag =true;
		}
		return flag;
	}
	
	/*
	 * �����û�
	 * @author ���� 
	 */
	
//	findAllUser
	public static void findAlluser() throws Exception {
		// �����û���Ϣ
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
	 * �����ѯ�����û���Ϣ
	 * @throws Exception
	 * @author ����
	 */
	
	public static List<user> findAlluser1() throws Exception {
		// �����ѯ
		List<user> buffer = new ArrayList<user>();
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			connection = DBHelp.getConnect();
			st = connection.createStatement();
			String sql = "select userID,loginname,loginpwd,realname,gender,telnumber,cardtype,cardno,usertype from user";
			
			rs = st.executeQuery(sql);
			user user = null;
			while(rs.next()) {
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
			    
				buffer.add(user);
				
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
	 * ���֮������ϲ�ѯ
	 * @return
	 * @author ���� 
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
	 * ��������ѯ�û���Ϣ  ��̨�û�����ϵͳ����
	 * @param loginname
	 * @param realname
	 * @return
	 * @author ���� 
	 */
	
//	findAll1
	public static  List<List> findAll1(String loginname,String realname)  {
		List<List> buffer = new ArrayList<List>();
		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select userID,loginname,realname,gender,telnumber,"
					+ "cardtype,cardno,usertypename from user,usertype where user.usertype = usertype.usertypeid ";
			if(loginname !=null && loginname.trim().length()>0) {
				sql = sql + " and  loginname like '%" + loginname +"%'";
			}
			if(realname !=null && realname.trim().length()>0) {
				sql = sql + " and realname = '" + realname +"'";
			}
			/*
			if(cardno !=null && cardno.trim().length()>0) {
				sql = sql + " and cardno= '" + cardno +"'";
			}*/
			 
			rs =st.executeQuery(sql);
			List data = null;
			while(rs.next()) {
				//�����û�����
				data = new ArrayList();	
				
				data.add(rs.getInt("userID"));
				data.add(rs.getString("loginname"));
				data.add(rs.getString("realname"));
				data.add(rs.getString("gender"));
				data.add(rs.getString("telnumber"));
				data.add(rs.getString("cardtype"));
				data.add(rs.getString("cardno"));
				data.add(rs.getString("usertypename"));
				
			    
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
	 * ��ҳ��ѯ
	 * @param currentPage :��ǰҳ
	 * @param pageSize :ÿҳ��ʾ�ļ�¼����
	 * @return
	 * @author ���� 
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
				//�����û�����
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
			// 5.�ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return useres;
		
	}

	
	/**
	 * �������ķ�ҳ��ѯ
	 * @param loginname
	 * @param realname
	 * @param cardno
	 * @return
	 * @author ���� 
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
				//�����û�����
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
			// 5.�ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return useres;
		
	}
	/**
	 *  ʵ���û��޸Ĳ���
	 * @param user :�޸ĵ��û�����
	 * @return true:�޸ĳɹ�   false:�޸�ʧ��
	 */
	public static boolean updateUser(user user) {
		boolean flag = false;
		String sql="update user set loginname='"+user.getLoginname()+
				"',loginpwd='"+user.getLoginpwd()+"',realname='"+user.getRealname()+
				"',gender='"+user.getGender()+"',telnumber='"+user.getTelnumber()+ 
				"',cardtype='"+user.getCardtype()+"',cardno='"+user.getCardno()+
				"',usertype='"+user.getUsertype()+"' where userId="+user.getUserID();
		
		int count =DBHelp.executeSql(sql);
		if (count >0) {
			flag =true;
		}
			
		return flag;
	}
	
	public  user findUserById(int userId)  {
		user user =new user();
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select userId,loginname,loginpwd,realname,gender,telnumber,cardtype,"
					+ "cardno,usertype from user where userId=" +userId;
			 
			rs =st.executeQuery(sql);
			
			if(rs.next()) {
				//�����û�����
			
				user.setUserID(rs.getInt("userID"));				
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpwd(rs.getString("loginpwd"));
				user.setRealname(rs.getString("realname"));
				user.setGender(rs.getString("gender"));
				user.setTelnumber(rs.getString("telnumber"));
				user.setCardtype(rs.getString("cardtype"));
				user.setCardno(rs.getString("cardno"));
				user.setUsertype(rs.getInt("usertype"));
				
			}
			// 5.�ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return user;
		
	}
	/** 
	 * ��¼��֤
	 * @param loginname
	 * @param loginpwd
	 * 
	 * @return
	 */
	
	//woaini
	public  user findAllUser(String loginname,String loginpwd)  {
		user user = null;		
		Connection connection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			connection = DBHelp.getConnect();		
			st = connection.createStatement();
			
			String sql = "select userId,loginname,loginpwd,realname,gender,"
					+ "telnumber,cardtype,cardno,usertype from user"
					+ " where loginname='" + loginname 
					+"' and remarks1 ='1' and loginpwd=" + loginpwd;
			
			System.out.println("Sql-->"+sql);
			 
			rs =st.executeQuery(sql);
			
			if(rs.next()) {	
				user =new user();
				user.setUserID(rs.getInt("userID"));				
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpwd(rs.getString("loginpwd"));
				user.setRealname(rs.getString("realname"));
				user.setGender(rs.getString("gender"));
				user.setTelnumber(rs.getString("telnumber"));
				user.setCardtype(rs.getString("cardtype"));
				user.setCardno(rs.getString("cardno"));
				user.setUsertype(rs.getInt("usertype"));
				
			}
			// 5.�ر����ݿ����Ӷ���
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, st, connection);
		}
		
		return user;
		
	}

}
