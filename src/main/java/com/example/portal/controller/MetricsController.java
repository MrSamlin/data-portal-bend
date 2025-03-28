package com.example.portal.controller;

import com.example.portal.entity.Metrics;
import com.example.portal.entity.QueryDao;
import com.example.portal.entity.Result;
import com.example.portal.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metrics")
public class MetricsController {

    @Autowired
    private MetricsService metricsService;

    // 查询所有数据分类
   @PostMapping("/list")
    public Result<List<Metrics>> getAllMetrics(@RequestBody QueryDao query) {

        List<Metrics> data = metricsService.selectAll(query);
        long total = metricsService.countAll(query.getMetricName()); // 需确保Service层提供总数查询方法
        Result<List<Metrics>> result = new Result<>();
        result.setData(data);
        result.setTotal(total);
        result.setCurrentPage(query.getPage());
        result.setPageSize(query.getSize());
       double temp = (double) total / query.getSize();
       int totalPages = (int) Math.ceil(temp);
       result.setTotalPages(totalPages);
        return result;
    }


    // 根据ID查询数据分类
    @GetMapping("/{categoryId}")
    public Metrics getCategoryById(@PathVariable String categoryId) {
        return metricsService.selectById(categoryId);
    }

    // 新增数据分类
    @PostMapping
    public int addCategory(@RequestBody Metrics category) {
        return metricsService.insert(category);
    }

    // 更新数据分类
    @PutMapping
    public int updateCategory(@RequestBody Metrics category) {
        return metricsService.update(category);
    }

    // 根据ID删除数据分类
    @DeleteMapping("/{categoryId}")
    public int deleteCategory(@PathVariable String categoryId) {
        return metricsService.deleteById(categoryId);
    }
}