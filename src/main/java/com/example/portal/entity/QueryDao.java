package com.example.portal.entity;

import lombok.Data;

@Data
public class QueryDao {

    int page;
    int currentPage;
    int size;

    String analysisName;

    String categoryName;

    String metricName;

    String themeCode;

    String title;

    String value;

}
