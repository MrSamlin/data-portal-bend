package com.cmfchina.dataportal.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
public class DataMenuItem {

    private Long id;

    private Long  parentId;
    private String  parentName;
    private String title;

    private String link;

    private String type;

    private Boolean isGroup = false;

    private Integer sortOrder = 0;

    private Integer status = 1;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String  iconUrl;

    private List<DataMenuItem> children = new ArrayList<>();
}
