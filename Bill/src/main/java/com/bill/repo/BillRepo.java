package com.bill.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.bill.pojo.Invoice;

@Repository
public interface BillRepo extends MongoRepository<Invoice, String>
{

}
