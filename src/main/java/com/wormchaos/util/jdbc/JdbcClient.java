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
     * 根据复数参数查询数据
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
     * 根据String型主键查询
     *
     * @param key
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    <T> T queryBeanByKey(String db, String keyName, String keyValue, Class<T> clazz);
    
    /**
     * 
     * 功能描述: <br>
     * 根据Long型主键查询
     *
     * @param key
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    <T> T queryBeanByKey(String db, String keyName, Long keyValue, Class<T> clazz);
    
}
