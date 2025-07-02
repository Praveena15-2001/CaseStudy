package com.cropdetails.control;

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

import com.cropdetails.exception.CropNotFoundException;
import com.cropdetails.pojo.CropDetails;
import com.cropdetails.service.AdminAuthService;
import com.cropdetails.service.CropDetailsImpl;
import com.cropdetails.service.DealerAuthService;
import com.cropdetails.service.FarmerAuthService;
import com.cropdetails.service.SequenceDaoImpl;

@RestController
@RequestMapping("/cropdetails")
@CrossOrigin("http://localhost:4200")
public class Controller {
	@Autowired
	private CropDetailsImpl service;

	@Autowired
	private DealerAuthService dealerService;
 
	@Autowired
	private AdminAuthService adminService;

	@Autowired
	private FarmerAuthService farmerService;

	@Autowired
	private SequenceDaoImpl sequencedao;

	Logger log = LoggerFactory.getLogger(Controller.class);

	/**
	 * 
	 * @param token
	 * @return
	 */
	@GetMapping("/")
	public ResponseEntity<List<CropDetails>> showallcrops(@RequestHeader("Authorization") String token)

	{

		try {
			if ((adminService.isSessionValid(token)) || (dealerService.isSessionValid(token))) {

				List<CropDetails> crops = service.showallCrops();
				if (crops.isEmpty())
					return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
				else
					return new ResponseEntity<>(crops, HttpStatus.OK);
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
	 * @throws CropNotFoundException
	 */
	@GetMapping("/{id}")
	public ResponseEntity<CropDetails> showcropbyId(@PathVariable long id, @RequestHeader("Authorization") String token)
			throws CropNotFoundException

	{
		try {
			if ((adminService.isSessionValid(token)) || (dealerService.isSessionValid(token))|| (farmerService.isSessionValid(token))) {

				CropDetails crops = service.showcropbyId(id);
				if (crops != null)
					return new ResponseEntity<>(crops, HttpStatus.OK);
				else
					return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}
	}

	/**
	 * 
	 * @param crops
	 * @param token
	 * @return
	 * @throws CropNotFoundException
	 */
	@PostMapping("/addcrop")
	public ResponseEntity<CropDetails> addCrop(@RequestBody CropDetails crops 
	 ,@RequestHeader("Authorization") String token)throws CropNotFoundException

	{
		
		try {
			 if ((adminService.isSessionValid(token))||(farmerService.isSessionValid(token))) 		        {
	long seqid = sequencedao.getNextSequenceId(crops.getFarmerName());
		crops.setCropid(seqid);
		CropDetails c = service.addCrop(crops);

		if (c != null)
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}	throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
} catch (ResponseStatusException e) {
	throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
}
	}

	/**
	 * 
	 * @param crops
	 * @param token
	 * @return
	 * @throws CropNotFoundException
	 */
	@PutMapping("/updatecrop")
	public ResponseEntity<CropDetails> updateCrop(@RequestBody CropDetails crops,
			@RequestHeader("Authorization") String token) throws CropNotFoundException
	{

		try {
			if ((adminService.isSessionValid(token)) || (farmerService.isSessionValid(token))) {
				CropDetails c = service.updateCrop(crops);
				if (c != null)
					return new ResponseEntity<>(c, HttpStatus.OK);
				else
					return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
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
	 * @throws CropNotFoundException
	 */
	@DeleteMapping("/deletecrop/{id}")
	public ResponseEntity<String> deleteCrop(@PathVariable long id, @RequestHeader("Authorization") String token)
			throws CropNotFoundException

	{

		try {
			if ((adminService.isSessionValid(token)) || (farmerService.isSessionValid(token))) {

				String crops = service.deleteCrop(id);
				if (crops != null)
					return new ResponseEntity<>("Deleted", HttpStatus.OK);
				else
					return new ResponseEntity<>("Details Could not found", HttpStatus.NOT_FOUND);

			}
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}
	}

}
