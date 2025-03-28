package com.example.portal.mapper;

import com.example.portal.entity.DeepAnalysis;
import com.example.portal.entity.QueryDao;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 深度分析Mapper接口
 */
@Mapper
public interface DeepAnalysisMapper {

    /**
     * 插入新的深度分析记录
     */
    @Insert("INSERT INTO deep_analysis (id, analysis_dimension, jump_url, view_count, status, publish_date, create_date, update_date, create_user, update_user) " +
            "VALUES (#{id}, #{analysisDimension}, #{jumpUrl}, #{viewCount}, #{status}, #{publishDate}, #{createDate}, #{updateDate}, #{createUser}, #{updateUser})")
    int insert(DeepAnalysis deepAnalysis);

    /**
     * 更新深度分析记录
     */
    @Update("UPDATE deep_analysis SET analysis_dimension = #{analysisDimension}, jump_url = #{jumpUrl}, view_count = #{viewCount}, status = #{status}, " +
            "publish_date = #{publishDate}, update_date = #{updateDate}, create_user = #{createUser}, update_user = #{updateUser} WHERE id = #{id}")
    int update(DeepAnalysis deepAnalysis);

    /**
     * 根据ID删除深度分析记录
     */
    @Delete("DELETE FROM deep_analysis WHERE id = #{id}")
    int deleteById(int id);

    /**
     * 根据ID查询深度分析记录
     */
    @Select("SELECT  id, analysis_dimension, jump_url, view_count, status, publish_date,create_date, update_date, create_user, update_user " +
            " FROM deep_analysis WHERE id = #{id}")
    @ResultMap("DeepAnalysisResultMap")
    DeepAnalysis selectById(int id);

    /**
     * 查询所有深度分析记录
     */
    List<DeepAnalysis> selectAll(QueryDao query);

    int countAll(String analysisDimension);


    /**
     * 根据分析维度查询深度分析记录
     */
    @Select("SELECT   id, analysis_dimension, jump_url, view_count, status, publish_date, " +
            "     create_date, update_date, create_user, update_user  FROM deep_analysis WHERE analysis_dimension = #{analysisDimension}")
    @ResultMap("DeepAnalysisResultMap")
    List<DeepAnalysis> selectByAnalysisDimension(String analysisDimension);
}