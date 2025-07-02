package com.farmer.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.farmer.controller.Controller;
import com.farmer.exception.FarmerNotFoundException;
import com.farmer.exception.SequenceException;
import com.farmer.pojo.Address;
import com.farmer.pojo.CropDetails;
import com.farmer.pojo.Farmer;
import com.farmer.service.FarmerAdminAuthService;
import com.farmer.service.FarmerAuthService;
import com.farmer.service.FarmerServiceImpl;

@SpringBootTest
public class FarmerControllerTest {

	@Autowired
	private Controller controller;
	@MockBean
	private FarmerServiceImpl farmerService;
	@MockBean
	private FarmerAdminAuthService authService;
	@MockBean
	private FarmerAuthService farmerauthService;

	List<CropDetails> crops = new ArrayList<>();
	String token = "token";

	@Test
	public void showAllFarmersControllerTest() {
		List<Farmer> farmers = new ArrayList<>();
		Farmer f = new Farmer();
		f.setFarmerid(1);
		f.setFarmerName("vasavi");
		f.setFarmerImg("image");
		f.setFarmerEmail("vasavi@gmail.com");
		f.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
		f.setFarmerContact("12345");
		f.setFarmerAbout("abc");
		f.setCropdetails(crops);
		farmers.add(f);
		when(farmerService.showAllFarmers()).thenReturn(farmers);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(1, controller.showAllFarmer(token).getBody().size());
	}

	@Test
	public void ShowFarmerByIdControllerTest() throws FarmerNotFoundException {
		Farmer f = new Farmer();
		f.setFarmerid(1);
		f.setFarmerName("vasavi");
		f.setFarmerImg("image");
		f.setFarmerEmail("vasavi@gmail.com");
		f.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
		f.setFarmerContact("12345");
		f.setFarmerAbout("abc");
		f.setCropdetails(crops);
		when(farmerService.showFarmerById(1)).thenReturn(f);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(f, controller.showfarmerbyId(1, token).getBody());
	}

	@Test
	public void addFarmerControllerTest() throws FarmerNotFoundException, SequenceException {
		Farmer f = new Farmer();
		f.setFarmerid(1);
		f.setFarmerName("vasavi");
		f.setFarmerImg("image");
		f.setFarmerEmail("vasavi@gmail.com");
		f.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
		f.setFarmerContact("12345");
		f.setFarmerAbout("abc");
		f.setCropdetails(crops);
		when(farmerService.addFarmer(f)).thenReturn(f);
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals(f, controller.addFarmer(f, token).getBody());
		;
	}

	@Test
	public void updateFarmerControllerTest() throws FarmerNotFoundException {
		Farmer f = new Farmer();
		f.setFarmerid(1);
		f.setFarmerName("vasavi");
		f.setFarmerImg("image");
		f.setFarmerEmail("vasavi@gmail.com");
		f.setAddress(new Address("5", "139th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
		f.setFarmerContact("12345");
		f.setFarmerAbout("abc");
		f.setCropdetails(crops);
		when(farmerService.updateFarmer(f)).thenReturn(f);
		when(farmerauthService.isSessionValid("token")).thenReturn(true);
		assertEquals(f, controller.updateFarmer(f, token).getBody());

	}

	@Test
	public void deleteFarmerControllerTest() throws FarmerNotFoundException {
		Farmer f = new Farmer();
		f.setFarmerid(1);
		f.setFarmerName("vasavi");
		f.setFarmerImg("image");
		f.setFarmerEmail("vasavi@gmail.com");
		f.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
		f.setFarmerContact("12345");
		f.setFarmerAbout("abc");
		f.setCropdetails(crops);
		when(farmerService.deleteFarmer(1)).thenReturn("Deleted");
		when(authService.isSessionValid("token")).thenReturn(true);
		assertEquals("Deleted", controller.deleteFarmer(1, token).getBody());
	}
}
