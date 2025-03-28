package com.example.portal.service;

import com.example.portal.entity.Metrics;
import com.example.portal.entity.QueryDao;

import java.util.List;

public interface MetricsService {

    // 插入新的数据分类
    int insert(Metrics metrics);

    // 更新数据分类
    int update(Metrics metrics);

    // 根据ID删除数据分类
    int deleteById(String metricsId);

    // 根据ID查询数据分类
    Metrics selectById(String metricsId);

    // 查询所有数据分类
    List<Metrics> selectAll(QueryDao dao);

    int countAll(String metricName);


}