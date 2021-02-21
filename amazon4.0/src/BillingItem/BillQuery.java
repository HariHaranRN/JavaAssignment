package BillingItem;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import utility.HibernateUtility;

public class BillQuery {
	public static void main(String[] args) {
		BillQuery bill=new BillQuery();
		bill.maxCustomer();
		bill.AllProducts();
		bill.BillNo();
		bill.ItemNo();
	}
	public void maxCustomer() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("select max(CustomerMobile) from BillNos  ");
		
		List<String> list=query.list();
		for(String emp:list) {
			System.out.println((String)emp);
		}
	}
	public void AllProducts() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("from ItemBill");
		//query.setParameter("c",itemid);
		List<BillItemDTO> list=query.list();
		for(BillItemDTO emp:list) {
			System.out.println(emp.getItemId()+":"+emp.getQuantity()+":"+emp.getSno());
		}
	}
	public Long BillNo() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("select count(BillNo) from BillNos ");
		List<Long> list=query.list();
		for(Long emp:list) {
			System.out.println(emp);
			return emp;
		}
		return (long) 0;
	}
	public void ItemNo() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("select count(sno) from ItemBill ");
		List<Long> list=query.list();
		for(Long emp:list) {
			System.out.println(emp);
		}
	}
	
	public void AddItemsInvoice(BillNoDTO bill,List<BillItemDTO> items) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(bill);
		for(BillItemDTO o:items) {
			session.save(o);
			
		}
		
		
		
		
		tx.commit();
		
	}
}
