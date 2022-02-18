package com.cachingservice.dao;

import com.cachingservice.model.KeyValue;
import com.cachingservice.utils.MongoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Objects;

import static com.cachingservice.utils.Constants.CACHE_SORT_ORDER;
import static com.cachingservice.utils.Constants.ID;

@Repository
public class CacheDAO {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MinMaxSortOrderDAO minMaxSortOrderDAO;

    public void insert(KeyValue keyValue) {
        keyValue.setSortOrder(minMaxSortOrderDAO.incrementAndGetMaxSortOrder());
        Update update = MongoUtils.updatedKeyValue(keyValue);
        Query query = MongoUtils.insertQuery(keyValue.getKey());
        mongoTemplate.upsert(query, update, KeyValue.class);
    }

    public KeyValue fetchInsertedElement() {
        Query query = new Query();
        query.limit(1);
        query.with(Sort.by(Sort.Direction.DESC, CACHE_SORT_ORDER));
        return mongoTemplate.findOne(query, KeyValue.class);
    }

    private boolean isKeyPresent(KeyValue keyValue) {
        Query query = new Query(Criteria.where(ID).is(keyValue.getKey()));
        return Objects.nonNull(mongoTemplate.findById(query, KeyValue.class));
    }
}
