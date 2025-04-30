package com.cmfchina.dataportal.controller;

import com.cmfchina.dataportal.entity.DataCategory;
import com.cmfchina.dataportal.entity.QueryDao;
import com.cmfchina.dataportal.entity.Result;
import com.cmfchina.dataportal.service.DataCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据分类控制器
 */
@RestController
@RequestMapping("/categories")
public class PortalDataCategoryController {

    @Autowired
    private DataCategoryService dataCategoryService;



    /**
     * 创建数据分类
     */
    @PostMapping
    public ResponseEntity<DataCategory> createCategory(@RequestBody DataCategory category) {
        return ResponseEntity.ok(dataCategoryService.createCategory(category));
    }

    /**
     * 更新数据分类
     */
    @PutMapping("/{categoryId}")
    public ResponseEntity<DataCategory> updateCategory(
            @PathVariable Integer categoryId,
            @RequestBody DataCategory category) {
        category.setCategoryId(categoryId);
        return ResponseEntity.ok(dataCategoryService.updateCategory(category));
    }

    /**
     * 删除数据分类
     */
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String categoryId) {
        dataCategoryService.deleteCategory(categoryId);
        return ResponseEntity.ok().build();
    }

    /**
     * 获取数据分类详情
     */
    @GetMapping("/{categoryId}")
    public ResponseEntity<DataCategory> getCategoryById(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(dataCategoryService.getCategoryById(categoryId));
    }

    /**
     * 获取所有数据分类
     */
    @PostMapping("/list")
    public  Result<List<DataCategory>>  getAllCategories(@RequestBody QueryDao dao) {
        List<DataCategory> data = dataCategoryService.getAllCategories(dao);
        long total = dataCategoryService.countAll(dao.getCategoryName()); // 需确保Service层提供总数查询方法
        Result<List<DataCategory>> result = new Result<>();
        result.setData(data);
        result.setTotal(total);
        result.setCurrentPage(dao.getPage());
        result.setPageSize(dao.getSize());
        double temp = (double) total / dao.getSize();
        int totalPages = (int) Math.ceil(temp);
        result.setTotalPages(totalPages);
        return result;
    }

    /**
     * 获取子分类
     */
    @GetMapping("/children/{parentId}")
    public ResponseEntity<List<DataCategory>> getChildCategories(@PathVariable String parentId) {
        return ResponseEntity.ok(dataCategoryService.getChildCategories(parentId));
    }

    /**
     * 获取顶级分类
     */
    @PostMapping("/top")
    public ResponseEntity<List<DataCategory>> getTopCategories(@RequestBody  QueryDao dao) {
        return ResponseEntity.ok(dataCategoryService.getTopCategories(dao));
    }

    /**
     * 获取顶级分类
     */
    @GetMapping("/topList")
    public ResponseEntity<List<DataCategory>> getCategoriesTopList() {
        return ResponseEntity.ok(dataCategoryService.getCategoriesTopList());
    }


    /**
     * 搜索分类
     */
    @GetMapping("/search")
    public ResponseEntity<List<DataCategory>> searchCategories(@RequestParam String keyword) {
        return ResponseEntity.ok(dataCategoryService.searchCategories(keyword));
    }
}
