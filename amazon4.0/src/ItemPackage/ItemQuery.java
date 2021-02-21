package ItemPackage;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import utility.HibernateUtility;

public class ItemQuery {
	public static void main(String[] args) {
		ItemQuery items=new ItemQuery();
		items.getItemByName("Apple");
		//System.out.println(items.getItemByName("Apple"));
		items.getItemById(1);
		items.UpdatePrice("Apple",500);
	}
	
	public ArraytemDTO getItems() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("select Price,ItemId,ItemDescription,ItemImage,Unit from Items");
		int total=query.list().size();
		int ItemId[]=new int[total];
		int Price[]=new int[total];
		String ItemDescription[]=new String[total];
		String Image[]=new String[total];
		String unit[]=new String[total];
		int i=0;
		Iterator<Object[]> obj=query.iterate();
		ArraytemDTO ss=new ArraytemDTO();
		while(obj.hasNext())
		{
			Object o[]=obj.next();
			
			Price[i]=(int)o[0];
			ItemId[i]=(int)o[1];
			ItemDescription[i]=(String) o[2];
			Image[i]=(String)o[3];
			unit[i]=(String)o[4];
			System.out.println(Price[i]+":"+ItemDescription[i]);
			i++;
		}
		ss.setItemId(ItemId);
		ss.setItemImage(Image);
		ss.setPrice(Price);
		ss.setUnit(unit);
		ss.setItemDescription(ItemDescription);
		return ss;
	}
	public void getItemByName(String Name) {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("select Price,Unit,ItemImage from Items where ItemDescription=:c");
		query.setParameter("c",Name);
		Iterator<Object[]> obj=query.iterate();
		while(obj.hasNext())
		{
			Object o[]=obj.next();
			System.out.println(o[0]+":"+o[1]+":"+o[2]);
		}	
		
	}
	public void CountItem() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("select count(ItemId) from Items ");
		List<Long> list=query.list();
		for(Long emp:list) {
			System.out.println(emp);
		}
	}
	public void getItemById(int Id) {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("select Price,Unit,ItemImage,ItemDescription from Items where ItemId=:c");
		query.setParameter("c",Id);
		Iterator<Object[]> obj=query.iterate();
		while(obj.hasNext())
		{
			Object o[]=obj.next();
			System.out.println(o[0]+":"+o[1]+":"+o[3]);
		}	
		
	}
	
	public void UpdatePrice(String Name,int price) {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery(" update Items set Price=:s where ItemDescription=:c");
		query.setParameter("c",Name);
		query.setParameter("s",price);
		int updateditems=query.executeUpdate();
		System.out.println(updateditems);
		session.beginTransaction().commit();
	}
	public void UpdateName(String Name,int ItemId) {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery(" update Items set ItemDescription=:s where ItemId=:c");
		query.setParameter("c",ItemId);
		query.setParameter("s",Name);
		int updateditems=query.executeUpdate();
		System.out.println(updateditems);
		session.beginTransaction().commit();
	}
	public void DeleteItem(int ItemId) {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery(" delete from Items  where ItemId=:c");
		query.setParameter("c",ItemId);
		int updateditems=query.executeUpdate();
		System.out.println(updateditems);
		session.beginTransaction().commit();
	}
	public void DeleteItemByName(String ItemName) {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery(" delete from Items  where ItemDescription=:c");
		query.setParameter("c",ItemName);
		int updateditems=query.executeUpdate();
		System.out.println(updateditems);
		session.beginTransaction().commit();
	}
	
}
