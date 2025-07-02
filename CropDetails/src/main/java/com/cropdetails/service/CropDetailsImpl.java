package com.cropdetails.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropdetails.exception.CropNotFoundException;
import com.cropdetails.pojo.CropDetails;
import com.cropdetails.repo.CropDetailsRepo;

@Service
public class CropDetailsImpl implements CropDetailsService
{
	@Autowired
	CropDetailsRepo repo;
	
	Logger log = LoggerFactory.getLogger(CropDetailsImpl.class);

	@Override
	public List<CropDetails> showallCrops() 
	{
		log.info("Show All Crops");
		List<CropDetails> crops = repo.findAll();
		log.debug("Crops{}", crops);
		log.info("End Show All Crops");
		return crops;
	}

    @Override
	public CropDetails showcropbyId(long id) throws CropNotFoundException 
		
    	{
    	    log.info("Show Crops By Id");
    		Optional<CropDetails> crops = repo.findById(id);
    		if (crops.isPresent()) 
    		{
    			log.debug("Crop By Id {}", crops);
    			log.info("End Show Crop By Id");
    			return crops.get();
    		}
    		else
    			return crops.orElseThrow(()-> new CropNotFoundException(id+"Crop doesnot exits"));
    	}

	

	@Override
	public CropDetails addCrop(CropDetails crops) throws CropNotFoundException 
	{
		
		log.info("Add Crop");
		Optional<CropDetails> c = repo.findById(crops.getCropid());
		if (c.isPresent()) 
		{
			return c.orElseThrow(()-> new CropNotFoundException("Crop already exists"));
		}
		else
			log.debug("The Crop Added is {}", crops);
	        log.info("Added Crop Successfully!");
	       return repo.insert(crops);
	}

	@Override
	public CropDetails updateCrop(CropDetails cropdetails) throws CropNotFoundException 
	{
		log.info("Start");
		Optional<CropDetails> f = repo.findById(cropdetails.getCropid());
		if (!f.isPresent()) 
		{
			
			return f.orElseThrow(()-> new CropNotFoundException("Crop Doesnot exists"));
		}
		else
			log.info("end");
	       return repo.save(cropdetails);
		
		
		
	}

	@Override
	public String deleteCrop(long id)throws CropNotFoundException 
	{

		log.info("Start");
		Optional<CropDetails> c = repo.findById(id);
		if (!c.isPresent()) 
		{
		    c.orElseThrow(()-> new CropNotFoundException("Crop Doesnot exists"));
		    return "Could not Delete";
		}
		else
		   {
			log.info("end");
		    repo.deleteById(id);
		    return "Deleted Successfully";
		   }
		
		}

}
