package com.cmfchina.dataportal.mapper;

import com.cmfchina.dataportal.entity.IndustryMap;
import com.cmfchina.dataportal.entity.QueryDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 行业映射
 */
@Mapper
public interface DataIndustryMapper {

    List<IndustryMap> findIndustryMapper(QueryDao dao);

    int countAll(QueryDao query);

    int insert(IndustryMap industryMap);


    int update(IndustryMap industryMap);


    int deleteById(Integer categoryId);


}