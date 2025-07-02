package com.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.payment.model.Cart;

@FeignClient(name="dealer-service",url="http://localhost:2002/dealer")
public interface Dealer_payClient
{
    @GetMapping("/viewCart")
    public Cart getCart();
   
}
