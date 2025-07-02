package com.cart.service;

import java.util.List;

import com.cart.exception.CartItemNotFoundException;
import com.cart.model.CartItem;

public interface CartItemService {
  public List<CartItem> showAllCartItems();
  public CartItem showCartItemById(int id) throws CartItemNotFoundException;
  public CartItem addCartItem(CartItem cart) throws CartItemNotFoundException;
  public CartItem updateCartItem(CartItem cart) throws CartItemNotFoundException;
  public String deleteCartItem(int id) throws CartItemNotFoundException;
}
