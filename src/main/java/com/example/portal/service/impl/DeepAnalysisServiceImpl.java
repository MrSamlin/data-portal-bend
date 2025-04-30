package com.example.portal.service.impl;


import com.example.portal.entity.DeepAnalysis;
import com.example.portal.entity.QueryDao;
import com.example.portal.mapper.mysql.DeepAnalysisMapper;
import com.example.portal.service.DeepAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeepAnalysisServiceImpl implements DeepAnalysisService {


    @Autowired
    private DeepAnalysisMapper deepAnalysisMapper;

    @Value("${mybatis.content.limit}")
    private Integer contentSize;


    @Override
    public int insert(DeepAnalysis deepAnalysis) {
        return deepAnalysisMapper.insert(deepAnalysis);
    }

    @Override
    public int update(DeepAnalysis deepAnalysis) {
        return deepAnalysisMapper.update(deepAnalysis);
    }

    @Override
    public int deleteById(String deepAnalysisId) {
        return deepAnalysisMapper.deleteById(deepAnalysisId==null?0:Integer.parseInt(deepAnalysisId));
    }

    @Override
    public DeepAnalysis selectById(String deepAnalysisId) {
        return deepAnalysisMapper.selectById(deepAnalysisId==null?0:Integer.parseInt(deepAnalysisId));
    }

    @Override
    public List<DeepAnalysis> selectAll(QueryDao dao) {
        return deepAnalysisMapper.selectAll(dao);
    }

    @Override
    public int countAll(String analysisName) {
        return deepAnalysisMapper.countAll(analysisName);
    }
    @Override
    public List<DeepAnalysis> getDeepAnalysisTopList(String categoryName) {
        return deepAnalysisMapper.getDeepAnalysisTopList(categoryName,contentSize);
    }

}