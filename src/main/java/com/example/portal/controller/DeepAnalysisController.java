package com.example.portal.controller;

import com.example.portal.entity.*;
import com.example.portal.service.DeepAnalysisService;
import com.example.portal.service.DeepAnalysisService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deepAnalysis")
public class DeepAnalysisController {

    @Autowired
    private DeepAnalysisService deepAnalysisService;

    // 查询所有数据分类
    @PostMapping("/list")
    public Result<List<DeepAnalysis>> getAllDeepAnalysis(@RequestBody QueryDao query) {
        List<DeepAnalysis> data = deepAnalysisService.selectAll(query);
        long total = deepAnalysisService.countAll(query.getAnalysisName()); // 需确保Service层提供总数查询方法
        Result<List<DeepAnalysis>> result = new Result<>();
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
    public DeepAnalysis getCategoryById(@PathVariable String categoryId) {
        return deepAnalysisService.selectById(categoryId);
    }

    // 新增数据分类
    @PostMapping
    public int addCategory(@RequestBody DeepAnalysis category) {
        return deepAnalysisService.insert(category);
    }

    // 更新数据分类
    @PutMapping
    public int updateCategory(@RequestBody DeepAnalysis category) {
        return deepAnalysisService.update(category);
    }

    // 根据ID删除数据分类
    @DeleteMapping("/{deepAnalysisId}")
    public int deleteCategory(@PathVariable String deepAnalysisId) {
        return deepAnalysisService.deleteById(deepAnalysisId);
    }


    @GetMapping("/topList/{themeCode}")
    public List<DeepAnalysis> getDeepAnalysisTopList(@PathVariable String themeCode) {
        return deepAnalysisService.getDeepAnalysisTopList(themeCode);
    }
//
//    /**
//     * 搜索分类
//     */
//    @GetMapping("/search")
//    @Operation(summary = "获取所有深度分析")
//    public ResponseEntity<List<DataCategory>> search(@RequestParam String keyword) {
//        return ResponseEntity.ok(deepAnalysisService.selectAll());
//    }

}