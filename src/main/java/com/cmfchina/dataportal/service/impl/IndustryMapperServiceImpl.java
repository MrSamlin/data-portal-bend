package com.cmfchina.dataportal.service.impl;


import com.cmfchina.dataportal.mapper.DataIndustryMapper;
import com.cmfchina.dataportal.service.IndustryMapperService;
import com.cmfchina.dataportal.entity.IndustryMap;
import com.cmfchina.dataportal.entity.QueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IndustryMapperServiceImpl implements IndustryMapperService {

    @Autowired
    private DataIndustryMapper dataIndustryMapper;


    @Override
    public List<IndustryMap> selectAll(QueryDao dao) {
        return dataIndustryMapper.findIndustryMapper(dao);
    }

    @Override
    public int countAll(QueryDao dao) {
        return dataIndustryMapper.countAll(dao);
    }

    @Override
    public Integer createIndustryMapper(IndustryMap industryMap) {
        return  dataIndustryMapper.insert(industryMap);
    }

    @Override
    public Integer updateIndustryMapper(IndustryMap industryMap) {
        return  dataIndustryMapper.update(industryMap);
    }

    @Override
    public void deleteIndustryMapper(Integer categoryId) {
        dataIndustryMapper.deleteById(categoryId);
    }
}