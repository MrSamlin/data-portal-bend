package com.cmfchina.dataportal.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Indicator {

    private String id;

    private String indicatorCode;

    private String indicatorName;

    private String indicatorNameAlias;

    private String category;

    private String dataSource;

    private String infoSource;

    private String unit;

    private String frequency;

    private String indTemplateKey;

    private String sortWeight;

    private String privateTag;

    private String deleted;

    private String status;

    private String description;

    private String beginDate;

    private String endDate;

    private String pointSet;

    private String indicatorType;

    private String statisticalMethod;

    private String productName;

    private String companyShortname;

    private String brandName;

    private String industryName;

    private String applyIndustryName;

    private String area;

    private String dim1Name;

    private String dim1Value;

    private String dim2Name;

    private String dim2Value;

    private String dim3Name;

    private String dim3Value;

    private String dim4Name;

    private String dim4Value;

    private String dim5Name;

    private String dim5Value;

    private String dim6Name;

    private String dim6Value;

    private String ctg0;

    private String ctg1;

    private String ctg2;

    private String ctg3;

    private String ctg4;

    private String ctg5;

    private String ctg6;

    private String ctg7;

    private String ctg8;

    private String ctg9;

    private String futureCol1;

    private String futureCol2;

    private String futureCol3;

    private String futureCol4;

    private String futureCol5;

    private String futureCol6;

    private Date updateTime;

    private String opdate;

    private String updatedTime;
//


    private Integer countCode;

    private Integer rownumOfIndicatorType;

    private Integer rownum;
}
