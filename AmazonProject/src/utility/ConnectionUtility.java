package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtility {
	private static Connection con;
	private ConnectionUtility() {
		
	}
	static {
		try {
			Class.forName(DBUtility.getDriver());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static ThreadLocal<Connection> tlocal=new ThreadLocal<Connection>();
	synchronized public static Connection createConnection() {
		con=tlocal.get();
		if(con==null) {
			try {
				con=DriverManager.getConnection
						(DBUtility.getUrl(),DBUtility.getUsername(),DBUtility.getPassword());
				con.setAutoCommit(false);
				tlocal.set(con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	synchronized public static void closeConnection(Exception exception) {
		try {
			con=tlocal.get();
			if(con!=null) {
				if(exception==null) {
					con.commit();
				}
				else {
					con.rollback();
				}
				con.close();
				tlocal.remove();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
