package BillPackage;

public class BillDTO {
	private int BillNo;
	public int getBillNo() {
		return BillNo;
	}
	public void setBillNo(int billNo) {
		BillNo = billNo;
	}
	public String getCustomerMobile() {
		return CustomerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		CustomerMobile = customerMobile;
	}
	private String CustomerMobile;
}
