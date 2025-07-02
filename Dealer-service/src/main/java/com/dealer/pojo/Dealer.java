
package com.dealer.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="dealer")
public class Dealer 
{
	@Id
	@NotNull(message="Id should not be null")
	@Min(value=1,message="Id should not be negative and zero")
	private long dealerid;
	@NotBlank(message="name should not be blank")
	private String dealerName;
	
	@NotBlank(message="Image source link should not be blank")
	private String dealerimg;
	
	@NotBlank(message="contact should not be blank")
	private String dealerContact;
	
	@NotNull(message="Address should not be Null")
	private Address address;
	
	@NotBlank(message="Email should not be blank")
	private String dealerEmail;
	
	@NotBlank(message="about should not be Blank")
	private String dealerabout; 
	
	public Dealer() {  
		super();
		// TODO Auto-generated constructor stub
	}
	public Dealer(long dealerid, String dealerName, String dealerimg, String dealerContact, Address address,
			String dealerEmail, String dealerabout) {
		super();
		this.dealerid = dealerid;
		this.dealerName = dealerName;
		this.dealerimg = dealerimg;
		this.dealerContact = dealerContact;
		this.address = address;
		this.dealerEmail = dealerEmail;
		this.dealerabout = dealerabout;
	}
	public long getDealerid() {
		return dealerid;
	}
	public void setDealerid(long dealerid) {
		this.dealerid = dealerid;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public String getDealerimg() {
		return dealerimg;
	}
	public void setDealerimg(String dealerimg) {
		this.dealerimg = dealerimg;
	}
	public String getDealerContact() {
		return dealerContact;
	}
	public void setDealerContact(String dealerContact) {
		this.dealerContact = dealerContact;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getDealerEmail() {
		return dealerEmail;
	}
	public void setDealerEmail(String dealerEmail) {
		this.dealerEmail = dealerEmail;
	}
	public String getDealerabout() {
		return dealerabout;
	}
	public void setDealerabout(String dealerabout) {
		this.dealerabout = dealerabout;
	}
	@Override
	public String toString() {
		return "Dealer [dealerid=" + dealerid + ", dealerName=" + dealerName + ", dealerimg=" + dealerimg
				+ ", dealerContact=" + dealerContact + ", address=" + address + ", dealerEmail=" + dealerEmail
				+ ", dealerabout=" + dealerabout + "]";
	}
	
	
	
	
	
}