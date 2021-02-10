package customerPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utility.ConnectionUtility;

public class CustomerDAOImpl extends CustomerDAO{
	
	CustomerDTO obj=new CustomerDTO();
	@Override
	public CustomerDTO findCustomerByMobile(String CustomerMobile) {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtility.createConnection();
		try {

			PreparedStatement ps=con.prepareStatement("select * from Customer where CustomerMobile=?");	
			ps.setString(1,CustomerMobile);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
						String CustomerName=rs.getString("CustomerName");
						int Customerid=rs.getInt("CustomerId");	
						obj.setCustomerMobile(CustomerMobile);
						obj.setCustomerName(CustomerName);
						obj.setCustomerId(Customerid);
						return obj;
			}
			else {
				return null;
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			ConnectionUtility.closeConnection(null);
		}
	
	}
	@Override
	public CustomerDTO insertCustomer(String CustomerName, String CustomerMobile) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Customer Registered");
			int Id=CustomerDAOImpl.generatePrimaryKey()+1;
			
			
			Connection con=ConnectionUtility.createConnection();
			con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement("insert into Customer (CustomerId,CustomerName,CustomerMobile) values (?,?,?)");
			ps.setInt(1,Id);
			ps.setString(2,CustomerName);
			ps.setString(3,CustomerMobile);
			int rs=ps.executeUpdate();
			System.out.println("User Registered"+ps);
			obj.setCustomerMobile(CustomerMobile);
			obj.setCustomerName(CustomerName);
			obj.setCustomerId(Id);
			con.commit();
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
	public static int generatePrimaryKey() {
		Connection con=ConnectionUtility.createConnection();
		PreparedStatement ps3;
		try {
			ps3 = con.prepareStatement("select count(CustomerId) as count from Customer");
			ResultSet rs2=ps3.executeQuery();
			System.out.println(ps3);
			int count=0;
			if(rs2.next()) {
				count=rs2.getInt("count");
				return count;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionUtility.closeConnection(null);
		}
		
		
		return 0;
	}
}
