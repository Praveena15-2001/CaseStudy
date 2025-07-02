package com.cart.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cart")
public class CartItem {
	@Id
	@NotNull(message = " Id is Required")
	@Min(value = 1, message = "Id should not be Zero and Negative value")
	private int dealerid;
	@NotNull(message = "Crop Id is Required")
	private CropDetails crop;
	@NotNull(message = "Quantity is Required")
	@Min(value = 1, message = "Quantity should not be Zero and Negative value")
	private int quantity;

	public CartItem() {
		super();
	}

	public CartItem(int dealerid, CropDetails crop, int quantity) {
		super();
		this.dealerid = dealerid;
		this.crop = crop;
		this.quantity = quantity;
	}

	public int getdealerid() {
		return dealerid;
	}

	public void setdealerid(int dealerid) {
		this.dealerid = dealerid;
	}

	public CropDetails getCrop() {
		return crop;
	}

	public void setCrop(CropDetails crop) {
		this.crop = crop;
	}

	public int getquantity() {
		return quantity;
	}

	public void setquantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [dealerid=" + dealerid + ", crop=" + crop + ", quantity=" + quantity + "]";
	}

}
