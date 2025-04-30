package com.cmfchina.dataportal.service;

import com.cmfchina.dataportal.entity.Indicator;

import java.util.List;

public interface OracleDataService {
   List<Indicator> fetchIndicatorDataByIndustry(String industryName, Integer indicatorRows);

}