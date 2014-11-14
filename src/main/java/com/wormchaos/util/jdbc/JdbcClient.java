/*
 * FileName: JdbcClient.java
 * Author:   wormchaos
 * Date:     2014-8-5 下午8:20:26
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.util.jdbc;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * JDBC封装
 *
 * @author 13071604
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface JdbcClient {
    
    /**
     * 
     * 功能描述: <br>
     * Q-根据复数参数查询数据
     *
     * @param map
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    <T> List<T> queryBeanListByMap(String db, Map<String, Object> params, Class<T> clazz);
    
    /**
     * 
     * 功能描述: <br>
     * Q-根据复数参数查询数据，当且仅当返回一条的时候会返回，其他都返回null;
     *
     * @param map
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    <T> T queryBeanByMap(String db, Map<String, Object> params, Class<T> clazz);
    
    /**
     * 
     * 功能描述: <br>
     * Q-根据Long型主键查询
     * TODO 暂无其他类型的主键
     *
     * @param key
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    <T> T queryBeanByKey(String db, String keyName, Long keyValue, Class<T> clazz);
    
    /**
     * 
     * 功能描述: <br>
     * I-表里插入一条数据
     *
     * @param db
     * @param params
     * @param clazz
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void insertByMap(String db, Map<String, Object> params);
    
    /**
     * 
     * 功能描述: <br>
     * I-表里插入一条数据，返回主键id
     *
     * @param db
     * @param params
     * @param clazz
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    <T> Long insertByMap(String db, Map<String, Object> params, Class<T> clazz);
    
    /**
     * 
     * 功能描述: <br>
     * D-删除表里多条符合条件的数据
     *
     * @param db
     * @param params
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void deleteByMap(String db, Map<String, Object> params);

    /**
     * 
     * 功能描述: <br>
     * U-根据条件更新字段
     *
     * @param db
     * @param condition
     * @param params
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void updateByParams(String db, Map<String, Object> condition, Map<String, Object> params);

    /**
     * 
     * 功能描述: <br>
     * U-根据条件更新字段
     *
     * @param db
     * @param condition
     * @param params
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void updateByKey(String db, String keyName, Long keyValue, Map<String, Object> params);
    
}
