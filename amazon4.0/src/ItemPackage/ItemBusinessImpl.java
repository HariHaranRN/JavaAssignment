package ItemPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utility.ConnectionUtility;

public class ItemBusinessImpl implements ItemBusiness {

	ItemQuery dao=new ItemQuery();
	@Override
	public ArraytemDTO getItems() {
		// TODO Auto-generated method stub
		ArraytemDTO ss=dao.getItems();
		System.out.println(ss.getItemImage());
		return ss;
	}

}
