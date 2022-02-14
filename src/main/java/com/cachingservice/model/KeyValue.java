package com.cachingservice.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class KeyValue<T> {
    @Id
    private String key;
    private T value;
}
