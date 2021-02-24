package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Customer;
import com.model.Login;
import com.model.User;
import com.service.CustomerService;
import com.service.LoginService;
import com.service.UserService;


@Controller
public class BasicController {

	@Autowired
	UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	@Qualifier("us1")
	LoginService login;
	public LoginService getLogin() {
		return login;
	}
	public void setLogin(LoginService login) {
		this.login = login;
	}
	
	@Autowired
	@Qualifier("us2")
	CustomerService customer;
	
	public CustomerService getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerService customer) {
		this.customer = customer;
	}

	@RequestMapping(value="/loadloginform", method=RequestMethod.GET)
	public ModelAndView loadLoginForm(ModelAndView mandv) {
		Login lfb=new Login();
		mandv.addObject("formBeanObject", lfb);
		mandv.setViewName("login1");
		return mandv;
	}
	@RequestMapping(value="/loginsubmit", method=RequestMethod.POST)
	public ModelAndView processLoginForm(Login logi,ModelAndView mandv) {
		System.out.println(logi.getName());	
		Customer lb=new Customer();
		try {
					
					if(login.checkUser(logi.getName(),logi.getPassword())){	
						if(login.checkStatus(logi.getName()))
							{ 	
								if(login.updateStatus(logi.getName(),1)) {
									
									System.out.println("hai registered");
									mandv.addObject("CustomerBean",lb);
									mandv.setViewName("welcome");
									return mandv;
									
								}
							}
								
						else {
							System.out.println("No update status");
							mandv.addObject("CustomerBean", lb);
							mandv.setViewName("welcome");
							return mandv;
							
							}
					}
					else {
						System.out.println("register status");
							logi.setStatus(0);
							if(login.registerUser(logi)) {
								System.out.println("user registered");
								System.out.println("1 registered");
								mandv.addObject("CustomerBean",lb);
								mandv.setViewName("welcome");
								return mandv;
							}
							
					}
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}

		return mandv;
	}
	@RequestMapping(value="/customersubmit", method=RequestMethod.POST)
	public ModelAndView processcustomer(Customer customerobj,ModelAndView mandv) {
		System.out.println(customerobj.getCustomerMobile()+":"+customerobj.getCustomerName());
		customer.checkCustomer(customerobj);
		return mandv;
	}
}
