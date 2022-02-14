package com.cachingservice.dao;

import com.cachingservice.model.KeyValue;
import com.cachingservice.utils.MongoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class CacheDAO {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void insert(KeyValue keyValue) {
        Update update = MongoUtils.updatedKeyValue(keyValue);
        Query query = MongoUtils.insertQuery(keyValue.getKey());
        mongoTemplate.upsert(query, update, KeyValue.class);
    }
}
