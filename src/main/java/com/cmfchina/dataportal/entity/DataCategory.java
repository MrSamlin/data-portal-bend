package com.cmfchina.dataportal.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 数据分类实体类
 */

@Data
public class DataCategory {
    /**
     * 分类ID - 主键
     */
    private Integer categoryId;
    
    /**
     * 分类名称
     */
    private String categoryName;
    
    /**
     * 父分类ID
     */
    private String parentId;
    
    /**
     * 分类简要描述
     */
    private String description;
    
    /**
     * 显示顺序
     */
    private Integer displayOrder;
    
    /**
     * 分类图标URL
     */
    private String icon;
    
    /**
     * 分类横幅图片URL
     */
    private String bannerImage;
    
    /**
     * 详细说明（富文本）
     */
    private String detailedDescription;
    
    /**
     * 是否显示（1显示，0隐藏）
     */
    private Integer isVisible;
    
    /**
     * 创建人
     */
    private String createdBy;
    
    /**
     * 最后修改人
     */
    private String updatedBy;
    
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    
    /**
     * 最后修改时间
     */
    private LocalDateTime updatedAt;

    /**
     * 主题code
     */
    private String themeCode;
}
