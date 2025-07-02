package com.cart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cart.model.CartItem;

@Repository
public interface CartItemRepository extends MongoRepository<CartItem,Integer>{

}
