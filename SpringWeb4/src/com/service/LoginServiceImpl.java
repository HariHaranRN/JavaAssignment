package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;
import com.dao.UserLoginDAO;
import com.model.Login;
import com.model.User;

@Service("us1")
@Transactional
public class LoginServiceImpl implements LoginService{
	@Autowired
	private UserLoginDAO LoginDAO;

public UserLoginDAO getLoginDAO() {
		return LoginDAO;
	}

	public void setLoginDAO(UserLoginDAO loginDAO) {
		LoginDAO = loginDAO;
	}

@Override
public int Login(Login login) {
	// TODO Auto-generated method stub
	System.out.println(login.getName());
	LoginDAO.insertUser(login);
	return 0;
}
public void check() {
	System.out.println("check all");
	LoginDAO.findAll();
}
@Override
public boolean checkStatus(String uname) {
	// TODO Auto-generated method stub
	
	int status=(int) LoginDAO.CheckStatus(uname);
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
		
		int statusobj=LoginDAO.CheckUser(uname, upass);
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
public boolean registerUser(Login obj) {
	// TODO Auto-generated method stub

	int success=LoginDAO.insertUser(obj);
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
		
		int success=LoginDAO.UpdateStatus(name, flag);;
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