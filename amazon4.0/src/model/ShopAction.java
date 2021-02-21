package model;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customerPackage.CustomerBusinessImpl;
import customerPackage.CustomerDTO;
import customerPackage.CustomerInerface;

public class ShopAction extends Action{
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	HttpSession session=request.getSession();
	String CustomerName=request.getParameter("CustomerName");
	String CustomerMobile=request.getParameter("CustomerMobile");
	System.out.println(CustomerName+":"+CustomerMobile);
	session.setAttribute("CustomerMobile", CustomerMobile);
	CustomerInerface obj=new CustomerBusinessImpl();
	String Name=obj.checkCustomer(CustomerName, CustomerMobile);
	if(Name==null) {
		System.out.println("error");
		return "Error";
	}
	else {
		
		session.setAttribute("CustomerName",Name);
		return "shop.success";
		
	}
	
	
}
}
