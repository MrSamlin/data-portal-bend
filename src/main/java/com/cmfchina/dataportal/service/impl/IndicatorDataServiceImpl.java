package com.cmfchina.dataportal.service.impl;

import com.cmfchina.dataportal.entity.Indicator;
import com.cmfchina.dataportal.service.IndicatorDataService;
import com.cmfchina.dataportal.mapper.IndicatorMetaMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IndicatorDataServiceImpl implements IndicatorDataService {

    @Autowired
    @Qualifier("oracleSqlSessionTemplate")
    private SqlSessionTemplate oracleSqlSessionTemplate;


    @Override
    @Transactional(transactionManager = "oracleTransactionManager")
    public List<Indicator> fetchIndicatorDataByIndustry(String industryName, Integer indicatorRows) {
        IndicatorMetaMapper mapper = oracleSqlSessionTemplate.getMapper(IndicatorMetaMapper.class);
        List<Indicator> indicators = mapper.fetchIndicatorDataByIndustry(industryName, indicatorRows);
        return indicators;
    }
    @Override
    public Indicator fetchIndicatorTypeByCode(String indicatorCode) {
        IndicatorMetaMapper mapper = oracleSqlSessionTemplate.getMapper(IndicatorMetaMapper.class);
        return mapper.fetchIndicatorTypeByCode(indicatorCode);
    }
//    @Override
//    @Transactional(transactionManager = "oracleTransactionManager")
//    public Indicator fetchIndicatorTypeByCode(String indicatorCode) {
//        Indicator indicator = indicatorMetaMapper.fetchIndicatorTypeByCode(indicatorCode);
//        return indicator;
//    }
}