package com.cropdetails.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cropdetails.pojo.CropDetails;
@Repository
public interface CropDetailsRepo extends MongoRepository<CropDetails, Long>
{
	
}