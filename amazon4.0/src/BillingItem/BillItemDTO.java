package BillingItem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="ItemBill")
@Table(name="ItemBills")
public class BillItemDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int sno;
	public int ItemId,Quantity;
	public int Price;

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getItemId() {
		return ItemId;
	}

	public void setItemId(int itemId) {
		ItemId = itemId;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	@ManyToOne()
	  @JoinColumn( name="BillNo" )
	public BillNoDTO bill;

	public BillNoDTO getBill() {
		return bill;
	}

	public void setBill(BillNoDTO bill) {
		this.bill = bill;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}
}
