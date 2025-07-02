package com.farmer.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.farmer.exception.FarmerNotFoundException;
import com.farmer.exception.SequenceException;
import com.farmer.pojo.Address;
import com.farmer.pojo.CropDetails;
import com.farmer.pojo.Farmer;
import com.farmer.repo.FarmerRepo;
import com.farmer.service.FarmerServiceImpl;

@SpringBootTest
class FarmerServiceApplicationTests {
	@Autowired
	private FarmerServiceImpl service;
	@MockBean
	private FarmerRepo farmerRepo;
	List<CropDetails> crops;

	@Test
	public void ShowAllFarmersServiceTest() { 
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
		when(farmerRepo.findAll()).thenReturn(farmers);
		assertEquals(1, service.showAllFarmers().size());
	}

	@Test
	public void ShowFarmerByIdServiceTest() throws FarmerNotFoundException {
		Farmer f = new Farmer();
		f.setFarmerid(1);
		f.setFarmerName("vasavi");
		f.setFarmerImg("image");
		f.setFarmerEmail("vasavi@gmail.com");
		f.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
		f.setFarmerContact("12345");
		f.setFarmerAbout("abc");
		f.setCropdetails(crops);
		Optional<Farmer> farmer = Optional.of(f);
		when(farmerRepo.findById(1l)).thenReturn(farmer);
		assertEquals(f, service.showFarmerById(1));
	}

	@Test
	public void addFarmerServiceTest() throws FarmerNotFoundException, SequenceException {
		Farmer f = new Farmer();
		f.setFarmerid(1);
		f.setFarmerName("vasavi");
		f.setFarmerImg("image");
		f.setFarmerEmail("vasavi@gmail.com");
		f.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
		f.setFarmerContact("12345");
		f.setFarmerAbout("abc");
		f.setCropdetails(crops);
		when(farmerRepo.insert(f)).thenReturn(f);
		assertEquals(f, service.addFarmer(f));
	}

	@Test
	public void updateFarmerServiceTest() throws FarmerNotFoundException {
		Farmer f1 = new Farmer();
		Farmer f = new Farmer();
		f1.setFarmerid(1);
		f1.setFarmerName("vasavi");
		f1.setFarmerImg("image");
		f1.setFarmerEmail("vasavi@gmail.com");
		f1.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
		f1.setFarmerContact("12345");
		f1.setFarmerAbout("abc");
		f1.setCropdetails(crops);
		f.setFarmerid(1);
		f.setFarmerName("vasavi");
		f.setFarmerImg("image");
		f.setFarmerEmail("vasavi@gmail.com");
		f.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
		f.setFarmerContact("12345");
		f.setFarmerAbout("abc");
		f.setCropdetails(crops); 
		Optional<Farmer> farmer = Optional.of(f1);
		when(farmerRepo.findById(1l)).thenReturn(farmer);
		when(farmerRepo.save(f)).thenReturn(f);
		assertEquals(f, service.updateFarmer(f));
	}

	@Test 
	public void deleteFarmerServiceTest() throws FarmerNotFoundException {
		Farmer f = new Farmer();
		f.setFarmerid(1);
		f.setFarmerName("vasavi");
		f.setFarmerImg("image");
		f.setFarmerEmail("vasavi@gmail.com");
		f.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
		f.setFarmerContact("12345");
		f.setFarmerAbout("abc");
		f.setCropdetails(crops); 
		Optional<Farmer> farmer = Optional.of(f);
		when(farmerRepo.findById(1l)).thenReturn(farmer);
		assertEquals("Deleted Successfully", service.deleteFarmer(1));
	}
}
