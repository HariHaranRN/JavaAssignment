package model;

public interface UserBusiness {
	public boolean checkUser(String uname,String upass);
	public boolean checkStatus(String uname);
	public boolean updateStatus(String name,int flag);
	public boolean registerUser(String uname,String upass);
}
