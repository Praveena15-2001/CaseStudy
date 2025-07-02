package com.bill.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bill.exception.BillNotFoundException;
import com.bill.pojo.Invoice;
import com.bill.service.BillServiceImpl;

@RestController
@RequestMapping("/bill")
@CrossOrigin()
public class Controller {
	@Autowired
	private BillServiceImpl service;

	

	Logger log = LoggerFactory.getLogger(Controller.class);

	@GetMapping("/")
	public ResponseEntity<List<Invoice>> showAllBill() {
			    log.info("Show All Bill");
				List<Invoice> invoice = service.showAllBill();
				if (invoice.isEmpty())
					return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
				else
					log.info("End Show All Bill");
				return new ResponseEntity<>(invoice, HttpStatus.OK);

			
	}

	@GetMapping("/{id}")
	public ResponseEntity<Invoice> showBillbyId(@PathVariable String id)
			throws BillNotFoundException {
		
				log.info("Show Bill by ID ");
				Invoice invoice = service.showBillById(id);
				if (invoice != null)
					return new ResponseEntity<>(invoice, HttpStatus.OK);
				else
					log.info("End Show Bill Id");
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			

	@PostMapping("/addbill")
	public ResponseEntity<Invoice> addBill(@RequestBody Invoice invoice)
			throws BillNotFoundException {
		
				log.info("Add Bill ");
				Invoice b = service.addBill(invoice);
				if (b != null)
					return new ResponseEntity<>(invoice, HttpStatus.CREATED);
				log.info("End Add Bill ");
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}

			

	@PutMapping("/updatebill")
	public ResponseEntity<Invoice> updateBill(@RequestBody Invoice invoice) throws BillNotFoundException {
		
				log.info("Update Bill ");
				Invoice b = service.updateBill(invoice);
				if (b != null)
					return new ResponseEntity<>(invoice, HttpStatus.OK);
				log.info("End Update Bill ");
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			

	@DeleteMapping("/deletebill/{id}")
	public ResponseEntity<String> deleteBill(@PathVariable String id)
			throws BillNotFoundException {
		
				log.info("Delete Bill ");
				String bill = service.deleteBill(id);
				if (bill != null)
					return new ResponseEntity<>("Deleted", HttpStatus.OK);
				else
					log.info("End Deleted Bill ");
				return new ResponseEntity<>("Could not found", HttpStatus.NOT_FOUND);
			}
			

}
