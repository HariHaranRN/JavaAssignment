package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.ConnectionUtility;


public class LoginAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		String upassword=request.getParameter("upass");
		HttpSession session=request.getSession();
		session.setAttribute("UserName", uname);
		UserBusinessImpl Bobj=new UserBusinessImpl();
	    System.out.println(uname +":"+upassword);
		try {
			
			if(Bobj.checkUser(uname, upassword)){	
				if(Bobj.checkStatus(uname))
					{ 	
						if(Bobj.updateStatus(uname,1)) {
							
							System.out.println("hai registered");
							return "login.success";
						}
					}
						
				else {
					System.out.println("No update status");
					
						return "login.success";
					}
			}
			else {
				System.out.println("register status");
				
					if(Bobj.registerUser(uname,upassword)) {
					return	"logout.success";
					}
					
			}
			return	"logout.success";
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return "shop2";
		}
		
}
}

