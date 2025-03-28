package com.example.portal.entity;

import lombok.Data;

@Data
public class QueryDao {

    int page;
    int currentPage;
    int size;

    String analysisDimension;

    String categoryName;

    String metricName;

    String themeCode;

}
