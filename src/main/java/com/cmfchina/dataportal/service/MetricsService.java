package com.cmfchina.dataportal.service;

import com.cmfchina.dataportal.entity.Metrics;
import com.cmfchina.dataportal.entity.QueryDao;

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

    // 获取具体行业前四指标
    List<Metrics> getMetricsTopList(String themeCode);

    int countAll(String metricName);


}