package control;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import model.UserBusinessImpl;
import model.UserDataUtility;


public class MyListener implements HttpSessionListener {


    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("session created");
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	HttpSession session=se.getSession();
    	Object en=session.getAttribute("UserName");
    	if(en==null) {
    		System.out.println("session destroyed");
    	}
    	else {
    	   	
        	UserBusinessImpl Bobj=new UserBusinessImpl();
        	boolean b=Bobj.updateStatus(en.toString(), 0);
        	if(b==true)
        		System.out.println("session destroyed");
        }
    	}
 
}