package com.service;
import com.model.Login;
public interface LoginService {
	public int Login(Login login);
	public void check();
	public boolean checkUser(String uname,String upass);
	public boolean checkStatus(String uname);
	public boolean updateStatus(String name,int flag);
	public boolean registerUser(Login login);
	
}
