package com.cmfchina.dataportal.mapper;

import com.cmfchina.dataportal.entity.Indicator;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IndicatorMetaMapper {

    @Select(" select industry_name, indicator_type, count_code, rownum_of_indicator_type, rownum " +
       " from ( "+
            "  select industry_name, indicator_type, count_code, rownum_of_indicator_type " +
            "  from vw_industry_indicator_stats " +
            "   where industry_name =#{industryName} " +
            " ) data  " +
            "  where rownum <=#{indicatorRows} ")
    @ResultMap("IndicatorResultMap")
    List<Indicator> fetchIndicatorDataByIndustry(@Param("industryName") String industryName, @Param("indicatorRows")Integer indicatorRows);


    @Select("   SELECT * FROM " +
            "  (  SELECT t.* FROM  excel_indicator_meta t  "+
            "   UNION ALL  " +
            "  SELECT t.* FROM cjzq_indicator_meta t " +
            "   UNION ALL  " +
            " SELECT t.* FROM gfzq_indicator_meta t ) t_meta   " +
            "  where  t_meta.indicator_code =#{indicatorCode}  ")
    @ResultMap("IndicatorResultMap")
     Indicator fetchIndicatorTypeByCode(@Param("indicatorCode") String indicatorCode);


}
