package customerPackage;

public class CustomerBusinessImpl implements CustomerInerface{
	
	CustomerLoginQuery dao=new CustomerLoginQuery();
	@Override
	public String checkCustomer(String CustomerName, String CustomerMobile) {
		// TODO Auto-generated method stub
		String ob=dao.getCustomer(CustomerName, CustomerMobile);
		if(ob==null) {
			dao.CustomerLogin(CustomerName, CustomerMobile);;
			return CustomerName;
		}
		else {
			return ob;
		}
		
		
	}
	
}
