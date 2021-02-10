package ItemPackage;

public class ItemDTO {
	private int ItemId[],Price[];
	private String ItemDescription[],Unit[],ItemImage[];
	public int[] getItemId() {
		return ItemId;
	}
	public void setItemId(int[] itemId) {
		ItemId = itemId;
	}
	public int[] getPrice() {
		return Price;
	}
	public void setPrice(int[] price) {
		Price = price;
	}
	public String[] getItemDescription() {
		return ItemDescription;
	}
	public void setItemDescription(String[] itemDescription) {
		ItemDescription = itemDescription;
	}
	public String[] getUnit() {
		return Unit;
	}
	public void setUnit(String[] unit) {
		Unit = unit;
	}
	public String[] getItemImage() {
		return ItemImage;
	}
	public void setItemImage(String[] itemImage) {
		ItemImage = itemImage;
	}
}
