package com.example.portal.mapper.mysql;

import com.example.portal.entity.DataCategory;
import com.example.portal.entity.QueryDao;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 数据分类Mapper接口
 */
@Mapper
public interface DataCategoryMapper {

    /**
     * 插入新的数据分类
     */
    int insert(DataCategory category);

    /**
     * 更新数据分类
     */
    int update(DataCategory category);

    /**
     * 根据ID删除数据分类
     */
    int deleteById(String categoryId);

    /**
     * 根据ID查询数据分类
     */
    DataCategory selectById(Integer categoryId);

    /**
     * 查询所有数据分类
     */
    List<DataCategory> selectAll(QueryDao query);

    /**
     * 根据父ID查询子分类
     */
    List<DataCategory> selectByParentId(String parentId);

    /**
     * 查询顶级分类（parent_id为空的分类）
     */
    List<DataCategory> selectTopCategories(QueryDao dao);


    List<DataCategory>  getCategoriesTopList(@Param("topLimit")int topLimit);

    /**
     * 根据分类名称模糊查询
     */
    List<DataCategory> selectByNameLike(String categoryName);


    int countAll(String categoryName);

}