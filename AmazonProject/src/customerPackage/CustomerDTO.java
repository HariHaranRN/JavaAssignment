package customerPackage;

public class CustomerDTO {
	private String CustomerName,CustomerMobile;
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerMobile() {
		return CustomerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		CustomerMobile = customerMobile;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	private int CustomerId;
}
