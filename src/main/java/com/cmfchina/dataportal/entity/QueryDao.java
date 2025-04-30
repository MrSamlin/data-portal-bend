package com.cmfchina.dataportal.entity;

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
