package com.example.portal.service.impl;

import com.example.portal.entity.Indicator;
import com.example.portal.mapper.oracle.OracleMapper;
import com.example.portal.service.OracleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OracleDataServiceImpl implements OracleDataService {
    @Autowired
    private OracleMapper oracleMapper;

    public List<Indicator> fetchIndicatorDataByIndustry(String industryName,Integer indicatorRows) {
        List<Indicator> indicators = oracleMapper.fetchIndicatorDataByIndustry(industryName, indicatorRows);
        return indicators;
    }
}