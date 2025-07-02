package com.dealer.pojo;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class CartItem 
{
    @NotNull(message="Id should not be null")
	@Min(value=1,message="Id should not be negative and zero")
	private int itemid;
	
	@NotNull(message="Items should not be null")
	private CropDetails items;
	
    @NotNull(message="Quantity should not be null")
	private float quantity;
	
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public CartItem(
			@NotNull(message = "Id should not be null") @Min(value = 1, message = "Id should not be negative and zero") int itemid,
			@NotNull(message = "Items should not be null") CropDetails items,
			@NotNull(message = "Quantity should not be null") float quantity) 
	{
		super();
		
		this.itemid = itemid;
		this.items = items;
		this.quantity = quantity;
	}


	public int getItemid() {
		return itemid;
	}


	public void setItemid(int itemid) {
		this.itemid = itemid;
	}


	public  CropDetails getItems() {
		return items;
	}

	public void setItems(CropDetails items) {
		this.items = items;
	}


	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Cart [ itemid=" + itemid + ", items=" + items + ", quantity=" + quantity
				+ "]";
	}

	

}