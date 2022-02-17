package com.cachingservice.utils;

import com.cachingservice.model.KeyValue;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static com.cachingservice.utils.Constants.CACHE_KEY_NAME;
import static com.cachingservice.utils.Constants.CACHE_SORT_ORDER;
import static com.cachingservice.utils.Constants.CACHE_VALUE_NAME;

public class MongoUtils {
    public static Query insertQuery(String key) {
        Query query = new Query();
        query.addCriteria(Criteria.where(CACHE_KEY_NAME).is(key));
        return query;
    }

    public static Update updatedKeyValue(KeyValue keyValue) {
        Update updatedElement = new Update();
        updatedElement.set(CACHE_VALUE_NAME, keyValue.getValue());
        updatedElement.set(CACHE_SORT_ORDER, keyValue.getSortOrder());
        return updatedElement;
    }
}
