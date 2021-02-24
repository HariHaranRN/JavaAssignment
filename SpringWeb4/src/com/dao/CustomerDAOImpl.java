package com.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.Customer;


@Repository
public class CustomerDAOImpl extends CustomerDAO {
	@Autowired
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void findbyMobile(String Mobile) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select CustomerName from CustomerUtility where CustomerMobile=:c ");
		query.setParameter("c", Mobile);
		List<Object> list=query.list();
		for(Object emp:list) {
			System.out.println((String)emp);
		}
			
	}
	public void CustomerLogin(Customer customer) {
		
		System.out.println(customer.getCustomerId()+":"+customer.getCustomerMobile()+":"+customer.getCustomerName());
		Session session=sessionFactory.getCurrentSession();
		session.persist(customer);
	
	}
	public Long CountCustomer() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select count(CustomerName) from CustomerUtility ");
		List<Long> list=query.list();
		for(Long emp:list) {
			System.out.println(emp);
			return emp;
		}
		return (long) 0;
	}
	public String getCustomer(String Name,String Mobile) {
//		Session session=sessionFactory.getCurrentSession();
//		Query query=session.createQuery("select CustomerName,CustomerMobile from CustomerUtility");
//		Iterator<Object[]> obj=query.iterate();
//		while(obj.hasNext())
//		{
//			Object o[]=obj.next();
//			if(o[0].equals(Name) && o[1].equals(Mobile)) {
//				return (String) o[0];
//			}
//			
//			System.out.println(o[0]+":"+o[1]);
//		}	
		return null;
	}
	public int findAll() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from CustomerUtility");
//		List<CustomerDTO> obj=query.list();
//		for(CustomerDTO o:obj) {
//			System.out.println(o.getCustomerId()+":"+o.getCustomerMobile());
//		}
		return 0;
	}
	public void UpdateMobile(String Name,String Password) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(" update CustomerUtility  Password=:s where Name=:c");
		query.setParameter("c",Name);
		query.setParameter("s",Password);
		int updateditems=query.executeUpdate();
		System.out.println(updateditems);
		session.beginTransaction().commit();
	}
	public void DeleteCustomer(String Mobile) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(" delete from CustomerUtility  where Name=:c");
		query.setParameter("c",Mobile);
		int updateditems=query.executeUpdate();
		System.out.println(updateditems);
		session.beginTransaction().commit();
	}
}
