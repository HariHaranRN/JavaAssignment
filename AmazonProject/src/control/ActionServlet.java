package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.DBUtility;

/**
 * Servlet implementation class ActionServlet
 */
public class ActionServlet extends HttpServlet {
	RequestProcessor rp;
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			rp=new RequestProcessor();
			ServletContext ctx=config.getServletContext();
			String configFile=config.getInitParameter("config");
			String dbConfigFile=config.getInitParameter("dbconfig");
			String configPath=ctx.getRealPath(configFile);
			Properties prop=new Properties();
			prop.load(new FileInputStream(configPath));
			ctx.setAttribute("prop", prop);
			
			String dbConfigPath=ctx.getRealPath(dbConfigFile);
			Properties dbprop=new Properties();
			dbprop.load(new FileInputStream(dbConfigPath));
			DBUtility.setDriver(dbprop.getProperty("driver"));
			DBUtility.setUrl(dbprop.getProperty("url"));
			DBUtility.setUsername(dbprop.getProperty("username"));
			DBUtility.setPassword(dbprop.getProperty("password"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	synchronized protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rp=rp.getClone();
		rp.process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	synchronized protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
