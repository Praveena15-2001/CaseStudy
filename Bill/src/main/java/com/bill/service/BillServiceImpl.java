package com.bill.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bill.exception.BillNotFoundException;
import com.bill.pojo.Invoice;
import com.bill.repo.BillRepo;

@Service
public class BillServiceImpl implements BillService
{
	
	@Autowired
	BillRepo repo;

	Logger log = LoggerFactory.getLogger(BillServiceImpl.class);
	
	@Override
	public List<Invoice> showAllBill() 
	{
		log.info("Show All Bill");
		List<Invoice> invoice  = repo.findAll();
		log.debug("Bill {}", invoice);
		log.info("End Show All Bill"); 
		return invoice;
		
	}
	@Override
	public Invoice showBillById(String id) throws BillNotFoundException
	{
		{
			log.info("Show Bill by ID ");
			Optional<Invoice> invoice = repo.findById(id);
			if (invoice.isPresent()) 
			{
				log.info("End Bill by Id");
				return invoice.get();
			}
			
			else
				return invoice.orElseThrow(()-> new BillNotFoundException(id+"Bill doesnot exits"));
		}

		
	}

	@Override
	public Invoice addBill(Invoice invoice) throws BillNotFoundException 
	{
	    log.info("Add Bill ");
		Optional<Invoice> b = repo.findById(invoice.getBillid());
		
		if (b.isPresent()) 
			 return b.orElseThrow(()-> new BillNotFoundException("Bill already exists"));
		else
			log.info("End Add Bill");
		    return repo.insert(invoice);
}

	@Override
	public Invoice updateBill(Invoice invoice) throws BillNotFoundException 
	{
		log.info("Update Bill");
		Optional<Invoice> b = repo.findById(invoice.getBillid());
		if (!b.isPresent()) 
		{
			
			return b.orElseThrow(()-> new BillNotFoundException("Bill Doesnot exists"));
		}
		else
			log.info("End Update Bill");
	       return repo.save(invoice);
		
	}

	@Override
	public String deleteBill(String id) throws BillNotFoundException 
	{
		log.info("Delete Bill By Id");
		Optional<Invoice> b = repo.findById(id);
		if (!b.isPresent()) 
		{
		    b.orElseThrow(()-> new BillNotFoundException("Bill Doesnot exists"));
		    return "Could not Delete";
		}
		else
		   {
			log.info("Delete Bill By Id");
		    repo.deleteById(id);
		    return "Deleted Successfully";
		   }
		
	}

	}
		


