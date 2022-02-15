package com.cachingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document()
public class MinMaxSortOrder {
    @Id
    private String sequenceName;
    private int minSortOrder;
    private int maxSortOrder;
}
