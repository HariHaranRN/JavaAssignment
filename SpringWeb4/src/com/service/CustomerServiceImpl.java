package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerDAO;
import com.dao.UserLoginDAO;
import com.model.Customer;
@Service("us2")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
		@Autowired
		private CustomerDAO customerDAO;
		public CustomerDAO getCustomerDAO() {
			return customerDAO;
		}
		public void setCustomerDAO(CustomerDAO customerDAO) {
			this.customerDAO = customerDAO;
		}

@Override
public String checkCustomer(Customer customer) {
	// TODO Auto-generated method stub
	String ob=customerDAO.getCustomer(customer.getCustomerName(),customer.getCustomerMobile());
	if(ob==null) {
		customerDAO.CustomerLogin(customer);
		return customer.getCustomerName();
	}
	else {
		return ob;
	}
	
}

}
