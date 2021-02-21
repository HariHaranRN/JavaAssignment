package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utility.ConnectionUtility;

public class UserBusinessImpl implements UserBusiness{
	
	UserLoginQuery dao=new UserLoginQuery();
	@Override
	public boolean checkStatus(String uname) {
		// TODO Auto-generated method stub
		int status=(int) dao.CheckStatus(uname);
		if(status==1) {
			return false;
		}
		System.out.println("returned true");
		return true;
		
	}
	@Override
	public boolean checkUser(String uname, String upass) {
		// TODO Auto-generated method stub
		try {
			
			int statusobj=dao.CheckUser(uname, upass);
			if(statusobj==1) {
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
	
		int success=dao.insertUser(uname,upass);
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
			
			int success=dao.UpdateStatus(name, flag);;
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
