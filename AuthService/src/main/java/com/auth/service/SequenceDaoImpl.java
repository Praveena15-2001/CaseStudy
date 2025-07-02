package com.auth.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


import com.auth.entity.DataSeq;





@Repository
public class SequenceDaoImpl implements sequenceDao{

    private MongoOperations mongoOperations;

    @Autowired
    public SequenceDaoImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public long  getNextSequenceId(String seqName) {

        DataSeq counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DataSeq.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }

	
}
