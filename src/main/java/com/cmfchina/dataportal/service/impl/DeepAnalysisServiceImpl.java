package com.cmfchina.dataportal.service.impl;


import com.cmfchina.dataportal.mapper.DataDeepAnalysisMapper;
import com.cmfchina.dataportal.entity.DeepAnalysis;
import com.cmfchina.dataportal.entity.QueryDao;
import com.cmfchina.dataportal.service.DeepAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeepAnalysisServiceImpl implements DeepAnalysisService {


    @Autowired
    private DataDeepAnalysisMapper dataDeepAnalysisMapper;

    @Value("${mybatis.content.limit}")
    private Integer contentSize;


    @Override
    public int insert(DeepAnalysis deepAnalysis) {
        return dataDeepAnalysisMapper.insert(deepAnalysis);
    }

    @Override
    public int update(DeepAnalysis deepAnalysis) {
        return dataDeepAnalysisMapper.update(deepAnalysis);
    }

    @Override
    public int deleteById(String deepAnalysisId) {
        return dataDeepAnalysisMapper.deleteById(deepAnalysisId==null?0:Integer.parseInt(deepAnalysisId));
    }

    @Override
    public DeepAnalysis selectById(String deepAnalysisId) {
        return dataDeepAnalysisMapper.selectById(deepAnalysisId==null?0:Integer.parseInt(deepAnalysisId));
    }

    @Override
    public List<DeepAnalysis> selectAll(QueryDao dao) {
        return dataDeepAnalysisMapper.selectAll(dao);
    }

    @Override
    public int countAll(String analysisName) {
        return dataDeepAnalysisMapper.countAll(analysisName);
    }
    @Override
    public List<DeepAnalysis> getDeepAnalysisTopList(String categoryName) {
        return dataDeepAnalysisMapper.getDeepAnalysisTopList(categoryName,contentSize);
    }

}