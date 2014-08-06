/*
 * FileName: JdbcClientImpl.java
 * Author:   wormchaos
 * Date:     2014-8-5 下午8:20:52
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.util.jdbc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * JDBC封装实现
 * 
 * @author wormchaos
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
    public <T> List<T> queryBeanListByMap(String db, Map<String, Object> params, Class<T> clazz) {
        String sql = createSQL(db, params);
        return jdbcTemplate.queryForList(sql, clazz);
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

    /*
     * (non-Javadoc)
     * @see com.wormchaos.util.jdbc.JdbcClient#queryBeanByKey(java.lang.String, java.lang.String, java.lang.Long,
     * java.lang.Class)
     */
    public <T> T queryBeanByKey(String db, String keyName, Long keyValue, Class<T> clazz) {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ").append(db);
        sql.append(" where ").append(keyName).append(" = ");
        sql.append(keyValue);
        return jdbcTemplate.queryForObject(sql.toString(), clazz);
    }

    /**
     * 
     * 功能描述: <br>
     * 生成sql语句
     *
     * @param db
     * @param params
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private String createSQL(String db, Map<String, Object> params) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM ").append(db).append(" WHERE 1=1 ");
        for (Entry<String, Object> entry : params.entrySet()) {
            sql.append(" AND ").append(entry.getKey()).append(" = ");
            Object value = entry.getValue();
            if (value instanceof String) {
                sql.append(" '").append(value).append("' ");
            }else if(value instanceof Date){
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sql.append(" '").append(df.format(value)).append("' ");
            }else {
                sql.append(value);
            }
        }
        return sql.toString();
    }
}
