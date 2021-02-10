package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.ConnectionUtility;

public class LogoutAction extends Action{
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	HttpSession session=request.getSession();

	
	Object en=session.getAttribute("UserName");

	
	UserDataUtility obj=new UserDataUtility();
	UserBusinessImpl Bobj=new UserBusinessImpl();
	System.out.println("Logout"+en.toString());
	obj.setName(en.toString());
	
	
	try {
		if(Bobj.updateStatus(en.toString(),0)) {
			session.invalidate();
			return "logout.success";

		}
		else {
			return "shop3";
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		return "shop3";
	}
	
	
}
}
