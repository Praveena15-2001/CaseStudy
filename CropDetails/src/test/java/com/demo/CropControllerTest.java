package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cropdetails.control.Controller;
import com.cropdetails.exception.CropNotFoundException;
import com.cropdetails.pojo.CropDetails;
import com.cropdetails.service.CropDetailsImpl;

@SpringBootTest
public class CropControllerTest 
{
@MockBean  
private CropDetailsImpl service;



@Autowired 
private Controller control;

String token = "token";

@Test public void ShowAllCropsTest() 
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
	when(service.showallCrops()).thenReturn(crops);
	
	assertEquals(1, control.showallcrops(token).getBody().size());

}

@Test public void ShowCropByIdTest() throws CropNotFoundException 
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

	when(service.showcropbyId(1)).thenReturn(c);
	
	assertEquals(c, control.showcropbyId(1,token).getBody()); 
	
}


@Test public void addCropTest() throws CropNotFoundException 
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

	when(service.addCrop(c)).thenReturn(c);
	
	assertEquals(c, control.addCrop(c,token).getBody());

}

@Test public void updateCropTest() throws CropNotFoundException 
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
	
	when(service.updateCrop(c)).thenReturn(c);
	
	assertEquals(c, control.updateCrop(c,token).getBody());

}

@Test public void deleteFarmerTest() throws CropNotFoundException 
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

	when(service.deleteCrop(1)).thenReturn("Deleted");
	
	assertEquals("Deleted", control.deleteCrop(1,token).getBody());


}








}