package com.bill.service;

import java.util.List;

import com.bill.exception.BillNotFoundException;
import com.bill.pojo.Invoice;


public interface BillService 
{
	public List<Invoice> showAllBill();	
	public Invoice showBillById(String id) throws BillNotFoundException ;
	public  Invoice addBill(Invoice invoice) throws BillNotFoundException ;
	public Invoice updateBill(Invoice invoice)throws BillNotFoundException ;
	public String deleteBill(String id)throws BillNotFoundException ;
}
	
	
	


