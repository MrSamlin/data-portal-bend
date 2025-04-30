package com.example.portal.service;

import com.example.portal.entity.Indicator;

import java.util.List;

public interface OracleDataService {
   List<Indicator> fetchIndicatorDataByIndustry(String industryName,Integer indicatorRows);

}