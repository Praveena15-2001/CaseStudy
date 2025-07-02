package com.farmer.repo;

import org.springframework.stereotype.Repository;


import com.farmer.pojo.Farmer;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface FarmerRepo extends MongoRepository<Farmer,Long>
{
	
	public Optional<Farmer> findByfarmerName(String farmername);
	

}
