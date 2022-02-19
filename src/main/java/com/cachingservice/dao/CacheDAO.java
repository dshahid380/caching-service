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
import static com.cachingservice.utils.MongoUtils.queryByKey;

@Repository
public class CacheDAO {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MinMaxSortOrderDAO minMaxSortOrderDAO;

    public void insert(KeyValue keyValue) {
        KeyValue cacheElement = fetchCacheElement(keyValue);
        int sortOrder = minMaxSortOrderDAO.getMaxSortOrder();
        if (Objects.isNull(cacheElement) || sortOrder != cacheElement.getSortOrder()) {
            sortOrder = minMaxSortOrderDAO.incrementAndGetMaxSortOrder();
        }
        update(keyValue, sortOrder);
    }

    private void update(KeyValue keyValue, int sortOrder) {
        keyValue.setSortOrder(sortOrder);
        Update update = MongoUtils.updatedKeyValue(keyValue);
        Query query = queryByKey(keyValue.getKey());
        mongoTemplate.upsert(query, update, KeyValue.class);
    }

    public KeyValue fetchInsertedElement() {
        Query query = new Query();
        query.limit(1);
        query.with(Sort.by(Sort.Direction.DESC, CACHE_SORT_ORDER));
        return mongoTemplate.findOne(query, KeyValue.class);
    }

    private KeyValue fetchCacheElement(KeyValue keyValue) {
        Query query = queryByKey(keyValue.getKey());
        return mongoTemplate.findById(keyValue.getKey(), KeyValue.class);
    }
}
