package com.cmfchina.dataportal.mapper;

import com.cmfchina.dataportal.entity.DataMenuItem;
import com.cmfchina.dataportal.entity.Metrics;
import com.cmfchina.dataportal.entity.QueryDao;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 深度分析Mapper接口
 */
@Mapper
public interface DataMenuItemMapper {


    @Select("SELECT   *  FROM data_menu_items  ")
    @ResultMap("ChildMenuItemResultMap")
    List<DataMenuItem> getAllMenuItem();

    /**
     * 根据分析维度查询深度分析记录
     */
    @Select("SELECT   *  FROM data_menu_items WHERE is_group = 1 order by sort_order asc ")
    @ResultMap("TopMenuItemResultMap")
    List<DataMenuItem> getTopMenuItem();

    @Select("SELECT   *  FROM data_menu_items WHERE parent_id = #{parentId}  order by sort_order asc  ")
    @ResultMap("ChildMenuItemResultMap")
    List<DataMenuItem> getChildMenuItem(@Param("parentId") String parentId);


    @Insert("INSERT INTO data_menu_items " +
            "(title, link, type, parent_id, is_group, sort_order, status, icon_url ,create_time, update_time) " +
            "VALUES(#{title}, #{link}, #{type}, #{parentId}, #{isGroup}, #{sortOrder}, #{status}, #{iconUrl},NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertMenuItem(DataMenuItem dataMenuItem);


    @Update("UPDATE data_menu_items SET title = #{title}, parent_id = #{parentId}, link = #{link}, " +
            "type = #{type}, is_group = #{isGroup}, sort_order = #{sortOrder}, status = #{status}, " +
            "update_time = NOW(), icon_url = #{iconUrl} WHERE id = #{id}")
    int updateMenuItem(DataMenuItem dataMenuItem);


    @Delete("DELETE FROM data_menu_items WHERE id = #{id}")
    int deleteMenuItem(int id);

    List<DataMenuItem> getTopMenuItemList(QueryDao query);

    int    countTopList(QueryDao query);

    List<DataMenuItem>  getChildMenuItemList(QueryDao query);

    int   countChildList(QueryDao query);


    @Select("SELECT   *  FROM data_menu_items  where id = #{id} ")
    @ResultMap("TopMenuItemResultMap")
    DataMenuItem getMenuItemById(int id);

}