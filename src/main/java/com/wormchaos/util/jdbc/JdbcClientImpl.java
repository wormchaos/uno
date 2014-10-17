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
    public void insertByMap(String db, Map<String, Object> params) {
        String sql = createInsertSql(db, params);
        // KeyHolder keyHolder = new GeneratedKeyHolder();
        // PreparedStatementCreator psc;
        // jdbcTemplate.update(psc, keyHolder);
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
        try {
            this.insertByMap(db, params);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        // 查询主键的名称
        String name = queryPrimaryKey(db);
        T bean = this.queryBeanByMap(db, params, clazz);
        try {
            Field field = clazz.getDeclaredField(name);
            field.setAccessible(true);
            return Long.parseLong(field.get(bean).toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 功能描述: <br>
     * 查找表的主键
     * 
     * @param db
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private String queryPrimaryKey(String db) {
        String sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE TABLE_NAME='" + db + "'";
        Map<String, Object> result = jdbcTemplate.queryForMap(sql);
        String name = (String) result.get("COLUMN_NAME");
        return name;
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

    /*
     * (non-Javadoc)
     * @see com.wormchaos.util.jdbc.JdbcClient#deleteByMap(java.lang.String, java.util.Map)
     */
    public void deleteByMap(String db, Map<String, Object> params) {
        String sql = createDeleteSql(db, params);
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
    private String createDeleteSql(String db, Map<String, Object> params) {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM ").append(db).append(" WHERE 1=1 ");
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

    // public Number persist(Object obj, String tablesName, Long keyValue) {
    // String sql = "";
    // Map<String, Object> paramMap = ValueParser.parser(obj);
    // List<DataSource> dsList = routeUtil.route(tablesName, keyValue);
    // RouteJdbcTemplate jdbcTemplate = new RouteJdbcTemplate();
    // if (keyValue != null) {
    // // keyValue不为空则是非自增主键
    // jdbcTemplate.execute(dsList.get(0), sql, paramMap);
    // return 0;
    // } else {
    // return jdbcTemplate.executeForHolder(dsList.get(0), sql, paramMap);
    // }
    // }
    // public Number executeForHolder(DataSource ds, String sql, Map<String, ?> paramMap) {
    // if (this.logger.isDebugEnabled()) {
    // StringBuffer sb = new StringBuffer();
    // sb.append(SQL).append(sql).append(PARAM).append(paramMap);
    // logger.debug(sb.toString());
    // }
    // KeyHolder keyHolder = new GeneratedKeyHolder();
    // NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(ds);
    // jdbcTemplate.update(sql, new MapSqlParameterSource(paramMap), keyHolder);
    //
    // List<Map<String, Object>> keyList = keyHolder.getKeyList();
    // if (keyList == null || keyList.isEmpty()) {
    // return 0;
    // }
    // Iterator<Object> keyIter = keyList.get(0).values().iterator();
    // Object key = keyIter.next();
    // if (!(key instanceof Number)) {
    // return 0;
    // } else {
    // return (Number) key;
    // }
    // }

    /*
     * (non-Javadoc)
     * @see com.wormchaos.util.jdbc.JdbcClient#updateByParams(java.lang.String, java.util.Map, java.util.Map)
     */
    public void updateByParams(String db, Map<String, Object> condition, Map<String, Object> params) {
        String sql = createUpdateSql(db, condition, params);
        jdbcTemplate.update(sql);
    }

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @param db
     * @param params
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private String createUpdateSql(String db, Map<String, Object> condition, Map<String, Object> params) {
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE ").append(db).append(" SET ");

        for (Entry<String, Object> entry : params.entrySet()) {
            sql.append(entry.getKey()).append(" = ");
            Object value = entry.getValue();
            if (value instanceof String) {
                sql.append(" '").append(value).append("' ");
            } else if (value instanceof Date) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sql.append(" '").append(df.format(value)).append("' ");
            } else {
                sql.append(value);
            }
            sql.append(" ,");
        }
        sql.deleteCharAt(sql.length() - 1);

        sql.append(" WHERE 1=1 ");
        for (Entry<String, Object> entry : condition.entrySet()) {
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

    /*
     * (non-Javadoc)
     * @see com.wormchaos.util.jdbc.JdbcClient#updateByKey(java.lang.String, java.lang.String, java.lang.Long,
     * java.util.Map)
     */
    public void updateByKey(String db, String keyName, Long keyValue, Map<String, Object> params) {
        String sql = createUpdateSql(db, keyName, keyValue, params);
        jdbcTemplate.update(sql);
    }

    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @param db
     * @param keyName
     * @param keyValue
     * @param params
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private String createUpdateSql(String db, String keyName, Long keyValue, Map<String, Object> params) {
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE ").append(db).append(" SET ");

        for (Entry<String, Object> entry : params.entrySet()) {
            sql.append(entry.getKey()).append(" = ");
            Object value = entry.getValue();
            if (value instanceof String) {
                sql.append(" '").append(value).append("' ");
            } else if (value instanceof Date) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sql.append(" '").append(df.format(value)).append("' ");
            } else {
                sql.append(value);
            }
            sql.append(" ,");
        }
        sql.deleteCharAt(sql.length() - 1);

        sql.append(" WHERE ").append(keyName).append(" = ").append(keyValue);
        return sql.toString();
    }
}
