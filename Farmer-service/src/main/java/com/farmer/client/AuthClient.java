package com.farmer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.farmer.model.AuthenticationResponse;

@FeignClient(name="auth-service",url="http://localhost:2005/auth")
public interface AuthClient 
{
	
	
	@GetMapping("/validate")
	public AuthenticationResponse getValidity(@RequestHeader("Authorization") String token);
	
}
