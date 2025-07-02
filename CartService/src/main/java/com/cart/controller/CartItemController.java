package com.cart.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.cart.exception.CartItemNotFoundException;
import com.cart.model.CartItem;
import com.cart.service.CartAuthService;
import com.cart.service.CartItemServiceImpl;


@RestController
@RequestMapping("/item")
public class CartItemController {

	@Autowired
	private CartItemServiceImpl service;
	
	@Autowired
	private CartAuthService authService;
	
	Logger log = LoggerFactory.getLogger(CartItemController.class);
	
	@GetMapping("/")
	public ResponseEntity<List<CartItem>> showAllCartItems(@RequestHeader("Authorization") String token){
		try {
			if (authService.isSessionValid(token)) {
		List<CartItem> cartItems = service.showAllCartItems();
		if(cartItems.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		log.debug("CartItems are {}",cartItems);
		return new ResponseEntity<>(cartItems, HttpStatus.OK);
			}
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CartItem> showCartItemById(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws CartItemNotFoundException {
		try {
			if (authService.isSessionValid(token)) {
		CartItem order = service.showCartItemById(id);
		if(order!=null) {
			log.debug("CartItem: {}",order);
			return new ResponseEntity<>(order, HttpStatus.OK);}
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}
	}
	
	@PostMapping("/addCartItem")
	public ResponseEntity<CartItem> addCartItem(@Valid @RequestBody CartItem cartItem,@RequestHeader("Authorization") String token) throws CartItemNotFoundException {
		try {
			if (authService.isSessionValid(token)) {
		CartItem o = service.addCartItem(cartItem);
		if(o!=null) {
			log.debug("CartItem: {}",o);
			return new ResponseEntity<>(o, HttpStatus.CREATED);}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}
	}
	
	@PutMapping("/updateCartItem")
	public ResponseEntity<CartItem> updateCartItem(@Valid @RequestBody CartItem order,@RequestHeader("Authorization") String token) throws CartItemNotFoundException {
		try {
			if (authService.isSessionValid(token)) {
		CartItem o = service.updateCartItem(order);
		if(o!=null) {
			log.debug("CartItem: {}",o);
			return new ResponseEntity<>(o, HttpStatus.OK);}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}
		
	}
	
	@DeleteMapping("/deleteCartItem/{id}")
	public ResponseEntity<String> deleteCartItem(@PathVariable("id")int id,@RequestHeader("Authorization") String token)throws CartItemNotFoundException {
		try {
			if (authService.isSessionValid(token)) {
		service.deleteCartItem(id);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
			}
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		} catch (ResponseStatusException e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are Unauthorized!...");
		}
	}
}
