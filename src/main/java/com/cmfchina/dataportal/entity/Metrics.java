package com.cmfchina.dataportal.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 指标实体类
 */
@Data
public class Metrics {

    private Integer id;
    private String metricsCode;
    private String metricName;
    private Long parentId;
    private String createUser;
    private String updateUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    private Date updateDate;

    private String categoryName;

    private String themeCode;

    /**
     * 显示顺序
     */
    private Integer displayOrder;

    /**
     * 0:自动标签 1:手动标签
     */
    private Integer tag;

    /**
     * 可见性
     */
    private Integer isVisible;

    private String metricType;

    private String dataSource;

    private String indicatorCode;
}