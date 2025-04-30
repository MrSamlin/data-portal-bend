package com.example.portal.mapper.oracle;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

@Mapper
public interface OracleTestMapper {
    // 示例：查询 Oracle 数据库中的表
    @Select("SELECT * FROM your_oracle_table WHERE id = #{id}")
    Map<String, Object> selectById(Long id);

    // 或者使用 XML 映射（推荐复杂 SQL）
    List<Map<String, Object>> selectAll();
}
