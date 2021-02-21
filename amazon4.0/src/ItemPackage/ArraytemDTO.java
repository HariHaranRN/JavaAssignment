package ItemPackage;

import java.util.Arrays;

public class ArraytemDTO {
private int ItemId[],Price[];
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
public String[] getItemDescription() {
	return ItemDescription;
}
public void setItemDescription(String itemDescription[]) {
	ItemDescription = itemDescription;
}
private String ItemDescription[],Unit[],ItemImage[];
@Override
public String toString() {
	return "ArraytemDTO [ItemId=" + Arrays.toString(ItemId) + ", Price=" + Arrays.toString(Price) + ", ItemDescription="
			+ Arrays.toString(ItemDescription) + ", Unit=" + Arrays.toString(Unit) + ", ItemImage="
			+ Arrays.toString(ItemImage) + "]";
}

}
