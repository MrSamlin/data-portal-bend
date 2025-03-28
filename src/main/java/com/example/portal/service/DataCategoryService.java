package com.example.portal.service;

import com.example.portal.entity.DataCategory;
import com.example.portal.entity.QueryDao;

import java.util.List;

/**
 * 数据分类服务接口
 */
public interface DataCategoryService {

    /**
     * 创建数据分类
     */
    DataCategory createCategory(DataCategory category);

    /**
     * 更新数据分类
     */
    DataCategory updateCategory(DataCategory category);

    /**
     * 删除数据分类
     */
    void deleteCategory(String categoryId);

    /**
     * 获取数据分类详情
     */
    DataCategory getCategoryById(Integer categoryId);

    /**
     * 获取所有数据分类
     */
    List<DataCategory> getAllCategories(QueryDao dao);

    /**
     * 获取子分类
     */
    List<DataCategory> getChildCategories(String parentId);

    /**
     * 获取顶级分类
     */
    List<DataCategory> getTopCategories(QueryDao dao);


    List<DataCategory>  getCategoriesTopList();

    /**
     * 根据名称搜索分类
     */
    List<DataCategory> searchCategories(String categoryName);

      int countAll(String categoryName);
}
