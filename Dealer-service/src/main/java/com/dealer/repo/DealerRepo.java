package com.dealer.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dealer.exception.DealerNotFoundException;
import com.dealer.pojo.Dealer;

@Repository
public interface DealerRepo extends MongoRepository<Dealer, Long> 
{
	public Optional<Dealer> findBydealerName(String name) throws DealerNotFoundException;

}
