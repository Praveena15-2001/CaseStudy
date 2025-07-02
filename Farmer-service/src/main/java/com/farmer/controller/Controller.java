package com.farmer.controller;

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

import com.farmer.exception.FarmerNotFoundException;
import com.farmer.exception.SequenceException;
import com.farmer.pojo.Farmer;
import com.farmer.service.FarmerAdminAuthService;
import com.farmer.service.FarmerAuthService;
import com.farmer.service.FarmerServiceImpl;
import com.farmer.service.sequenceDao;

@RestController
@RequestMapping("/farmer")
@CrossOrigin("http://localhost:4200")
public class Controller {

	@Autowired
	private FarmerServiceImpl service;

	@Autowired 
	private FarmerAuthService farmerAuthService;
 
	@Autowired
	private FarmerAdminAuthService adminauthService;

	@Autowired
	private sequenceDao sequencedao;

	Logger log = LoggerFactory.getLogger(Controller.class);

	/** 
	 * 
	 * @param token
	 * @return
	 */
	@GetMapping("/")
	public ResponseEntity<List<Farmer>> showAllFarmer(@RequestHeader("Authorization") String token)

	{
		try {
			if (adminauthService.isSessionValid(token)) {
				List<Farmer> farmer = service.showAllFarmers();
				log.info("Show All Farmers");
				if (farmer.isEmpty())
					return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
				else
					log.debug("Farmers {}", farmer);
				log.info("End Show All Farmers");
				return new ResponseEntity<>(farmer, HttpStatus.OK);
			}
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}
	}

	/**
	 * 
	 * @param id
	 * @param token
	 * @return
	 * @throws FarmerNotFoundException
	 */

	@GetMapping("/{id}")
	public ResponseEntity<Farmer> showfarmerbyId(@PathVariable long id, @RequestHeader("Authorization") String token)
			throws FarmerNotFoundException

	{
		try {
			if ((adminauthService.isSessionValid(token)) || (farmerAuthService.isSessionValid(token))) {
				Farmer farmer = service.showFarmerById(id);
				log.info("Show Farmer By Id");
				if (farmer != null)

					return new ResponseEntity<>(farmer, HttpStatus.OK);
				else
					log.debug("Farmer By Id {}", farmer);
				log.info("End Show Farmer By Id");
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}
	}

	/**
	 * 
	 * @param farmer
	 * @param token
	 * @return
	 * @throws FarmerNotFoundException
	 */

	@PostMapping("/addfarmer")
	public ResponseEntity<Farmer> addFarmer( @RequestBody Farmer farmer, @RequestHeader("Authorization") String token)
			throws FarmerNotFoundException, SequenceException

	{

		try {
			if ((adminauthService.isSessionValid(token)) || (farmerAuthService.isSessionValid(token))) {
				
				long seqid = sequencedao.getNextSequenceId("farmer");
				
				farmer.setFarmerid(seqid);
				
				log.info("Add Farmer");

				Farmer f = service.addFarmer(farmer);
				if (f != null)
					return new ResponseEntity<>(f, HttpStatus.CREATED);
				log.debug("The Farmer Added is {}", farmer);
				log.info("Added Farmer Successfully!");
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}
	}

	/**
	 * 
	 * @param farmer
	 * @param token
	 * @return
	 * @throws FarmerNotFoundException
	 */
	@PutMapping("/updatefarmer")
	public ResponseEntity<Farmer> updateFarmer(@RequestBody Farmer farmer, @RequestHeader("Authorization") String token)
			throws FarmerNotFoundException

	{
		try {
			if ((farmerAuthService.isSessionValid(token)) || (adminauthService.isSessionValid(token))) {

				Farmer f = service.updateFarmer(farmer);
				if (f != null)
					return new ResponseEntity<>(f, HttpStatus.OK);
				log.debug("The Farmer updated is {}", farmer);
				log.info("Updated farmer Successfully!");
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}
	}

	/**
	 *  
	 * @param id
	 * @param token
	 * @return
	 * @throws FarmerNotFoundException
	 */
	@DeleteMapping("/deletefarmer/{id}")
	public ResponseEntity<String> deleteFarmer(@PathVariable long id, @RequestHeader("Authorization") String token)
			throws FarmerNotFoundException

	{

		try {
			if (adminauthService.isSessionValid(token)) {
				log.info("Delete Farmer");
				String farmer = service.deleteFarmer(id);
				if (farmer != null)
					return new ResponseEntity<>("Deleted", HttpStatus.OK);
				else
					log.info("Deleted Successfully!");
				log.debug("The Farmer ID deleted is {}", id);
				return new ResponseEntity<>("Could not found", HttpStatus.NOT_FOUND);
			}
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}

	}

	@GetMapping("/farmername/{name}")
	public ResponseEntity<Farmer> getFarmerByName(@PathVariable("name") String name
			,
			@RequestHeader("Authorization") String token
			) throws FarmerNotFoundException
 
	{
		try {
			if ((adminauthService.isSessionValid(token)) || (farmerAuthService.isSessionValid(token))) {

				Farmer f = service.showFarmerByName(name);
				if (f != null) {
					log.debug("Farmer: {}", f);
					return new ResponseEntity<>(f, HttpStatus.OK);
				}
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}

			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}

	}
}
