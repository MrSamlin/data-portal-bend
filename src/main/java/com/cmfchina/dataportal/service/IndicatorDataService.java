package com.cmfchina.dataportal.service;

import com.cmfchina.dataportal.entity.Indicator;

import java.util.List;

public interface IndicatorDataService {
   List<Indicator> fetchIndicatorDataByIndustry(String industryName, Integer indicatorRows);


   Indicator  fetchIndicatorTypeByCode(String indicatorCode);
}