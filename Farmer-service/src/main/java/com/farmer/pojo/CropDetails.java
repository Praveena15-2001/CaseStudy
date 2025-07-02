package com.farmer.pojo;

import javax.validation.constraints.AssertTrue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



public class CropDetails {

	
	
	private Long cropid;
	@NotBlank(message = "name should not be blank")
	private String cropname;
	@NotBlank(message = "Image source link should not be blank")
	private String cropimg;
	@NotBlank(message = "type should not be blank")
	private String croptype;
	@NotNull(message = "Price should not be null")
	private double price;
	@NotNull(message = "Quantity should not be null")
	private int quantity;
	@AssertTrue
	private boolean available;
	
	@NotNull(message = "Address should not be Null")
	private String address;
	@NotBlank(message = "Description should not be Blank")
	private String description;
	@NotBlank(message = "contact should not be blank")
	private String contact;
	@NotBlank(message = "contact should not be blank")
	private String farmerName;

	public CropDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CropDetails( Long cropid,String cropname, String cropimg, String croptype, double price, int quantity,
			boolean available, String address, String description, String contact, String farmerName) {
		super();
		this.cropid=cropid;
		this.cropname = cropname;
		this.cropimg = cropimg;
		this.croptype = croptype;
		this.price = price;
		this.quantity = quantity;
		this.available = available;
		this.address = address;
		this.description = description;
		this.contact = contact;
		this.farmerName = farmerName;
	}

	public Long getCropid() {
		return cropid;
	}

	public void setCropid(Long cropid) {
		this.cropid = cropid;
	}



	
	public String getCropname() {
		return cropname;
	}
	

	public void setCropname(String cropname) {
		this.cropname = cropname;
	}

	public String getCropimg() {
		return cropimg;
	}

	public void setCropimg(String cropimg) {
		this.cropimg = cropimg;
	}

	public String getCroptype() {
		return croptype;
	}
	

	public void setCroptype(String croptype) {
		this.croptype = croptype;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}
	
	

	@Override
	public String toString() {
		return "CropDetails [cropid=" + ", cropname=" + cropname + ", cropimg=" + cropimg + ", croptype="
				+ croptype + ", price=" + price + ", quantity=" + quantity + ", available=" + available + ", address="
				+ address + ", description=" + description + ", contact=" + contact + ", farmerid=" + farmerName + "]";
	}

}