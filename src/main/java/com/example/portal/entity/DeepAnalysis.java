package com.example.portal.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

/**
 * 深度分析实体类
 */
@Data
@Table(name = "data_deep_analysis")
public class DeepAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String analysisName;
    private String jumpUrl;
    private Integer viewCount;
    private String status;
    private Date publishDate;
    private Date createDate;
    private Date updateDate;
    private String createUser;
    private String updateUser;
    private String categoryName;


}