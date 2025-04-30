package com.cmfchina.dataportal.mapper;

import com.cmfchina.dataportal.entity.DeepAnalysis;
import com.cmfchina.dataportal.entity.QueryDao;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 深度分析Mapper接口
 */
@Mapper
public interface DataDeepAnalysisMapper {

    /**
     * 插入新的深度分析记录
     */
    @Insert("INSERT INTO data_deep_analysis (id, analysis_name, jump_url, view_count, status, publish_date, create_date, update_date, create_user, update_user ,category_name ) " +
            "VALUES (#{id}, #{analysisName}, #{jumpUrl}, #{viewCount}, #{status}, #{publishDate}, #{createDate}, #{updateDate}, #{createUser}, #{updateUser} ,#{categoryName} )")
    int insert(DeepAnalysis deepAnalysis);

    /**
     * 更新深度分析记录
     */
    @Update("UPDATE data_deep_analysis SET analysis_name = #{analysisName}, jump_url = #{jumpUrl}, view_count = #{viewCount}, status = #{status}, " +
            "publish_date = #{publishDate}, update_date = #{updateDate}, create_user = #{createUser}, update_user = #{updateUser} , category_name=#{categoryName}    WHERE id = #{id}")
    int update(DeepAnalysis deepAnalysis);

    /**
     * 根据ID删除深度分析记录
     */
    @Delete("DELETE FROM data_deep_analysis WHERE id = #{id}")
    int deleteById(int id);

    /**
     * 根据ID查询深度分析记录
     */
    @Select("SELECT  id, analysis_name, jump_url, view_count, status, publish_date,create_date, update_date, create_user, update_user ,category_name " +
            " FROM data_deep_analysis WHERE id = #{id}")
    @ResultMap("DeepAnalysisResultMap")
    DeepAnalysis selectById(int id);

    /**
     * 查询所有深度分析记录
     */
    List<DeepAnalysis> selectAll(QueryDao query);

    int countAll(String analysisName);


    /**
     * 根据分析维度查询深度分析记录
     */
    @Select("SELECT   id, analysis_name, jump_url, view_count, status, publish_date, " +
            "     create_date, update_date, create_user, update_user ,category_name  FROM data_deep_analysis WHERE analysis_name = #{analysisName}")
    @ResultMap("DeepAnalysisResultMap")
    List<DeepAnalysis> selectByanalysisName(String analysisName);


    List<DeepAnalysis> getDeepAnalysisTopList( @Param("categoryName")String themeCodeString ,@Param("contentSize")int contentSize);

}