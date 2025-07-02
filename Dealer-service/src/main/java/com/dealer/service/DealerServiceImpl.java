package com.dealer.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealer.exception.DealerNotFoundException;
import com.dealer.pojo.Dealer;
import com.dealer.repo.DealerRepo;

@Service
public class DealerServiceImpl implements  DealerService
{
	@Autowired
	DealerRepo repo;
	
	Logger log = LoggerFactory.getLogger(DealerServiceImpl.class);

	@Override
	public List<Dealer> showallDealer()
	{
		log.info("Show All Dealers");
		List<Dealer> dealer = repo.findAll();
		log.debug("Dealer{}", dealer);
		log.info("End Show All Dealers");
		return dealer;
		 
	}
 
	@Override
	public Dealer showdealerbyId(long id) throws DealerNotFoundException
	{
		
		log.info("Show Dealer By Id");
		Optional<Dealer> dealer = repo.findById(id);
		if (!dealer.isEmpty()) 
		{
			
			return dealer.get();
		}
		else
			log.debug("Dealer By Id {}", dealer);
			log.info("End Show Dealer By Id");
			throw new DealerNotFoundException(id+"Dealer doesnot exits");
	}

	@Override
	public Dealer addDealer(Dealer dealer) throws DealerNotFoundException
	{
		log.info("Add Farmer");
		Optional<Dealer> d = repo.findById(dealer.getDealerid());
		if (d.isPresent()) 
		{
			return d.orElseThrow(()-> new DealerNotFoundException("Dealer already exists"));
		}
		else
			log.debug("The Dealer Added is {}", dealer);
		    log.info("Added Dealer Successfully!");
	        return repo.insert(dealer);
	}

	@Override
	public Dealer updateDealer(Dealer dealer)throws DealerNotFoundException
	{
		log.info("Update Farmer");
		Optional<Dealer> d = repo.findById(dealer.getDealerid());
		if (!d.isPresent()) 
		{
			
			return d.orElseThrow(()-> new DealerNotFoundException("Dealer Doesnot exists"));
		}
		else
			log.debug("The Dealer updated is {}", dealer);
		    log.info("Updated Dealer Successfully!");
	       return repo.save(dealer);
		
		
	}

	@Override
	public String deleteDealer(long id) throws DealerNotFoundException
	{
		log.info("Delete Dealer");		
		Optional<Dealer> d = repo.findById(id);
		if (!d.isPresent()) 
		{
		    d.orElseThrow(()-> new DealerNotFoundException("Dealer Doesnot exists"));
		    return "Could not Delete";
		}
		else
		   {
			log.info("Dealer Deleted Successfully!");
			log.debug("The Dealer ID deleted is {}",id);
		    repo.deleteById(id);
		    return "Deleted Successfully";
		   }
		
	}

	@Override
	public Dealer showDealerByName(String name) throws DealerNotFoundException {
		
		
		log.info("Show Farmer By Id");
		Optional<Dealer> d = repo.findBydealerName(name);
		if (d.isPresent()) 
		{
			log.debug("Farmer By Id {}", d);
			log.info("End Show Farmer By Id");
			return d.get();
		}
		
		else
			return d.orElseThrow(()-> new DealerNotFoundException(name+"Farmer doesnot exits"));
		
		
		
	} 
		
		
		
		
	}
	
	
	


