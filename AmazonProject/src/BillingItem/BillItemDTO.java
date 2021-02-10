package BillingItem;

public class BillItemDTO {
	private int BillNo,ItemId,Quantity;

	public int getBillNo() {
		return BillNo;
	}

	public void setBillNo(int billNo) {
		BillNo = billNo;
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

}
