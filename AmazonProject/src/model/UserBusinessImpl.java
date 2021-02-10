package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utility.ConnectionUtility;

public class UserBusinessImpl implements UserBusiness{
	UserDAO DAO=new UserDAOImpl();
	
	@Override
	public boolean checkStatus() {
		// TODO Auto-generated method stub
		int status=DAO.getStatus();
		if(status==1) {
			return false;
		}
		return true;
	}
	@Override
	public boolean checkUser(String uname, String upass) {
		// TODO Auto-generated method stub
		try {
			
			UserDataUtility statusobj=DAO.findbyName(uname,upass);
			if(statusobj!=null) {
				return true;
			}
			else {
				return false;
			}
			}
			
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public boolean registerUser(String uname, String upass) {
		// TODO Auto-generated method stub
	
		int success=DAO.insertUser(uname,upass);
		if(success==0) {
			return false;
		}
		else {
			return true;
		}
		
	} 
	@Override
	public boolean updateStatus(String name,int flag) {
		try {
			
			int success=DAO.updateStatus(name,flag);
			if(success==0) {
				return false;
			}
			else {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			
			return false;
		}	
	
	}
	
}
