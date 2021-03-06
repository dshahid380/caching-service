package com.cachingservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
@AllArgsConstructor
@NoArgsConstructor
public class KeyValue<T> {
    @Id
    private String key;
    private int sortOrder;
    private T value;
}
