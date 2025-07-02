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

import com.dealer.exception.DealerNotFoundException;
import com.dealer.pojo.Address;
import com.dealer.pojo.CropDetails;
import com.dealer.pojo.Dealer;
import com.dealer.repo.DealerRepo;
import com.dealer.service.DealerServiceImpl;



@SpringBootTest
class DealerServiceApplicationTests 
{
	@Autowired
	private DealerServiceImpl service;
	
	@MockBean
	DealerRepo repo;

	List<CropDetails> crops; 
	

	@Test
	public void ShowAllDealerTest()  
	{
		List<Dealer> dealer = new ArrayList<>();
 
		Dealer d = new Dealer();
		
		d.setDealerid(1);
		d.setDealerName("monasri");
		d.setDealerimg("image");
		d.setDealerEmail("mona@gmail.com");
		d.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
		d.setDealerContact("12345");
		d.setDealerabout("abc");
	    dealer.add(d);
		when(repo.findAll()).thenReturn(dealer);
		assertEquals(1, service.showallDealer().size());
	}
	
	@Test
	public void ShowDealerByIdTest() throws DealerNotFoundException {
		Dealer d = new Dealer();
		d.setDealerid(1);
		d.setDealerName("mona");
	    d.setDealerimg("image");
		d.setDealerEmail("mona@gmail.com");
		d.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
		d.setDealerContact("12345");
		d.setDealerabout("abc");
		
		Optional<Dealer> dealer = Optional.of(d);

		when(repo.findById((long) 1)).thenReturn(dealer);
		assertEquals(d, service.showdealerbyId(1));
	}
	
	
	@Test
	public void addDealerTest() throws DealerNotFoundException
	{
		Dealer d = new Dealer();
		d.setDealerid(3);
		d.setDealerName("Gomathi");
		d.setDealerimg("image");
		d.setDealerEmail("goms@gmail.com");
		d.setAddress(new Address("5", "135th Street", "mgr nagar", "chennai", "tamil nadu", "123489"));
		d.setDealerContact("7889573893");
		d.setDealerabout("abc");
		
		
		Optional<Dealer> dealer = Optional.of(d);
        when(repo.findById((long) 1)).thenReturn(dealer);
        when(repo.insert(d)).thenReturn(d);
		assertEquals(d, service.addDealer(d));
	}
	
	

	@Test
	public void updateDealerTest() throws DealerNotFoundException {
		Dealer d1 = new Dealer();
		d1.setDealerid(1);
		d1.setDealerName("mona");
		d1.setDealerimg("image");
		d1.setDealerEmail("mona@gmail.com");
		d1.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
		d1.setDealerContact("12345");
		d1.setDealerabout("abc");
		
		
		Dealer d2 = new Dealer();
		d2.setDealerid(1);
		d2.setDealerName("mona sri");
		d2.setDealerimg("image");
		d2.setDealerEmail("mona@gmail.com");
		d2.setAddress(new Address("5", "135th Street", "mgr nagar", "chennai", "tamil nadu", "123456"));
		d2.setDealerContact("12345");
		d2.setDealerabout("abc");
		

		Optional<Dealer> dealer = Optional.of(d1);

		when(repo.findById((long) 1)).thenReturn(dealer);
		when(repo.save(d2)).thenReturn(d2);
		assertEquals(d2, service.updateDealer(d2));
	}
	
	@Test
    public void deleteDealerTest() throws DealerNotFoundException {
        Dealer d = new Dealer();
    
        d.setDealerid(1);
        d.setDealerName("vasavi");
        d.setDealerimg("image");
        d.setDealerEmail("vasavi@gmail.com");
        d.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
        d.setDealerContact("12345"); 
        d.setDealerabout("abc");
       
        Optional<Dealer> dealer = Optional.of(d);
        when(repo.findById((long) 1)).thenReturn(dealer);
        assertEquals("Deleted Successfully",service.deleteDealer(1));
    }
	
	
}


