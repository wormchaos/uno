/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: JdbcClientImpl.java
 * Author:   13071604
 * Date:     2014-8-5 下午8:20:52
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.util.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author 13071604
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class JdbcClientImpl implements JdbcClient {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /*
     * (non-Javadoc)
     * @see com.wormchaos.util.jdbc.JdbcClient#queryBeanListByMap(java.util.Map)
     */
    public <T> List<T> queryBeanListByMap(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.wormchaos.util.jdbc.JdbcClient#queryBeanByKey(java.lang.String, java.lang.String, java.lang.String)
     */
    public <T> T queryBeanByKey(String db, String keyName, String keyValue, Class<T> clazz) {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ").append(db);
        sql.append(" where ").append(keyName).append(" = ");
        sql.append("'").append(keyValue).append("'");
        return jdbcTemplate.queryForObject(sql.toString(), clazz);
    }

    /* (non-Javadoc)
     * @see com.wormchaos.util.jdbc.JdbcClient#queryBeanByKey(java.lang.String, java.lang.String, java.lang.Long, java.lang.Class)
     */
    public <T> T queryBeanByKey(String db, String keyName, Long keyValue, Class<T> clazz) {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ").append(db);
        sql.append(" where ").append(keyName).append(" = ");
        sql.append(keyValue);
        return jdbcTemplate.queryForObject(sql.toString(), clazz);
    }
}
