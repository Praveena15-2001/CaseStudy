package com.farmer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmer.client.AuthClient;
import com.farmer.model.AuthenticationResponse;


@Service
public class FarmerAdminAuthService 
{
	
	@Autowired
    AuthClient authClient;

    public boolean isSessionValid(String token) 
	    {
    AuthenticationResponse authResponse=authClient.getValidity(token);

	                if(authResponse==null) {

	                    throw new RuntimeException("Auth reponse returned as  NULL");

	                }

	                String role=authResponse.getRole().substring(5);

	                if(role.equals("ADMIN"))
	                	return true;
	               
	                else
	                	return false;

	               

	            }

	}

	

	

