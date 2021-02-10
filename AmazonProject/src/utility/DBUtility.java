package utility;

public class DBUtility {
	private static String driver,url,username,password;

	public static String getDriver() {
		return driver;
	}

	public static void setDriver(String driver) {
		DBUtility.driver = driver;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		DBUtility.url = url;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		DBUtility.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		DBUtility.password = password;
	}
}
