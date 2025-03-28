package com.example.portal.mapper;

import com.example.portal.entity.Metrics;
import com.example.portal.entity.QueryDao;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 深度分析Mapper接口
 */
@Mapper
public interface MetricsMapper {


    @Insert("INSERT INTO data_portal.metrics " +
            "( metrics_code, metric_name, parent_id, create_user, update_user, create_date, update_date) " +
            "VALUES( #{metricsCode}, #{metricName}, #{parentId}, #{createUser}, #{updateUser},  NOW(), NOW())")
    int insert(Metrics metrics);


    @Update("UPDATE metrics SET metrics_code = #{metricsCode}, metric_name = #{metricName}, parent_id = #{parentId}, update_user = #{updateUser}, " +
            " update_date =NOW()  WHERE id = #{id}")
    int update(Metrics metrics);


    @Delete("DELETE FROM metrics WHERE id = #{id}")
    int deleteById(int id);


    @Select("SELECT   *  FROM metrics WHERE id = #{id}")
    @ResultMap("MetricsResultMap")
    Metrics selectById(int id);



    int countAll(String metricsName);


    List<Metrics> selectAll(QueryDao query);
}