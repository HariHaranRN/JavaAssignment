package customerPackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class CustomerDTOSET {
	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session=factory.openSession();
			Transaction tx=session.beginTransaction();
			CustomerDTO customer=new CustomerDTO();
			customer.setCustomerId(1);
			customer.setCustomerMobile("1234");
			customer.setCustomerName("mahi");
			session.save(customer);
			tx.commit();	
			session.close();
	}
}
