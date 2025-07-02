package com.payment.model;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="bill")
public class Invoice 
{
	@Id
	@NotNull(message="Id should not be null")
	private String billid;
	@NotNull(message="Date should not be null")
	private LocalDate date;
	@NotNull(message="Quantity should not be Null")
	private float quantity;
	@NotNull(message="Id should not be null")
	private String  dealerid;
	@NotBlank(message="Transaction Id should not be blank")
	private String transId;
	@NotEmpty(message="CropDetails should not be Empty")
	private List<CropDetails> crops;
	@NotBlank(message="price should not be blank")
	private String totprice;
	
	
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Invoice(  String billid, LocalDate date, float quantity, String dealerid, String transId, List<CropDetails> crops, String totprice) 
	{
		super();
		this.billid = billid;
		this.date = date;
		this.quantity = quantity;
		this.dealerid = dealerid;
		this.transId = transId;
		this.crops = crops;
		this.totprice = totprice;
	}
	
	

	public String getTotprice() {
		return totprice;
	}

	public void setTotprice(String totprice) {
		this.totprice = totprice;
	}

	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public String getBillid() {
		return billid;
	}
	public void setBillid(String billid) {
		this.billid = billid;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public String getDealerid() {
		return dealerid;
	}
	public void setDealerid(String dealerid) {
		this.dealerid = dealerid;
	}
	public List<CropDetails> getCrops() {
		return crops;
	}
	public void setCrops(List<CropDetails> crops) {
		this.crops = crops;
	}

	@Override
	public String toString() {
		return "Bill [billid=" + billid + ", date=" + date + ", quantity=" + quantity + ", dealerid=" + dealerid
				+ ", transId=" + transId + ", crops=" + crops + ", totprice=" + totprice + "]";
	}
	
	
}
