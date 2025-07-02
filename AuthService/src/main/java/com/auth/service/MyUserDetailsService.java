package com.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.entity.User;
import com.auth.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService 
{
	@Autowired
	UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
	{
		Optional<User> user = repo.findByUserName(userName);
		
		user.orElseThrow(()-> new UsernameNotFoundException("Not found"));
		
		
		return user.map(MyUserDetailsImpl:: new).get();
		
		
		
	}

	public User loadByUserRole(String username) {
		Optional<User> user=repo.findByUserName(username);
		User u = user.get();
		return u;
	}
}
