package com.cachingservice.controller;

import com.cachingservice.dao.CacheDAO;
import com.cachingservice.model.KeyValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CacheController {
    Logger log = LoggerFactory.getLogger(CacheController.class);
    @Autowired
    CacheDAO cacheDAO;

    // TODO: Validate request body and raise respective exception
    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> cacheElement(@RequestBody KeyValue keyValue) {
        try {
            //TODO: Implement business logic here
            cacheDAO.insert(keyValue);
            return new ResponseEntity<>("Successfully inserted the key-value pair", HttpStatus.OK);
        } catch (Exception exception) {
            log.error("Failed to insert the key-value pair: ", exception);
            return new ResponseEntity<>("Failed to insert", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/fetchLast")
    public KeyValue fetchLast() {
        return cacheDAO.fetchInsertedElement();
    }
}
