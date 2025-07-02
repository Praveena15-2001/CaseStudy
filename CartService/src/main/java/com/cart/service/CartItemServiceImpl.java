package com.cart.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.exception.CartItemNotFoundException;
import com.cart.model.CartItem;
import com.cart.repository.CartItemRepository;



@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemRepository cartItemRepo;

	Logger log = LoggerFactory.getLogger(CartItemServiceImpl.class);
	
	@Override
	public List<CartItem> showAllCartItems() {
		log.info("Show All CartItems Method Started");
		List<CartItem> carts = cartItemRepo.findAll();
		log.debug("Farmers are {} ", carts);
		log.info("Show All CartItems Method Ended");
		return carts;
	}

	@Override
	public CartItem showCartItemById(int id) throws CartItemNotFoundException{
		log.info("Show CartItem By Id Method Started");
		return cartItemRepo.findById(id).orElseThrow(()-> new CartItemNotFoundException("Farmer with the id "+id + " Doesn't Exists"));
	}

	@Override
	public CartItem addCartItem(CartItem cartItem) throws CartItemNotFoundException{
		log.info("Add CartItem Method Started");
		Optional<CartItem> c = cartItemRepo.findById(cartItem.getdealerid());
		if (!c.isPresent()) {
			return cartItemRepo.insert(cartItem);}
		else {
			log.info("Add CartItem Method Ended");
			return c.orElseThrow(() -> new CartItemNotFoundException("CartItem Already Exists"));}
	}

	@Override
	public CartItem updateCartItem(CartItem CartItem) throws CartItemNotFoundException{
		log.info("Update CartItem Method Started");
		Optional<CartItem> c = cartItemRepo.findById(CartItem.getdealerid());
		if (!c.isPresent())
			return c.orElseThrow(() -> new CartItemNotFoundException("CartItem with the id "+CartItem.getdealerid() + " Doesn't Exists"));
		log.info("Update CartItem Method Ended");
		return cartItemRepo.save(CartItem);
	}

	@Override
	public String deleteCartItem(int id) throws CartItemNotFoundException{
		log.info("Delete CartItem Method Started");
		Optional<CartItem> c = cartItemRepo.findById(id);
		if (!c.isPresent()) {
			c.orElseThrow(() -> new CartItemNotFoundException("CartItem with the id "+id+ " Doesn't Exists"));}
		else {
		  cartItemRepo.deleteById(id);
		  log.debug("Deleted SuccessFully {}", c);
		  log.info("Delete CartItem Method Ended");}
		return "Cart Item with the id "+id+" Deleted Successfully!";
	}

}
