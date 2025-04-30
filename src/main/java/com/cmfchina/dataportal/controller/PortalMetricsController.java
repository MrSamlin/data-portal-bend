package com.cmfchina.dataportal.controller;

import com.cmfchina.dataportal.service.MetricsService;
import com.cmfchina.dataportal.entity.Metrics;
import com.cmfchina.dataportal.entity.QueryDao;
import com.cmfchina.dataportal.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metrics")
public class PortalMetricsController {

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



    @GetMapping("/topList/{themeCode}")
    public List<Metrics> getMetricsTopList(@PathVariable String themeCode) {
        List<Metrics> data = metricsService.getMetricsTopList(themeCode);
        return data;
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