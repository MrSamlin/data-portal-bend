package com.cmfchina.dataportal.service;

import com.cmfchina.dataportal.entity.DeepAnalysis;
import com.cmfchina.dataportal.entity.QueryDao;

import java.util.List;

public interface DeepAnalysisService {

    // 插入新的数据分类
    int insert(DeepAnalysis deepAnalysis);

    // 更新数据分类
    int update(DeepAnalysis deepAnalysis);

    // 根据ID删除数据分类
    int deleteById(String deepAnalysisId);

    // 根据ID查询数据分类
    DeepAnalysis selectById(String deepAnalysisId);

    // 查询所有数据分类
    List<DeepAnalysis> selectAll(QueryDao dao);

      int countAll(String analysisName);

    List<DeepAnalysis> getDeepAnalysisTopList(String themeCode);
}