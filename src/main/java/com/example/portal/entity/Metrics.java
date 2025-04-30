package com.example.portal.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

/**
 * 指标实体类
 */
@Data
@Table(name = "data_metrics")
public class Metrics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String metricsCode;
    private String metricName;
    private Long parentId;
    private String createUser;
    private String updateUser;
    private Date createDate;
    private Date updateDate;
    private String categoryName;
    private String themeCode;

}