package BillingItem;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity(name="BillNos")


@Table(name="BillNo")
public class BillNoDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int BillNo;
	private Date date;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	private String CustomerMobile;
	
	
//	@OneToMany(cascade={CascadeType.ALL},
//			fetch=FetchType.LAZY,mappedBy = "ItemBill")
//	public Set<BillItemDTO> addresses=new HashSet<BillItemDTO>(0);
//	public Set<BillItemDTO> getAddresses() {
//		return addresses;
//	}
//	public void setAddresses(Set<BillItemDTO> addresses) {
//		this.addresses = addresses;
//	}
	
}
