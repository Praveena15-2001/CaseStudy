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

import com.dealer.exception.CropNotFoundException;
import com.dealer.pojo.CropDetails;

@FeignClient(name="cropdetails-service",url="http://localhost:2003/cropdetails")
public interface Dealer_ViewClient 
{
	@GetMapping("/")
	public ResponseEntity<List<CropDetails>> showAllCrops();
	
	
	@GetMapping("/{id}")
	public ResponseEntity<CropDetails> showById(@PathVariable int id) throws CropNotFoundException;
	
	
	@PostMapping("/addcrop")
	 public ResponseEntity<CropDetails> addCrop(@RequestBody CropDetails crops) throws CropNotFoundException;
	

	@PutMapping("/updatecrop")
	public ResponseEntity<CropDetails> updateCrop(@RequestBody CropDetails crops ) throws CropNotFoundException;

	@DeleteMapping("/deletecrop/{id}")
	public ResponseEntity<String> deleteCrop(@PathVariable int id) throws CropNotFoundException;
	
	
	

}
