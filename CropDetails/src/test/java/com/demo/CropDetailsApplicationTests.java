package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cropdetails.exception.CropNotFoundException;

import com.cropdetails.pojo.CropDetails;
import com.cropdetails.repo.CropDetailsRepo;
import com.cropdetails.service.CropDetailsService;


@SpringBootTest
class CropDetailsApplicationTests {

	@Autowired
	private CropDetailsService service;
	
	@MockBean
	CropDetailsRepo repo;

	List<CropDetails> crops;
	

	@Test
	public void ShowAllCropsTest() 
	{
		List<CropDetails> crops = new ArrayList<>();

		CropDetails c = new CropDetails();
		c.setCropid(1);
	    c.setCropname("potato");
	    c.setCropimg("img");
		c.setCroptype("vegetable");
		c.setPrice(89);
		c.setQuantity(1); 
		c.setAvailable(true);
		c.setAddress("cbe");
		c.setDescription("abc");
		c.setContact("6789435567");
		c.setFarmerName("chandru");
		crops.add(c);
		when(repo.findAll()).thenReturn(crops);
		assertEquals(1, service.showallCrops().size());
	}
	
	@Test
	public void ShowCropByIdTest() throws CropNotFoundException 
	{
		CropDetails c = new CropDetails();
		c.setCropid(1);
	    c.setCropname("potato");
	    c.setCropimg("img");
		c.setCroptype("vegetable");
		c.setPrice(89);
		c.setQuantity(1);
		c.setAvailable(true);
		c.setAddress("cbe");
		c.setDescription("abc");
		c.setContact("6789435567");
		c.setFarmerName("chandru");
		Optional<CropDetails> crops = Optional.of(c);

		when(repo.findById((long) 1)).thenReturn(crops);
		assertEquals(c, service.showcropbyId(1));
	}
	
	
	@Test
	public void addCropTest() throws CropNotFoundException
	{
		CropDetails c = new CropDetails();
		c.setCropid(1);
	    c.setCropname("potato");
	    c.setCropimg("img");
		c.setCroptype("vegetable");
		c.setPrice(89);
		c.setQuantity(1);
		c.setAvailable(true);
		c.setAddress("cbe");
		c.setDescription("abc");
		c.setContact("6789435567");
		c.setFarmerName("chandru");
		
		Optional<CropDetails> crops = Optional.of(c);
       when(repo.findById((long) 1)).thenReturn(crops);
        when(repo.insert(c)).thenReturn(c);
		assertEquals(c, service.addCrop(c));
	}
	
	 

	@Test
	public void updateCropTest() throws CropNotFoundException {
		CropDetails c = new CropDetails();
		c.setCropid(1);
	    c.setCropname("potato");
	    c.setCropimg("img");
		c.setCroptype("vegetable");
		c.setPrice(89);
		c.setQuantity(1);
		c.setAvailable(true);
		c.setAddress("cbe");
		c.setDescription("abc");
		c.setContact("6789435567");
		c.setFarmerName("chandru");
		
		CropDetails c1 = new CropDetails();
		c1.setCropid(1);
	    c1.setCropname("tomato");
	    c1.setCropimg("img");
		c1.setCroptype("vegetable");
		c1.setPrice(89);
		c1.setQuantity(1);
		c1.setAvailable(true);
		c.setAddress("cbe");
		c1.setDescription("abc");
		c1.setContact("6789435567");
		c1.setFarmerName("chandru");

		Optional<CropDetails> crops = Optional.of(c1);

		when(repo.findById((long) 1)).thenReturn(crops);
		when(repo.save(c1)).thenReturn(c1);
		assertEquals(c1, service.updateCrop(c));
	}
	
	@Test
    public void deleteCropTest() throws CropNotFoundException {
       
    
        CropDetails c = new CropDetails();
		c.setCropid(1);
	    c.setCropname("potato");
	    c.setCropimg("img");
		c.setCroptype("vegetable");
		c.setPrice(89);
		c.setQuantity(1);
		c.setAvailable(true);
		c.setAddress("cbe");
		c.setDescription("abc");
		c.setContact("6789435567");
		c.setFarmerName("chandru");
       
        Optional<CropDetails> crops = Optional.of(c);
       when(repo.findById((long) 1)).thenReturn(crops);
        assertEquals("Deleted Successfully",service.deleteCrop(1));
    }
	
	
}
