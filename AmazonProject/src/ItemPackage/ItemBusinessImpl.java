package ItemPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utility.ConnectionUtility;

public class ItemBusinessImpl implements ItemBusiness {
	ItemDAOImpl obj=new ItemDAOImpl();
	@Override
	public ItemDTO getItems() {
		// TODO Auto-generated method stub
		ItemDTO ss=obj.retriveItems();
		System.out.println(ss.getItemImage());
		return ss;
	}

}
