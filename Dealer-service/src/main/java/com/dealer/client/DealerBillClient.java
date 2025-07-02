package com.dealer.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.dealer.exception.BillNotFoundException;
import com.dealer.pojo.Invoice;


@FeignClient(name="bill-service",url="http://localhost:2006/bill")
public interface DealerBillClient
{
	
	@GetMapping("/")
	public ResponseEntity<List<Invoice>> showAllBill(@RequestHeader("Authorization") String token);
	
	@GetMapping("/{id}")
	public ResponseEntity<Invoice> showBillbyId(@PathVariable String id, @RequestHeader("Authorization") String token) throws BillNotFoundException;
	
	@PostMapping("/addbill")
	public ResponseEntity<Invoice> addBill(@RequestBody Invoice invoice, @RequestHeader("Authorization") String token)
			throws BillNotFoundException;
	
	@PutMapping("/updatebill")
	public ResponseEntity<Invoice> updateBill(@RequestBody Invoice invoice,
			@RequestHeader("Authorization") String token) throws BillNotFoundException;
	
	@DeleteMapping("/deletebill/{id}")
	public ResponseEntity<String> deleteBill(@PathVariable String id, @RequestHeader("Authorization") String token)
			throws BillNotFoundException;
	
	
	

}
