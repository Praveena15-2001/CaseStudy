package com.dealer.pojo;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cropdetails")
public class CropDetails 
{
	@Id
	@NotNull(message="Id should not be null")
	@Min(value=1,message="Id should not be negative and zero")
	private int cropid;
	
	@NotBlank(message="name should not be blank")
	private String cropname;
	@NotBlank(message="Image source link should not be blank")
	private String cropimg;
	@NotBlank(message="type should not be blank")
	private String croptype;
	@NotNull(message="Price should not be null")
	private double price;
	@NotNull(message="Quantity should not be null")
	private int quantity;
	@AssertTrue
	private boolean available;
	@NotNull(message="Address should not be Null")
	private Address address;
	@NotBlank(message="Description should not be Blank")
	private String description;
	@NotBlank(message="contact should not be blank")
	private String contact;
	@NotNull(message="Id should  not be null")
	@Min(value=1,message="Id should not be negative and zero")
	private int farmerid;
	
	public CropDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CropDetails(int cropid, String cropname, String cropimg, String croptype, double price, int quantity,
			boolean available, Address address, String description, String contact, int farmerid) {
		super();
		this.cropid = cropid;
		this.cropname = cropname;
		this.cropimg = cropimg;
		this.croptype = croptype;
		this.price = price;
		this.quantity = quantity;
		this.available = available;
		this.address = address;
		this.description = description;
		this.contact = contact;
		this.farmerid = farmerid;
	}
	public int getCropid() {
		return cropid;
	}
	public void setCropid(int cropid) {
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getFarmerid() {
		return farmerid;
	}
	public void setFarmerid(int farmerid) {
		this.farmerid = farmerid;
	}
	
	@Override
	public String toString() {
		return "CropDetails [cropid=" + cropid + ", cropname=" + cropname + ", cropimg=" + cropimg + ", croptype="
				+ croptype + ", price=" + price + ", quantity=" + quantity + ", available=" + available + ", address="
				+ address + ", description=" + description + ", contact=" + contact + ", farmerid=" + farmerid + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}