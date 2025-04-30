package com.cmfchina.dataportal.service.impl;

import com.cmfchina.dataportal.entity.Indicator;
import com.cmfchina.dataportal.service.OracleDataService;
import com.cmfchina.dataportal.mapper.DataOracleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OracleDataServiceImpl implements OracleDataService {
    @Autowired
    private DataOracleMapper dataOracleMapper;

    public List<Indicator> fetchIndicatorDataByIndustry(String industryName, Integer indicatorRows) {
        List<Indicator> indicators = dataOracleMapper.fetchIndicatorDataByIndustry(industryName, indicatorRows);
        return indicators;
    }
}