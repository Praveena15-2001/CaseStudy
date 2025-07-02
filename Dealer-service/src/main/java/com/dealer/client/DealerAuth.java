package com.dealer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.dealer.model.AuthenticationResponse;

@FeignClient(name="auth-service",url="http://localhost:2005/auth")
public interface DealerAuth 
{
	    @GetMapping("/validate")
		public AuthenticationResponse getValidity(@RequestHeader("Authorization") String token);

	}
	
	
	
	
	
	
	


