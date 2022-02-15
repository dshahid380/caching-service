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
    @Autowired
    private MinMaxSortOrderDAO minMaxSortOrderDAO;

    public void insert(KeyValue keyValue) {
        keyValue.setSortOrder(minMaxSortOrderDAO.getMaxSortOrder());
        Update update = MongoUtils.updatedKeyValue(keyValue);
        Query query = MongoUtils.insertQuery(keyValue.getKey());
        mongoTemplate.upsert(query, update, KeyValue.class);
    }

//    public KeyValue fetchLast() {
//        Query query = new Query();
//        query.limit(1);
//        query.with(Sort.by(Sort.Direction.DESC,"_id"));
//        return mongoTemplate.findOne(query, KeyValue.class);
//    }
}
