package control;

import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Action;

public class RequestProcessor implements Cloneable{
	synchronized void process(HttpServletRequest request,HttpServletResponse response) {
		try {
			ServletContext ctx=request.getServletContext();
			
			Properties prop=(Properties)ctx.getAttribute("prop");
			String formid=request.getParameter("formid");//login
			String actionClass=prop.getProperty(formid);
			Action action=(Action)Class.forName(actionClass).getDeclaredConstructor().newInstance();
			String result=action.execute(request, response);
			String nextPage=prop.getProperty(result);
			RequestDispatcher rd=request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public RequestProcessor getClone() {
		try {
			return (RequestProcessor)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
