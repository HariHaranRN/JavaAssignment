package BillPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import customerPackage.CustomerDAOImpl;
import utility.ConnectionUtility;

public class BillDAOImpl implements BillDAO{
	BillDTO obj=new BillDTO();
	@Override
	public int CreateBill(int BillNo, String CustomerMobile) {
		try {
			System.out.println("Billing Registered");
			Connection con=ConnectionUtility.createConnection();
			con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement("insert into Bill (BillNo,CustomerMobile) values (?,?)");
			ps.setInt(1,BillNo);
			obj.setBillNo(BillNo);
			ps.setString(2,CustomerMobile);
			obj.setCustomerMobile(CustomerMobile);
			int rs=ps.executeUpdate();
			System.out.println("Billing Registered"+ps);

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
	@Override
	public int BillNo() {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtility.createConnection();
		PreparedStatement ps3;
		try {
			ps3 = con.prepareStatement("select count(BillNo) as count from Bill");
			ResultSet rs2=ps3.executeQuery();
			System.out.println(ps3);
			int count=0;
			if(rs2.next()) {
				count=rs2.getInt("count");
				System.out.println("count"+count);
				return count;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		finally {
			ConnectionUtility.closeConnection(null);
			
		}
		return 0;
		
	}
}
