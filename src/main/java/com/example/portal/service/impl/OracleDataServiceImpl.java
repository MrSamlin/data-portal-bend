package com.example.portal.service.impl;

import com.example.portal.mapper.oracle.OracleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OracleDataService {
    @Autowired
    private OracleMapper oracleMapper;

    public void fetchData() {
        // 使用注解 SQL
        Map<String, Object> data = oracleMapper.selectById(1L);
        System.out.println(data);

        // 使用 XML SQL
        List<Map<String, Object>> allData = oracleMapper.selectAll();
        System.out.println(allData);
    }
}