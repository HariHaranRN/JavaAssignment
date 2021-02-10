package model;

abstract class UserDAO {
	public abstract UserDataUtility findbyId(int Id);
	public abstract UserDataUtility findbyName(String Name,String Password);
	public abstract int insertUser(String Name,String Password);
	public abstract int updateStatus(String name,int flag);
	public abstract int getStatus();

}
