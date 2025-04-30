package com.cmfchina.dataportal.controller;

import com.cmfchina.dataportal.entity.Indicator;
import com.cmfchina.dataportal.entity.IndustryMap;
import com.cmfchina.dataportal.entity.QueryDao;
import com.cmfchina.dataportal.entity.Result;
import com.cmfchina.dataportal.service.IndustryMapperService;
import com.cmfchina.dataportal.service.OracleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据分类控制器
 */
@RestController
@RequestMapping("/industryMapper")
public class PortalIndustryMapperController {

    @Autowired
    private IndustryMapperService industryMapperService;

    @Autowired
    private OracleDataService oracleDataService;

    /**
     * 创建数据分类
     */
    @PostMapping
    public ResponseEntity<Integer> createIndustryMapper(@RequestBody IndustryMap industryMap) {
        return ResponseEntity.ok(industryMapperService.createIndustryMapper(industryMap));
    }


    /**
     * 删除数据分类
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIndustryMapper(@PathVariable Integer id) {
        industryMapperService.deleteIndustryMapper(id);
        return ResponseEntity.ok().build();
    }
    /**
     * 更新数据分类
     */
    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateCategory(
            @PathVariable Integer id,
            @RequestBody IndustryMap industryMap) {
        industryMap.setId(id);
        return  ResponseEntity.ok(industryMapperService.updateIndustryMapper(industryMap));
    }


    /**
     * 获取所有数据分类
     */
    @PostMapping("/list")
    public Result<List<IndustryMap>> getAllIndustryMapper(@RequestBody QueryDao dao) {
        List<IndustryMap> data = industryMapperService.selectAll(dao);
        long total = industryMapperService.countAll(dao);
        Result<List<IndustryMap>> result = new Result<>();
        result.setData(data);
        result.setTotal(total);
        result.setCurrentPage(dao.getPage());
        result.setPageSize(dao.getSize());
        double temp = (double) total / dao.getSize();
        int totalPages = (int) Math.ceil(temp);
        result.setTotalPages(totalPages);
        return result;
    }

    @PostMapping("/fetchIndustryDataByIndustry")
    public  List<Indicator>  fetchIndustryDataByIndustry(@RequestBody QueryDao dao) {
        List<Indicator> indicators = oracleDataService.fetchIndicatorDataByIndustry(dao.getCategoryName(),dao.getSize());
        return indicators;
    }


}