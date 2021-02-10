package ItemPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.ConnectionUtility;

public class ItemDAOImpl extends ItemDAO{

	ItemDTO obj=new ItemDTO();
	@Override
	public ItemDTO retriveItems() {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtility.createConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from Item");	
			ResultSet rs=ps.executeQuery();
			int ItemId[]=new int[3];
			int Price[]=new int[3];
			String ItemDescription[]=new String[3];
			String ItemImages[]=new String[3];
		
			int i=0;
			while(rs.next()) {
					System.out.println("times");
					int id=rs.getInt("ItemId");
					String ItemImage=rs.getString("ItemImage");
					int price=rs.getInt("Price");
					String Itemdescription=rs.getString("ItemDescription");
					System.out.println(id+":"+price+":"+ItemImage);
					ItemId[i]=id;
					ItemImages[i]=ItemImage;
					Price[i]=price;
					ItemDescription[i]=Itemdescription;		
					i++;
			}
			
			
			obj.setPrice(Price);
			obj.setItemId(ItemId);
			obj.setItemImage(ItemImages);
			obj.setItemDescription(ItemDescription);
			return obj;
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			ConnectionUtility.closeConnection(null);
		}
	
	}
}
