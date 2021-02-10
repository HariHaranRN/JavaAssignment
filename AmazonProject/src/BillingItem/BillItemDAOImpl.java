package BillingItem;

import java.sql.Connection;
import java.sql.PreparedStatement;

import customerPackage.CustomerDAOImpl;
import utility.ConnectionUtility;

public class BillItemDAOImpl implements BillItemDAO{
	BillItemDTO obj1=new BillItemDTO();
	@Override
	public int insertBillItem(int BillNo, int ItemId, int Quantity) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Item Bill Registered");			
			Connection con=ConnectionUtility.createConnection();
			con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement("insert into BillItem (BillNo,ItemNo,Quantity) values (?,?,?)");
			ps.setInt(1,BillNo);
			ps.setInt(2,ItemId);
			ps.setInt(3,Quantity);
			int rs=ps.executeUpdate();
			obj1.setBillNo(BillNo);
			obj1.setItemId(ItemId);
			obj1.setQuantity(Quantity);
			System.out.println("Bill Registered");

			con.commit();
			return 1;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		finally {
			ConnectionUtility.closeConnection(null);
		}
		
	}
}
