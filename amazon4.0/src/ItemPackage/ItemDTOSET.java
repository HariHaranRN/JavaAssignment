package ItemPackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import model.UserDataUtility;

public class ItemDTOSET {
	public static void main(String[] args) {
		SessionFactory factory = 
				new AnnotationConfiguration().configure().buildSessionFactory();
			
			Session session=factory.openSession();
			Transaction tx=session.beginTransaction();
			
			ItemDTO items=new ItemDTO();
			items.setItemId(3);
			items.setItemDescription("Guava");
			items.setItemImage("images/Guava.jpg");
			items.setPrice(100);
			items.setUnit("Kg");
			session.save(items);		
			tx.commit();
			session.close();
	}
}
