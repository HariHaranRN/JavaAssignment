package customerPackage;

public class CustomerBusinessImpl implements CustomerInerface{
	CustomerDAOImpl obj=new CustomerDAOImpl();
	@Override
	public CustomerDTO checkCustomer(String CustomerName, String CustomerMobile) {
		// TODO Auto-generated method stub
		CustomerDTO ob=obj.findCustomerByMobile(CustomerMobile);
		if(ob==null) {
			ob=obj.insertCustomer(CustomerName, CustomerMobile);
			return ob;
		}
		else {
			return ob;
		}
		
		
	}
	
}
