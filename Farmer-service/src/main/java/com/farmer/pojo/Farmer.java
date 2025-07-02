package com.farmer.pojo;

import java.util.List;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="farmer")
public class Farmer {
	@Id
	@NotNull(message="Id should not be null")
	@Min(value=1,message="Id should not be negative and zero")
	private long farmerid;
	
	@NotBlank(message="name should not be blank")
	private String farmerName;
	
	@NotBlank(message="contact should not be blank")
	private String farmerContact;
	
	@NotNull(message="Address should not be Null")
	private Address address;
	
	@NotBlank(message="Email should not be blank")
	private String farmerEmail;
	
	@NotBlank(message="Image source link should not be blank")
	private String farmerImg;
	
	@NotBlank(message="about should not be Blank")
	private String farmerAbout;
	
	
	private List<CropDetails> cropdetails;
	
	public Farmer() { 
		super(); 
		// TODO Auto-generated constructor stub
	}
	public Farmer(long farmerid, String farmerName, String farmerContact, Address address, String farmerEmail,
			String farmerImg, String farmerAbout, List<CropDetails> cropdetails) {
		super();
		this.farmerid = farmerid;
		this.farmerName = farmerName;
		this.farmerContact = farmerContact;
		this.address = address;
		this.farmerEmail = farmerEmail;
		this.farmerImg = farmerImg;
		this.farmerAbout = farmerAbout;
		this.cropdetails = cropdetails;
	}
	public long getFarmerid() {
		return farmerid;
	}
	public void setFarmerid(long farmerid) {
		this.farmerid = farmerid;
	}
	public String getFarmerName() {
		return farmerName;
	}
	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}
	public String getFarmerContact() {
		return farmerContact;
	}
	public void setFarmerContact(String farmerContact) {
		this.farmerContact = farmerContact;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getFarmerEmail() {
		return farmerEmail;
	}
	public void setFarmerEmail(String farmerEmail) {
		this.farmerEmail = farmerEmail;
	}
	public String getFarmerImg() {
		return farmerImg;
	}
	public void setFarmerImg(String farmerImg) {
		this.farmerImg = farmerImg;
	}
	public String getFarmerAbout() {
		return farmerAbout;
	}
	public void setFarmerAbout(String farmerAbout) {
		this.farmerAbout = farmerAbout;
	}
	public List<CropDetails> getCropdetails() {
		return cropdetails;
	}
	public void setCropdetails(List<CropDetails> cropdetails) {
		this.cropdetails = cropdetails;
	}
	@Override
	public String toString() {
		return "Farmer [farmerid=" + farmerid + ", farmerName=" + farmerName + ", farmerContact=" + farmerContact
				+ ", address=" + address + ", farmerEmail=" + farmerEmail + ", farmerImg=" + farmerImg
				+ ", farmerAbout=" + farmerAbout + ", cropdetails=" + cropdetails + "]";
	}
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
