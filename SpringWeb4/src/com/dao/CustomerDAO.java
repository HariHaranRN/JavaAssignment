package com.dao;

import com.model.Customer;

public abstract class CustomerDAO {
	public abstract void findbyMobile(String Mobile);
	public abstract void CustomerLogin(Customer customer);
	public abstract Long CountCustomer();
	public abstract String getCustomer(String Name,String Mobile);
	public abstract int findAll();
	public abstract void UpdateMobile(String Name,String Password);
	public abstract void DeleteCustomer(String Mobile);
}
