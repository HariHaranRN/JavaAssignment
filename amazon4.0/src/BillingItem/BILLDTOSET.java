package BillingItem;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BILLDTOSET {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session=factory.openSession();
			Transaction tx=session.beginTransaction();
			
			BillNoDTO bill=new BillNoDTO();
			bill.setCustomerMobile("98");
			bill.setDate(new Date());
			
			BillItemDTO item=new BillItemDTO();
			item.ItemId=1;
			item.Quantity=10;
			item.setBill(bill);
			BillItemDTO item1=new BillItemDTO();
			item1.ItemId=2;
			item1.Quantity=5;
			item1.setBill(bill);

			session.save(bill);
			session.save(item);
			session.save(item1);
			
			tx.commit();
			
			
	}
}
