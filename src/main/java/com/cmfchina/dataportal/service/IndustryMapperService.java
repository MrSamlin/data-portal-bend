package com.cmfchina.dataportal.service;

import com.cmfchina.dataportal.entity.IndustryMap;
import com.cmfchina.dataportal.entity.QueryDao;

import java.util.List;

public interface IndustryMapperService {

    // 查询所有数据分类
    List<IndustryMap> selectAll(QueryDao dao);

      int countAll(QueryDao dao);

    Integer  createIndustryMapper(IndustryMap industryMap);

    /**
     * 更新行业字典
     */
    Integer updateIndustryMapper(IndustryMap industryMap);

    /**
     * 删除行业字典
     */
    void deleteIndustryMapper(Integer categoryId);

}