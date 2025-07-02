package com.farmer.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.farmer.client.Farmer_CropClient;
import com.farmer.exception.CropNotFoundException;
import com.farmer.exception.FarmerNotFoundException;
import com.farmer.exception.SequenceException;
import com.farmer.pojo.CropDetails;
import com.farmer.pojo.Farmer;
import com.farmer.service.FarmerAdminAuthService;
import com.farmer.service.FarmerAuthService;
import com.farmer.service.FarmerServiceImpl;
import com.farmer.service.SequenceDaoImpl;


@RestController
@RequestMapping("/farmer")
@CrossOrigin("http://localhost:4200") 
public class Farmer_cropController {
	@Autowired
	private Farmer_CropClient  cropclient;

	@Autowired
	FarmerServiceImpl service;

	@Autowired
	FarmerAdminAuthService adminauthService;

	@Autowired
	FarmerAuthService authService;
	@Autowired
	private SequenceDaoImpl sequencedao;

	Logger log = LoggerFactory.getLogger(Farmer_cropController.class);

	/**
	 * 
	 * @param id
	 * @param crop
	 * @param token
	 * @return
	 * @throws CropNotFoundException
	 * @throws FarmerNotFoundException
	 */
	@PostMapping("/addcrop/{name}")
	public Farmer addCrop(@PathVariable("name") String name, @RequestBody CropDetails crop,
			@RequestHeader("Authorization") String token) throws CropNotFoundException, FarmerNotFoundException,SequenceException {
 
		long seqid = sequencedao.getNextSequenceId("crops");
		crop.setCropid(seqid);
		log.info("Add Crop to CropDetails");
		crop.setFarmerName(name);
		List<CropDetails> post = service.showFarmerByName(name).getCropdetails();
		if (post == null)
			post = new ArrayList<>();
		

		CropDetails addedcrop = cropclient.addCrop(crop,token).getBody();

		post.add(addedcrop);
		Farmer f = service.showFarmerByName(name);
		f.setCropdetails(post);

		log.info("Added Crop to CropDetails");
		return service.updateFarmer(f);

	}

	@PutMapping("/updatecrop/{name}")
	Farmer updateCrop(@PathVariable("name") String name, @RequestBody CropDetails crop, @RequestHeader("Authorization") String token) throws CropNotFoundException, FarmerNotFoundException 
	{
	log.info("update Crop from farmer");
	List<CropDetails> post = service.showFarmerByName(name).getCropdetails();
	Farmer f = service.showFarmerByName(name);
	int index = 0;
	for (int i = 0; i < post.size(); i++) 
	{
		if (post.get(i).getCropid() == crop.getCropid())
		{
			index = i;
			break;
		} 
		 
	
	}
	post.set(index, crop);
	
	f.setCropdetails(post);
	
	cropclient.updateCrop(crop,token);
	return service.updateFarmer(f);
	}
	@DeleteMapping("/deletecrop/{name}/{id}")
    String deleteCrop(@PathVariable String name,@PathVariable long id, @RequestHeader("Authorization") String token)
			throws CropNotFoundException, FarmerNotFoundException

	{

	   List<CropDetails> post = service.showFarmerByName(name).getCropdetails();
	   for(int i=0;i<post.size();i++)
	   {
		   if(post.get(i).getCropid()== id)
		   {
			   post.remove(i);
		   }
	   }
	   
	  Farmer f = service.showFarmerByName(name);
		f.setCropdetails(post);
		
		cropclient.deleteCrop(id,token);
		service.updateFarmer(f);
		return "deleted"; 
	
	   

				
	}
			
	}
	
	
