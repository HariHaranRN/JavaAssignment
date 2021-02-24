package com.dao;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.Login;
import org.springframework.stereotype.Repository;
@Repository
public class UserLoginQuery extends UserLoginDAO{
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public int insertUser(Login login) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(login);	
		return 1;
	}
	public int CheckUser(String Name,String Password ) {
		Session session=sessionFactory.getCurrentSession();
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
		Session session=sessionFactory.getCurrentSession();
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
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from UserDataUtility");
		List<Login> obj=query.list();
		for(Login o:obj) {
			System.out.println(o.getId()+":"+o.getName());
		}
		return 0;
	}
	public int UpdateStatus(String Name,int Status) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(" update UserDataUtility  set Status=:s where Name=:c");
		query.setParameter("c",Name);
		query.setParameter("s",Status);
		int updateditems=query.executeUpdate();
		System.out.println(updateditems);
		//session.beginTransaction().commit();
		return 1;
	}
	public void DeleteEmployee(String Name) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(" delete from UserDataUtility  where Name=:c");
		query.setParameter("c",Name);
		int updateditems=query.executeUpdate();
		System.out.println(updateditems);
		session.beginTransaction().commit();
	}
	public void DeleteCustomer(String Name) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(" delete from UserDataUtility  where Name=:c");
		query.setParameter("c",Name);
		int updateditems=query.executeUpdate();
		System.out.println(updateditems);
		session.beginTransaction().commit();
	}
	public long CountEmployee() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select count(Name) from UserDataUtility ");
		List<Long> list=query.list();
		for(Long emp:list) {
			System.out.println(emp);
			return emp;
		}
		return 0;
	}
	
}