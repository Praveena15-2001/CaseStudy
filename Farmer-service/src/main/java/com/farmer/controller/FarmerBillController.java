package com.farmer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmer.client.Farmer_BillClient;
import com.farmer.exception.BillNotFoundException;
import com.farmer.pojo.Invoice;

@RestController
@RequestMapping("/farmer")
public class FarmerBillController 
{
	@Autowired
	private Farmer_BillClient invoiceClient;
	
	@GetMapping("/invoice")
	public ResponseEntity<List<Invoice>> showAllinvoice(@RequestHeader("Authorization") String token) 
	{
		return invoiceClient.showAllBill(token);
	}
		
	@GetMapping("/invoice/{id}")
	 public ResponseEntity<Invoice> showInvoiceById(@PathVariable("id") String id, @RequestHeader("Authorization") String token) throws BillNotFoundException
	{
		 return invoiceClient.showBillbyId(id, token);
	}
	}



