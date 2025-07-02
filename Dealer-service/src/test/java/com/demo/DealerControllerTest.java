package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.dealer.control.Controller;
import com.dealer.exception.DealerNotFoundException;
import com.dealer.pojo.Address;
import com.dealer.pojo.Dealer;
import com.dealer.service.DealerAuthService;
import com.dealer.service.DealerServiceImpl;

@SpringBootTest

public class DealerControllerTest 
{
@MockBean 
private DealerServiceImpl service;

@MockBean
private DealerAuthService auth;

@Autowired 
private Controller control;

String token = "token";

@Test public void ShowAllDealerTest() 
{ 

	 
	List<Dealer> dealer = new ArrayList<>();
	Dealer d = new Dealer();
	
	d.setDealerid(1);
	d.setDealerName("raj");
	d.setDealerimg("image");
	d.setDealerContact("6789045670");
	d.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
	d.setDealerEmail("raj123@gmail.com");
	d.setDealerabout("abc");
	
	when(service.showallDealer()).thenReturn(dealer);
	when(auth.isSessionValid("token")).thenReturn(true);
	assertEquals(1, control.showallDealer(token).getBody().size());

}

@Test public void ShowDealerByIdTest() throws  DealerNotFoundException 
{
	 
	Dealer d = new Dealer();
	
	d.setDealerid(1);
	d.setDealerName("raj");
	d.setDealerimg("image");
	d.setDealerContact("6789045670");
	d.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
	d.setDealerEmail("raj123@gmail.com");
	d.setDealerabout("abc");
	

	when(service.showdealerbyId(1)).thenReturn(d);
	when(auth.isSessionValid("token")).thenReturn(true);
	assertEquals(d, control.showDealerbyId(1, token).getBody()); 
	
}


@Test public void addCropTest() throws DealerNotFoundException 
{
	
	Dealer d = new Dealer();
	
	d.setDealerid(1);
	d.setDealerName("raj");
	d.setDealerimg("image"); 
	d.setDealerContact("6789045670");
	d.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
	d.setDealerEmail("raj123@gmail.com");
	d.setDealerabout("abc");

	when(service.addDealer(d)).thenReturn(d);
	when(auth.isSessionValid("token")).thenReturn(true);
	assertEquals(d, control.addDealer(d, token).getBody());

}
 
@Test public void updateCropTest() throws DealerNotFoundException 
{
	
	Dealer d = new Dealer();
	
	d.setDealerid(1);
	d.setDealerName("raj");
	d.setDealerimg("image");
	d.setDealerContact("6789045670");
	d.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
	d.setDealerEmail("raj123@gmail.com");
	d.setDealerabout("abc");
	
	
	when(service.updateDealer(d)).thenReturn(d);
	when(auth.isSessionValid("token")).thenReturn(true);
	assertEquals(d, control.updateDealer(d, token).getBody());

}

@Test public void deleteFarmerTest() throws  DealerNotFoundException 
{ 
	
	Dealer d = new Dealer();
	
	d.setDealerid(1);
	d.setDealerName("raj");
	d.setDealerimg("image");
	d.setDealerContact("6789045670");
	d.setAddress(new Address("5", "135th Street", "mr nagar", "chennai", "tamil nadu", "123456"));
	d.setDealerEmail("raj123@gmail.com");
	d.setDealerabout("abc");

	when(service.deleteDealer(1)).thenReturn("Deleted");
	when(auth.isSessionValid("token")).thenReturn(true);
	assertEquals("Deleted", control.deleteDealer(1, token).getBody());


}








}