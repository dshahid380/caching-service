package com.cachingservice.dao;

import com.cachingservice.model.MinMaxIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Repository
public class MinMaxIndexDAO {
    @Autowired
    private MongoTemplate mongoTemplate;
    private final String SEQUENCE_NAME = "minMaxId";
    private final String ID = "id";
    private final String MIN_ID = "minId";
    private final String MAX_ID = "maxId";

    public int getMinId() {
        Query query = new Query(Criteria.where(ID).is(SEQUENCE_NAME));
        Update update = new Update().inc(MIN_ID, 1);
        MinMaxIndex minIndex = mongoTemplate.findAndModify(query, update,
                options().returnNew(true).upsert(true), MinMaxIndex.class);
        return !Objects.isNull(minIndex) ? minIndex.getMinId() : 1;
    }

    public int getMaxId() {
        Query query = new Query(Criteria.where(ID).is(SEQUENCE_NAME));
        Update update = new Update().inc(MAX_ID, 1);
        MinMaxIndex maxIndex = mongoTemplate.findAndModify(query, update,
                options().returnNew(true).upsert(true), MinMaxIndex.class);
        return !Objects.isNull(maxIndex) ? maxIndex.getMaxId() : 1;
    }
}
