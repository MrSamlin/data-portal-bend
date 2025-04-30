package com.example.portal.service.impl;

import com.example.portal.entity.DataCategory;
import com.example.portal.entity.QueryDao;
import com.example.portal.mapper.mysql.DataCategoryMapper;
import com.example.portal.service.DataCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 数据分类服务实现类
 */
@Service
public class DataCategoryServiceImpl implements DataCategoryService {

    @Autowired
    private DataCategoryMapper dataCategoryMapper;

    @Value("${mybatis.top.limit}")
    private Integer topLimit;

    @Override
    @Transactional
    public DataCategory createCategory(DataCategory category) {
        // 设置默认值
        if (category.getDisplayOrder() == null) {
            category.setDisplayOrder(0);
        }
        if (category.getIsVisible() == null) {
            category.setIsVisible(1);
        }
        dataCategoryMapper.insert(category);
        return category;
    }


    @Override
    @Transactional
    public DataCategory updateCategory(DataCategory category) {
        DataCategory existingCategory = dataCategoryMapper.selectById(category.getCategoryId());
        if (existingCategory == null) {
            throw new RuntimeException("分类不存在");
        }
        dataCategoryMapper.update(category);
        return category;
    }

    @Override
    @Transactional
    public void deleteCategory(String categoryId) {
        // 检查是否存在子分类
        List<DataCategory> children = dataCategoryMapper.selectByParentId(categoryId);
        if (!children.isEmpty()) {
            throw new RuntimeException("存在子分类，无法删除");
        }

        dataCategoryMapper.deleteById(categoryId);
    }

    @Override
    public DataCategory getCategoryById(Integer categoryId) {
        return dataCategoryMapper.selectById(categoryId);
    }

    @Override
    public List<DataCategory> getAllCategories(QueryDao query) {
        return dataCategoryMapper.selectAll(query);
    }

    @Override
    public List<DataCategory> getChildCategories(String parentId) {
        return dataCategoryMapper.selectByParentId(parentId);
    }

    @Override
    public List<DataCategory> getTopCategories(QueryDao dao) {
        List<DataCategory> dataCategories = dataCategoryMapper.selectTopCategories(dao);
        return dataCategories;
    }

    @Override
    public List<DataCategory> getCategoriesTopList() {
        List<DataCategory> dataCategories = dataCategoryMapper.getCategoriesTopList(topLimit);
        return dataCategories;
    }

    @Override
    public List<DataCategory> searchCategories(String categoryName) {
        return dataCategoryMapper.selectByNameLike(categoryName);
    }

    @Override
    public int countAll(String categoryName) {
        return dataCategoryMapper.countAll(categoryName);
    }
}
