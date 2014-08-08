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

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
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
        String sql = createSelectSQL(db, params, clazz);
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(clazz));
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
        return jdbcTemplate.queryForObject(sql.toString(), rowMapper(clazz));
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
        return (T) jdbcTemplate.queryForObject(sql.toString(), rowMapper(clazz));
    }

    /**
     * 
     * 功能描述: <br>
     * 生成sql语句
     * 
     * @param <T>
     * 
     * @param db
     * @param params
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private <T> String createSelectSQL(String db, Map<String, Object> params, Class<T> clazz) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ");

        Field fields[] = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            sql.append(field.getName()).append(",");
        }
        sql.deleteCharAt(sql.length() - 1);

        sql.append(" FROM ").append(db).append(" WHERE 1=1 ");
        for (Entry<String, Object> entry : params.entrySet()) {
            sql.append(" AND ").append(entry.getKey()).append(" = ");
            Object value = entry.getValue();
            if (value instanceof String) {
                sql.append(" '").append(value).append("' ");
            } else if (value instanceof Date) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sql.append(" '").append(df.format(value)).append("' ");
            } else {
                sql.append(value);
            }
        }
        return sql.toString();
    }

    /**
     * 
     * 功能描述: <br>
     * 转化成rowMap队列
     * 
     * @param clazz
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private <T> RowMapper<T> rowMapper(Class<T> clazz) {
        return (RowMapper<T>) ParameterizedBeanPropertyRowMapper.newInstance(clazz);
    }

    /*
     * (non-Javadoc)
     * @see com.wormchaos.util.jdbc.JdbcClient#insertByMap(java.lang.String, java.util.Map, java.lang.Class)
     */
    public <T> void insertByMap(String db, Map<String, Object> params) {
        String sql = createInsertSql(db, params);
        jdbcTemplate.execute(sql);
    }

    /**
     * 功能描述: <br>
     * 创建插入sql
     * 
     * @param db
     * @param params
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private String createInsertSql(String db, Map<String, Object> params) {
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO ").append(db).append(" ( ");
        for (Entry<String, Object> entry : params.entrySet()) {
            sb.append(entry.getKey()).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" ) ").append(" VALUES ").append(" ( ");
        for (Entry<String, Object> entry : params.entrySet()) {
            sb.append(entry.getValue()).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" ) ");
        return sb.toString();
    }

    /*
     * (non-Javadoc)
     * @see com.wormchaos.util.jdbc.JdbcClient#insertByMap(java.lang.String, java.util.Map)
     */
    public <T> Long insertByMap(String db, Map<String, Object> params, Class<T> clazz) {
        this.insertByMap(db, params);
        T bean = this.queryBeanByMap(db, params, clazz);
        // TODO 数据库查询返回主键，万分注意！！！！
        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.wormchaos.util.jdbc.JdbcClient#queryBeanByMap(java.lang.String, java.util.Map, java.lang.Class)
     */
    public <T> T queryBeanByMap(String db, Map<String, Object> params, Class<T> clazz) {
        List<T> list = this.queryBeanListByMap(db, params, clazz);
        if (list == null || list.size() != 1) {
            return null;
        }
        return list.get(0);
    }
}
