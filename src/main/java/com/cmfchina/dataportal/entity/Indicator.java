package com.cmfchina.dataportal.entity;

import lombok.Data;

import javax.persistence.*;


//@Entity
@Data
public class Indicator {
    private String industryName;
//
     private String indicatorType;


    private Integer countCode;

    private Integer rownumOfIndicatorType;

    private Integer rownum;
}
