package com.farmer.client;

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

import com.farmer.exception.CropNotFoundException;
import com.farmer.pojo.CropDetails;

@FeignClient(name="cropdetails-service",url="http://localhost:2003/cropdetails")
public interface Farmer_CropClient 
{
	@GetMapping("/")
	public ResponseEntity<List<CropDetails>>showAllCrops(@RequestHeader("Authorization") String token);
	
	
	@GetMapping("/{id}")
	public ResponseEntity<CropDetails> showById(@PathVariable long id,@RequestHeader("Authorization") String token) throws CropNotFoundException;
	
	
	@PostMapping("/addcrop")
	 public ResponseEntity<CropDetails> addCrop(@RequestBody CropDetails crops,@RequestHeader("Authorization") String token ) throws CropNotFoundException;
			 

	@PutMapping("/updatecrop")
	public ResponseEntity<CropDetails> updateCrop(@RequestBody CropDetails crops,@RequestHeader("Authorization") String token) throws CropNotFoundException;

	@DeleteMapping("/deletecrop/{id}")
	public ResponseEntity<String> deleteCrop(@PathVariable long id,@RequestHeader("Authorization") String token) throws CropNotFoundException;
	
}
