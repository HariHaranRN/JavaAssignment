package model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import utility.HibernateUtility;

public class UserLoginQuery {
	public static void main(String[] args) {
		UserLoginQuery o=new UserLoginQuery();
		o.CheckStatus("hai");
	}
	public int insertUser(String uname,String upass) {
		UserLoginQuery os=new UserLoginQuery();
		int Id=(int) os.CountEmployee()+1;
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		UserDataUtility employee1=new UserDataUtility();
		employee1.setId(Id);
		employee1.setName(uname);
		employee1.setPassword(upass);
		employee1.setStatus(0);
		session.save(employee1);		
		tx.commit();
		session.close();
		return 1;
	}
	public int CheckUser(String Name,String Password ) {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("select Name,Password from UserDataUtility");
		Iterator<Object[]> obj=query.iterate();
		while(obj.hasNext())
		{
			Object o[]=obj.next();
			if(o[0].equals(Name) && o[1].equals(Password)) {
				return 1;
			}
			
			System.out.println(o[0]+":"+o[1]);
		}	
		return 0;
	}
	public long CheckStatus(String Name) {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("select Status from UserDataUtility where Name=:c");
		query.setParameter("c",Name);
		List<Integer> obj=query.list();
		for(Integer emp:obj) {
			System.out.println(emp);
			return emp;
		}	
		return 0;
	}
	public int findAll() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("from UserDataUtility");
		List<UserDataUtility> obj=query.list();
		for(UserDataUtility o:obj) {
			System.out.println(o.getId()+":"+o.getName());
		}
		return 0;
	}
	public int UpdateStatus(String Name,int Status) {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery(" update UserDataUtility  set Status=:s where Name=:c");
		query.setParameter("c",Name);
		query.setParameter("s",Status);
		int updateditems=query.executeUpdate();
		System.out.println(updateditems);
		session.beginTransaction().commit();
		return 1;
	}
	public void DeleteEmployee(String Name) {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery(" delete from UserDataUtility  where Name=:c");
		query.setParameter("c",Name);
		int updateditems=query.executeUpdate();
		System.out.println(updateditems);
		session.beginTransaction().commit();
	}
	public void DeleteCustomer(String Name) {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery(" delete from UserDataUtility  where Name=:c");
		query.setParameter("c",Name);
		int updateditems=query.executeUpdate();
		System.out.println(updateditems);
		session.beginTransaction().commit();
	}
	public long CountEmployee() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("select count(Name) from UserDataUtility ");
		List<Long> list=query.list();
		for(Long emp:list) {
			System.out.println(emp);
			return emp;
		}
		return 0;
	}
	
}