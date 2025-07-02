package com.dealer.control;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dealer.exception.DealerNotFoundException;
import com.dealer.pojo.Dealer;
import com.dealer.service.DealerAdminAuthService;
import com.dealer.service.DealerAuthService;
import com.dealer.service.DealerServiceImpl;
import com.dealer.service.SequenceDaoImpl;


@RestController
@CrossOrigin()
@RequestMapping("/dealer")
public class Controller 
{
	@Autowired 
	private DealerServiceImpl service;
	
	@Autowired
	private DealerAuthService authService;
	
	@Autowired
	private DealerAdminAuthService adminauthService;
	
	@Autowired 
	private SequenceDaoImpl sequencedao;
	
	 
	Logger log = LoggerFactory.getLogger(Controller.class);
	
	/**
	 * 
	 * @param token
	 * @return
	 */
	@GetMapping("/")
	public ResponseEntity<List<Dealer>> showallDealer(@RequestHeader("Authorization") String token)
			
	{
		try {
		 if (adminauthService.isSessionValid(token)) 
	        {
	        	
		
		List<Dealer> dealer = service.showallDealer();
		log.info("Show All Dealers");
		if(dealer.isEmpty())
		    return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		else
			log.debug("Dealers {}", dealer);
		    log.info("End Show All Dealers");
			return new ResponseEntity<>(dealer,HttpStatus.OK);
			}
	
    throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
} catch (ResponseStatusException e) {
    throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
}
	}

    /**
     * 
     * @param id
     * @param token
     * @return
     * @throws DealerNotFoundException
     */
	@GetMapping("/{id}")
	public ResponseEntity<Dealer> showDealerbyId(@PathVariable long id,@RequestHeader("Authorization") String token)throws DealerNotFoundException
			
			
	{
	
		try {
			 if ((adminauthService.isSessionValid(token))|| (authService.isSessionValid(token))) 
		        {
		
		
		Dealer dealer = service.showdealerbyId(id);
		
		log.info("Show Dealer By Id");
		if (dealer!=null) 
		    return new ResponseEntity<>(dealer,HttpStatus.OK);
		else
			log.debug("Dealer By Id {}", dealer);
            log.info("End Show Dealer By Id");
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
			 throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (ResponseStatusException e) {
		    throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}
			}
	
	/**
	 * 
	 * @param dealer
	 * @param token
	 * @return
	 * @throws DealerNotFoundException
	 */
	@PostMapping("/adddealer")
	 public ResponseEntity<Dealer> addDealer( @RequestBody Dealer dealer,@RequestHeader("Authorization") String token) throws DealerNotFoundException
			
	 {
			 
   {
		try {

        if ((adminauthService.isSessionValid(token)) || (authService.isSessionValid(token)))
        {
		long seqid = sequencedao.getNextSequenceId("dealer");
    	dealer.setDealerid(seqid);
		Dealer d = service.addDealer(dealer);
		log.info("Add Dealer");
		if(d!=null)
			 return new ResponseEntity<>(d,HttpStatus.CREATED);
		log.debug("The Dealer Added is {}", dealer);
		log.info("Added Dealer Successfully!");
	    return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
	       
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
    } catch (ResponseStatusException e) {
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
    }
    }
	 }
	
	/**
	 * 
	 * @param dealer
	 * @param token
	 * @return
	 * @throws DealerNotFoundException
	 */
	@PutMapping("/updatedealer")
	public ResponseEntity<Dealer> updateDealer( @RequestBody Dealer dealer,@RequestHeader("Authorization")String token)throws DealerNotFoundException
			
    {
		 try {
	        if ((adminauthService.isSessionValid(token)) || (authService.isSessionValid(token)))
	        {
		
		Dealer d = service.updateDealer(dealer);
		log.info("Update Dealer");
		if(d!=null)
			 return new ResponseEntity<>(d,HttpStatus.OK);
		else
		    log.debug("The Dealer updated is {}", dealer);
		    log.info("Updated Dealer Successfully!");
	        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		 } throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
    } catch (ResponseStatusException e) {
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
    }
    	}
		 
	/**
	 * 
	 * @param id
	 * @param token
	 * @return
	 * @throws DealerNotFoundException
	 */
	@DeleteMapping("/deletedealer/{id}")
	public ResponseEntity<String> deleteDealer(@PathVariable long id,@RequestHeader("Authorization")String token) throws DealerNotFoundException
			
{
		try {
		 if (adminauthService.isSessionValid(token)) 
	        {
		
		String dealer = service.deleteDealer(id);
		log.info("Delete Dealer");
		if (dealer!=null) 
		    return new ResponseEntity<>("Deleted",HttpStatus.OK);
		else
	        log.debug("The Dealer ID deleted is {}",id);
		    log.info("Deleted Successfully!");
			return new ResponseEntity<>("Could not found",HttpStatus.NOT_FOUND);
		}
		 throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
    } catch (ResponseStatusException e) {
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
    }
    	}
	
	@GetMapping("/dealername/{name}")
	public ResponseEntity<Dealer> getDealerByName(@PathVariable("name") String name,@RequestHeader("Authorization") String token) throws DealerNotFoundException
	{
		try {
	        if ((adminauthService.isSessionValid(token))  || (authService.isSessionValid(token)))
	        {
	        	 Dealer d = service.showDealerByName(name);
	        	 if (d != null) {
	        	 
	        	 return new ResponseEntity<>(d, HttpStatus.OK);
	        	 }
	        	 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	        }
	    	throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
	    	} catch (Exception e) 
	    		{
	    	    throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
	    	}
	    	
		}
	
	
	
	
	
	        
	
	
	
}
