package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.ConnectionUtility;

public class UserDAOImpl extends UserDAO{
	UserDataUtility obj=new UserDataUtility();
	
 
	@Override
	public UserDataUtility findbyId(int Id) {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtility.createConnection();
		try {

			PreparedStatement ps=con.prepareStatement("select * from userdata where Id=?");
			ps.setInt(1,Id);	
			obj.setId(Id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
						int status=rs.getInt("Status");
						String Name=rs.getString("Name");
						String Password=rs.getString("Password");
						obj.setName(Name);
						obj.setPassword(Password);
						obj.setStatus(status);
						return obj;
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtility.closeConnection(null);
		}
		return null;
		
	} 
	@Override
	public UserDataUtility findbyName(String Name,String Password) {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtility.createConnection();
		try {

			PreparedStatement ps=con.prepareStatement("select * from userdata where Name=? and Password=?");
			ps.setString(1,Name);	
			ps.setString(2,Password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
						int status=rs.getInt("Status");
						int id=rs.getInt("Id");	
						obj.setId(id);
						obj.setStatus(status);
						obj.setName(Name);
						return obj;
			}
			else {
				return null;
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			ConnectionUtility.closeConnection(null);
		}
		
	} 
	@Override
	public int insertUser(String Name,String Password) {
		
		// TODO Auto-generated method stub
		try {
			System.out.println(Name+":"+Password);
			System.out.println("Welcome To Registartion Page");
			int Id=UserDAOImpl.generatePrimaryKey()+1;
			Connection con=ConnectionUtility.createConnection();
			PreparedStatement ps=con.prepareStatement("insert into userdata (Id,Name,Password,Status) values (?,?,?,0)");
			ps.setInt(1,Id);
			ps.setString(2,Name);
			ps.setString(3,Password);
			ps.executeUpdate();
			System.out.println("User Registered"+ps);
			
			return 1;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		finally {
			ConnectionUtility.closeConnection(null);
		}
	}
	
	@Override
	public int updateStatus(String name,int flag) {
		Connection con=ConnectionUtility.createConnection();
		// TODO Auto-generated method stub
		try {

			
			PreparedStatement ps2=con.prepareStatement("update userdata set status=? where Name=? ");
			ps2.setString(2,name);
			ps2.setInt(1,flag);
			ps2.executeUpdate();
			return 1;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}	
		finally {
			ConnectionUtility.closeConnection(null);
		}
	
	}
	@Override
	public int getStatus() {
		// TODO Auto-generated method stub
		return obj.getStatus();
	}

	public static int generatePrimaryKey() {
		Connection con=ConnectionUtility.createConnection();
		PreparedStatement ps3;
		try {
			ps3 = con.prepareStatement("select count(Id) as count from userdata");
			ResultSet rs2=ps3.executeQuery();
			int count=0;
			if(rs2.next()) {
				count=rs2.getInt("count");
				return count;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionUtility.closeConnection(null);
		}
		
		
		return 0;
	}
}
