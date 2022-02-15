package com.cachingservice.dao;

import com.cachingservice.model.MinMaxSortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Repository
public class MinMaxSortOrderDAO {
    @Autowired
    private MongoTemplate mongoTemplate;
    private final String SEQUENCE_NAME = "minMaxId";
    private final String ID = "id";
    private final String MIN_ID = "minId";
    private final String MAX_ID = "maxId";

    public int getMinSortOrder() {
        Query query = new Query(Criteria.where(ID).is(SEQUENCE_NAME));
        Update update = new Update().inc(MIN_ID, 1);
        MinMaxSortOrder minSortOrder = mongoTemplate.findAndModify(query, update,
                options().returnNew(true).upsert(true), MinMaxSortOrder.class);
        return !Objects.isNull(minSortOrder) ? minSortOrder.getMinSortOrder() : 1;
    }

    public int getMaxSortOrder() {
        Query query = new Query(Criteria.where(ID).is(SEQUENCE_NAME));
        Update update = new Update().inc(MAX_ID, 1);
        MinMaxSortOrder maxSortOrder = mongoTemplate.findAndModify(query, update,
                options().returnNew(true).upsert(true), MinMaxSortOrder.class);
        return !Objects.isNull(maxSortOrder) ? maxSortOrder.getMaxSortOrder() : 1;
    }
}
