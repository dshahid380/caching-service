package com.cachingservice.dao;

import com.cachingservice.model.MinMaxSortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Objects;

import static com.cachingservice.utils.Constants.INCREMENT_VALUE;
import static com.cachingservice.utils.Constants.INITIAL_SORT_ORDER;
import static com.cachingservice.utils.Constants.MAX_SORT_ORDER;
import static com.cachingservice.utils.Constants.MIN_SORT_ORDER;
import static com.cachingservice.utils.Constants.SEQUENCE_NAME;
import static com.cachingservice.utils.MongoUtils.sequenceNameQuery;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Repository
public class MinMaxSortOrderDAO {
    @Autowired
    private MongoTemplate mongoTemplate;

    public int incrementAndGetMinSortOrder() {
        Query query = sequenceNameQuery();
        Update update = new Update().inc(MIN_SORT_ORDER, INCREMENT_VALUE);
        MinMaxSortOrder minSortOrder = mongoTemplate.findAndModify(query, update,
                options().returnNew(true).upsert(true), MinMaxSortOrder.class);
        return !Objects.isNull(minSortOrder) ? minSortOrder.getMinSortOrder() : INITIAL_SORT_ORDER;
    }

    public int incrementAndGetMaxSortOrder() {
        Query query = sequenceNameQuery();
        Update update = new Update().inc(MAX_SORT_ORDER, INCREMENT_VALUE);
        MinMaxSortOrder maxSortOrder = mongoTemplate.findAndModify(query, update,
                options().returnNew(true).upsert(true), MinMaxSortOrder.class);
        return !Objects.isNull(maxSortOrder) ? maxSortOrder.getMaxSortOrder() : INITIAL_SORT_ORDER;
    }
    
    public int getMaxSortOrder() {
        Query query = sequenceNameQuery();
        Update update = new Update();
        MinMaxSortOrder maxSortOrder = mongoTemplate.findById(SEQUENCE_NAME, MinMaxSortOrder.class);
        return Objects.nonNull(maxSortOrder) ? maxSortOrder.getMaxSortOrder() : INITIAL_SORT_ORDER;
    }
}
