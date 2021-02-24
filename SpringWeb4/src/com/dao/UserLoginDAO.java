package com.dao;

import com.model.Login;

public abstract class UserLoginDAO {
	public abstract int insertUser(Login login);
	public abstract int CheckUser(String Name,String Password );
	public abstract long CheckStatus(String Name);
	public  abstract int findAll();
	public abstract  int UpdateStatus(String Name,int Status);
	public abstract void DeleteEmployee(String Name);
	public abstract void DeleteCustomer(String Name);
	public abstract long CountEmployee();
}
