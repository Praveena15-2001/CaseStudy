package com.bill.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cart")
public class Cart 
{
	
	@NotBlank(message="Id should not be null")
	@Min(value=1,message="Id should not be negative and zero")
	@Id
	private int dealerid;
	
	@NotNull(message="Items should not be null")
	private CropDetails items;
	
	@NotNull(message="Quantity should not be null")
	private float quantity;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(
			@NotBlank(message = "Id should not be null") @Min(value = 1, message = "Id should not be negative and zero") int dealerid,
			@NotNull(message = "Items should not be null") CropDetails items,
			@NotNull(message = "Quantity should not be null") float quantity) {
		super();
		this.dealerid = dealerid;
		this.items = items;
		this.quantity = quantity;
	}

	public int getDealerid() {
		return dealerid;
	}

	public void setDealerid(int dealerid) {
		this.dealerid = dealerid;
	}

	public CropDetails getItems() {
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
		return "Cart [dealerid=" + dealerid + ", items=" + items + ", quantity=" + quantity + "]";
	}
	
	

}