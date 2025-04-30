package com.example.portal.mapper.mysql;

import com.example.portal.entity.Metrics;
import com.example.portal.entity.QueryDao;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 深度分析Mapper接口
 */
@Mapper
public interface MetricsMapper {


    @Insert("INSERT INTO data_portal.data_metrics " +
            "( metrics_code, metric_name, parent_id, create_user, update_user, create_date, update_date, category_name,theme_code ) " +
            "VALUES( #{metricsCode}, #{metricName}, #{parentId}, #{createUser}, #{updateUser},  NOW(), NOW(), #{categoryName}, #{themeCode} )")
    int insert(Metrics metrics);


    @Update("UPDATE data_metrics SET metrics_code = #{metricsCode},theme_code = #{themeCode}, metric_name = #{metricName}, parent_id = #{parentId}, update_user = #{updateUser}, " +
            " update_date =NOW() , category_name = #{categoryName} WHERE id = #{id}")
    int update(Metrics metrics);


    @Delete("DELETE FROM data_metrics WHERE id = #{id}")
    int deleteById(int id);


    @Select("SELECT   *  FROM data_metrics WHERE id = #{id}")
    @ResultMap("MetricsResultMap")
    Metrics selectById(int id);



    int countAll(String metricsName);


    List<Metrics> selectAll(QueryDao query);


    List<Metrics> getMetricsTopList(  @Param("themeCode")String themeCode);
}