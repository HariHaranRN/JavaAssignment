package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="CustomerUtility")
@Table(name="Customers")
public class Customer {
	@Id
	private String CustomerMobile;
	private String CustomerName;
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerMobile() {
		return CustomerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		CustomerMobile = customerMobile;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int CustomerId;
}
