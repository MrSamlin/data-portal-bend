package com.cmfchina.dataportal.entity;

import lombok.Data;

import java.util.Date;

/**
 * 深度分析实体类
 */
@Data
public class DeepAnalysis {

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