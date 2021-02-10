package customerPackage;

public abstract class CustomerDAO {
	public abstract CustomerDTO insertCustomer(String CustomerName,String CustomerMobile);
	public abstract CustomerDTO findCustomerByMobile(String CustomerMobile);
}
