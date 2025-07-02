package com.dealer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealer.client.DealerAuth;
import com.dealer.model.AuthenticationResponse;


@Service
public class DealerAdminAuthService 
{
	
	@Autowired
    DealerAuth authClient;

    public boolean isSessionValid(String token) 
	    {
    AuthenticationResponse authResponse=authClient.getValidity(token);

	                if(authResponse==null) {

	                    throw new RuntimeException("Auth reponse returned as  NULL");

	                }

	                String role=authResponse.getRole().substring(5);

	                System.out.println(authResponse);
	                if(role.equals("ADMIN"))
	                	return true;
	                
	                else
                        return false;

	               

	            }

	}

	

	

