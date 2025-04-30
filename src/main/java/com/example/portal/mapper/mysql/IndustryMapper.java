package com.example.portal.mapper;

import com.example.portal.entity.DataCategory;
import com.example.portal.entity.IndustryMap;
import com.example.portal.entity.QueryDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 行业映射
 */
@Mapper
public interface IndustryMapper {

    List<IndustryMap> findIndustryMapper(QueryDao dao);

    int countAll(QueryDao query);

    int insert(IndustryMap industryMap);


    int update(IndustryMap industryMap);


    int deleteById(Integer categoryId);


}