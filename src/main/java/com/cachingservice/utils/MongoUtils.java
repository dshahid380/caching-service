package com.cachingservice.utils;

import com.cachingservice.model.KeyValue;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class MongoUtils {
    public static Query insertQuery(String key) {
        Query query = new Query();
        query.addCriteria(Criteria.where("key").is(key));
        return query;
    }

    public static Update updatedKeyValue(KeyValue keyValue) {
        Update updatedElement = new Update();
        updatedElement.set("value", keyValue.getValue());
        updatedElement.set("sortOrder", keyValue.getSortOrder());
        return updatedElement;
    }
}
