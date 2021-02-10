package model;

public interface UserBusiness {
	public boolean checkUser(String uname,String upass);
	public boolean checkStatus();
	public boolean updateStatus(String name,int flag);
	public boolean registerUser(String uname,String upass);
}
