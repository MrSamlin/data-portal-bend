package com.example.portal.service.impl;

import com.example.portal.entity.Metrics;
import com.example.portal.entity.QueryDao;
import com.example.portal.mapper.mysql.MetricsMapper;
import com.example.portal.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricsServiceImpl implements MetricsService {

    @Autowired
    private MetricsMapper  metricsMapper;


    @Override
    public int insert(Metrics metrics) {
        return metricsMapper.insert(metrics);
    }

    @Override
    public int update(Metrics metrics) {
        return metricsMapper.update(metrics);
    }

    @Override
    public int deleteById(String metricsId) {
        return metricsMapper.deleteById(metricsId==null?0:Integer.parseInt(metricsId));
    }

    @Override
    public Metrics selectById(String metricsId) {
        return metricsMapper.selectById(metricsId==null?0:Integer.parseInt(metricsId));
    }

    @Override
    public List<Metrics> selectAll(QueryDao dao ) {
        return metricsMapper.selectAll(dao);
    }

    @Override
    public List<Metrics> getMetricsTopList(String themeCode) {
        return metricsMapper.getMetricsTopList(themeCode);
    }

    @Override
    public int countAll(String metricName) {
        return metricsMapper.countAll(metricName);
    }
}