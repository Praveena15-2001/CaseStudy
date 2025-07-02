package com.farmer.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmer.exception.FarmerNotFoundException;
import com.farmer.exception.SequenceException;
import com.farmer.pojo.Farmer;
import com.farmer.repo.FarmerRepo;

/**
 * 
 * @author M.Praveena FarmerServiceImpl Class implements the methods of the
 *         Farmer service class.
 */
@Service
public class FarmerServiceImpl implements FarmerService {

	@Autowired
	FarmerRepo repo;

	Logger log = LoggerFactory.getLogger(FarmerServiceImpl.class);

	/** 
	 * This method is used to display all the farmers in a list
	 */ 
	@Override
	public List<Farmer> showAllFarmers() {
		log.info("Show All Farmers");
		List<Farmer> farmers = repo.findAll();
		log.debug("Farmers {}", farmers);
		log.info("End Show All Farmers"); 
		return farmers;

	}

	/**
	 * This method takes the Farmer ID as the parameter and display the details of
	 * the farmer
	 */
	@Override
	public Farmer showFarmerById(long id) throws FarmerNotFoundException {
		log.info("Show Farmer By Id");
		Optional<Farmer> farmer = repo.findById(id);
		if (farmer.isPresent()) {
			log.debug("Farmer By Id {}", farmer);
			log.info("End Show Farmer By Id");
			return farmer.get();
		}

		else
			return farmer.orElseThrow(() -> new FarmerNotFoundException(id + "Farmer doesnot exits"));
	}

	/**
	 * This will take the data through an object and adds new farmer data
	 */
	@Override
	public Farmer addFarmer(Farmer farmer) throws FarmerNotFoundException, SequenceException {
		log.info("Add Farmer");
		Optional<Farmer> f = repo.findById(farmer.getFarmerid());

		if (f.isPresent())
			return f.orElseThrow(() -> new FarmerNotFoundException("Farmer already exists"));
		else
			log.debug("The Farmer Added is {}", farmer);
		log.info("Added Farmer Successfully!");
		farmer.setCropdetails(null);
		return repo.insert(farmer);
	}

	/**
	 * This method will take the particular FarmerID and
	 */
	@Override
	public Farmer updateFarmer(Farmer farmer) throws FarmerNotFoundException {
		
		log.info("Update Farmer");
		Optional<Farmer> f = repo.findById(farmer.getFarmerid());
		if (!f.isPresent()) {

			return f.orElseThrow(() -> new FarmerNotFoundException("Farmer Doesnot exists"));
		} else
			log.debug("The Farmer updated is {}", farmer);
		log.info("Updated farmer Successfully!");
		return repo.save(farmer);

	}

	@Override
	public String deleteFarmer(long id) throws FarmerNotFoundException {
		log.info("Delete Farmer");
		Optional<Farmer> f = repo.findById(id);
		if (!f.isPresent()) {
			f.orElseThrow(() -> new FarmerNotFoundException("Farmer Doesnot exists"));
			return "Could not Delete";
		} else {
			log.info("Farmer Deleted Successfully!");
			log.debug("The Farmer ID deleted is {}", id);
			repo.deleteById(id);
			return "Deleted Successfully";
		}

	}
	
	@Override
	public Farmer showFarmerByName(String name) throws FarmerNotFoundException {
		log.info("Show Farmer By Name");
		Optional<Farmer> farmer = repo.findByfarmerName(name);
		System.out.println("farmer by name:"+farmer);
		if (farmer.isPresent()) {
			log.debug("Farmer By Name {}", farmer);
			log.info("End Show Farmer By Name");
			return farmer.get();
		}

		else
			return farmer.orElseThrow(() -> new FarmerNotFoundException(name + " Farmer doesnot exits"));
	}

	

}
