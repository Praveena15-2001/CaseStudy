package com.farmer.pojo;

import javax.validation.constraints.NotBlank;


public class Address 
{
//	@NotNull(message="HouseNo should not be null")
	private String houseno;
	@NotBlank(message="StreetName Should not be empty")
	private String streetname;
	@NotBlank(message="City Should not be empty")
	private String city;
	@NotBlank(message="District Should not be empty")
	private String district;
	@NotBlank(message="State Should not be empty")
	private String state;
	@NotBlank(message="Pincode Should not be empty")
	private String pincode;
	
	public String getHouseno() {
		return houseno;
	}
	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Address(String houseno, String streetname, String city, String district, String state, String pincode) {
		super();
		this.houseno = houseno;
		this.streetname = streetname;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "farmerAddress [houseno=" + houseno + ", streetname=" + streetname + ", city=" + city + ", district="
				+ district + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
}
