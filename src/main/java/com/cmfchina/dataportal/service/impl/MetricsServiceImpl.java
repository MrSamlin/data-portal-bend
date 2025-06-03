package com.cmfchina.dataportal.service.impl;

import com.cmfchina.dataportal.entity.Metrics;
import com.cmfchina.dataportal.entity.QueryDao;
import com.cmfchina.dataportal.mapper.DataMetricsMapper;
import com.cmfchina.dataportal.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricsServiceImpl implements MetricsService {

    @Autowired
    private DataMetricsMapper dataMetricsMapper;


    @Override
    public int insert(Metrics metrics) {
        return dataMetricsMapper.insert(metrics);
    }

    @Override
    public int update(Metrics metrics) {
        return dataMetricsMapper.update(metrics);
    }

    @Override
    public int deleteById(String metricsId) {
        return dataMetricsMapper.deleteById(metricsId==null?0:Integer.parseInt(metricsId));
    }

    @Override
    public Metrics selectById(String metricsId) {
        return dataMetricsMapper.selectById(metricsId==null?0:Integer.parseInt(metricsId));
    }

    @Override
    public List<Metrics> selectAll(QueryDao dao ) {
        return dataMetricsMapper.selectAll(dao);
    }

    @Override
    public List<Metrics> getMetricsTopList(String themeCode) {
        return dataMetricsMapper.getMetricsTopList(themeCode);
    }

    @Override
    public int countAll(String metricName) {
        return dataMetricsMapper.countAll(metricName);
    }

    @Override
    public  List<Metrics> getMetricsDataByMetricType(Metrics metrics) {
        return dataMetricsMapper.getMetricsDataByMetricType(metrics);
    }
}