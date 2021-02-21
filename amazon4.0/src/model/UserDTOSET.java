package model;


import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class UserDTOSET {
	
public static void main(String[] args)throws Exception {
	//SessionFactory fac=new Configuration().configure().buildSessionFactory();
	
	SessionFactory factory = 
		new AnnotationConfiguration().configure().buildSessionFactory();
	
	Session session=factory.openSession();
	Transaction tx=session.beginTransaction();
	
	UserDataUtility employee1=new UserDataUtility();
	employee1.setId(201);
	employee1.setName("Sarath");
	employee1.setPassword("1234");
	employee1.setStatus(0);
	session.save(employee1);		
	tx.commit();
	session.close();
	
	
}
}
