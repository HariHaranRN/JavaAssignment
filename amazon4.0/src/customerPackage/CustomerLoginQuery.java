package customerPackage;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import model.UserDataUtility;
import utility.HibernateUtility;

public class CustomerLoginQuery {
	public static void main(String[] args) {
		CustomerLoginQuery obj=new CustomerLoginQuery();
		//System.out.println(obj.getCustomer("mahi","1234"));
		obj.findbyMobile("1234");
		
	}
	public void findbyMobile(String Mobile) {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("select CustomerName from CustomerUtility where CustomerMobile=:c ");
		query.setParameter("c", Mobile);
		List<Object> list=query.list();
		for(Object emp:list) {
			System.out.println((String)emp);
		}
			
	}
	public void CustomerLogin(String Name,String Mobile) {
		
		
		CustomerLoginQuery obj=new CustomerLoginQuery();
		int count=(int) (obj.CountCustomer()+1);
		
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		CustomerDTO customer=new CustomerDTO();
		customer.setCustomerId(count);
		customer.setCustomerMobile(Mobile);
		customer.setCustomerName(Name);
		session.save(customer);
		tx.commit();	
		session.close();
	}
	public Long CountCustomer() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("select count(CustomerName) from CustomerUtility ");
		List<Long> list=query.list();
		for(Long emp:list) {
			System.out.println(emp);
			return emp;
		}
		return (long) 0;
	}
	public String getCustomer(String Name,String Mobile) {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("select CustomerName,CustomerMobile from CustomerUtility");
		Iterator<Object[]> obj=query.iterate();
		while(obj.hasNext())
		{
			Object o[]=obj.next();
			if(o[0].equals(Name) && o[1].equals(Mobile)) {
				return (String) o[0];
			}
			
			System.out.println(o[0]+":"+o[1]);
		}	
		return null;
	}
	public int findAll() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("from CustomerUtility");
		List<CustomerDTO> obj=query.list();
		for(CustomerDTO o:obj) {
			System.out.println(o.getCustomerId()+":"+o.getCustomerMobile());
		}
		return 0;
	}
	public void UpdateMobile(String Name,String Password) {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery(" update CustomerUtility  Password=:s where Name=:c");
		query.setParameter("c",Name);
		query.setParameter("s",Password);
		int updateditems=query.executeUpdate();
		System.out.println(updateditems);
		session.beginTransaction().commit();
	}
	public void DeleteCustomer(String Mobile) {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery(" delete from CustomerUtility  where Name=:c");
		query.setParameter("c",Mobile);
		int updateditems=query.executeUpdate();
		System.out.println(updateditems);
		session.beginTransaction().commit();
	}
	
	
}
