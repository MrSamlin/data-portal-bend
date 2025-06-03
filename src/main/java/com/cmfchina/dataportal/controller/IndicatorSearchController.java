package com.cmfchina.dataportal.controller;

import com.cmfchina.dataportal.entity.Indicator;
import com.cmfchina.dataportal.entity.QueryDao;
import com.cmfchina.dataportal.service.IndicatorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 数据分类控制器
 */
@RestController
@RequestMapping("/indicatorSearch")
public class IndicatorSearchController {

    @Autowired
    private IndicatorDataService indicatorDataService;


    @PostMapping("/fetchIndustryDataByIndustry")
    public  List<Indicator>  fetchIndustryDataByIndustry(@RequestBody QueryDao dao) {
        List<Indicator> indicators = indicatorDataService.fetchIndicatorDataByIndustry(dao.getCategoryName(),dao.getSize());
        return indicators;
    }

    @PostMapping("/fetchIndicatorTypeByCode")
    public Indicator   fetchIndicatorTypeByCode(@RequestBody QueryDao dao) {
        Indicator indicator = indicatorDataService.fetchIndicatorTypeByCode(dao.getIndicatorCode());
        return indicator;
    }
}