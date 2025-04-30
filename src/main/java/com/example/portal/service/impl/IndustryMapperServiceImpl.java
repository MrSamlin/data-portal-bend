package com.example.portal.service.impl;


import com.example.portal.entity.IndustryMap;
import com.example.portal.entity.QueryDao;
import com.example.portal.mapper.mysql.IndustryMapper;
import com.example.portal.service.IndustryMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IndustryMapperServiceImpl implements IndustryMapperService {

    @Autowired
    private IndustryMapper industryMapper;


    @Override
    public List<IndustryMap> selectAll(QueryDao dao) {
        return industryMapper.findIndustryMapper(dao);
    }

    @Override
    public int countAll(QueryDao dao) {
        return industryMapper.countAll(dao);
    }

    @Override
    public Integer createIndustryMapper(IndustryMap industryMap) {
        return  industryMapper.insert(industryMap);
    }

    @Override
    public Integer updateIndustryMapper(IndustryMap industryMap) {
        return  industryMapper.update(industryMap);
    }

    @Override
    public void deleteIndustryMapper(Integer categoryId) {
        industryMapper.deleteById(categoryId);
    }
}