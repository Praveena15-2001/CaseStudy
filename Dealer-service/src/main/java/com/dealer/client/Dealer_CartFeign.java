package com.dealer.client;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dealer.exception.CartNotFoundException;
import com.dealer.pojo.CartItem;


@FeignClient(name="cart-service",url="http://localhost:2004/item")
public interface Dealer_CartFeign 
{

	@GetMapping("/")
	public ResponseEntity<List<CartItem>> showallItem();
	
    @GetMapping("/{id}")
    public ResponseEntity<CartItem> showItembyId(@PathVariable int id) throws CartNotFoundException;
    
    
    @PostMapping("/additem")
	 public ResponseEntity<CartItem> addItem(@Valid @RequestBody CartItem cart) throws CartNotFoundException;
    
    @PutMapping("/updateitem")
	public ResponseEntity<CartItem> updateItem(@Valid @RequestBody CartItem cart ) throws CartNotFoundException;
	
    @DeleteMapping("/deleteitem/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable int id) throws CartNotFoundException;
	
	
}
