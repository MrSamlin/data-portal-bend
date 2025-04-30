package com.cmfchina.dataportal.mapper;

import com.cmfchina.dataportal.entity.Indicator;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DataOracleMapper {

    @Results(id = "indicatorResultMap", value = {
            @Result(property = "industryName", column = "industry_name"),
            @Result(property = "indicatorType", column = "indicator_type"),
            @Result(property = "countCode", column = "count_code"),
            @Result(property = "rownumOfIndicatorType", column = "rownum_of_indicator_type"),
            @Result(property = "rownum", column = "rownum")
    })
    @Select(" select industry_name, indicator_type, count_code, rownum_of_indicator_type, rownum " +
       " from ( "+
            "  select industry_name, indicator_type, count_code, rownum_of_indicator_type " +
            "  from vw_industry_indicator_stats " +
            "   where industry_name =#{industryName} " +
            " ) data  " +
            "  where rownum <=#{indicatorRows} " )
    List<Indicator> fetchIndicatorDataByIndustry(@Param("industryName") String industryName, @Param("indicatorRows")Integer indicatorRows);
}
