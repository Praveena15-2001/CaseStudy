package com.payment.model;

import java.util.ArrayList;
import java.util.List;

public class Cart 
{
	List<CartItem> items = new ArrayList<>();

	public Cart() {
		super();
		
	}

	  public CartItem addItem(CartItem cartItem) {
	        items.add(cartItem);
	        return cartItem;
	    }

	    public List<CartItem> getItem() {
	        return items;
	    }

	    public boolean removeItem(CartItem item) {
	        return items.remove(item);
	    }

	    public void clearItems() {
	        items.clear();
	    }
	
	
}
