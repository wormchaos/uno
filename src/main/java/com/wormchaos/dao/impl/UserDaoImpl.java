/**
 * FileName: UserDaoImpl.java
 * Author:   wormchaos
 * Date:     2014-8-18 上午10:37:23
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wormchaos.bean.User;
import com.wormchaos.dao.UserDao;
import com.wormchaos.util.jdbc.JdbcClient;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcClient jdbcClient;
    
    private static final String DB_NAME = "uno_user";
    
    /*
     * (non-Javadoc)
     * @see com.wormchaos.dao.UserDao#queryUser(java.util.Map)
     */
    public User queryUser(Map<String, Object> params) {
        return jdbcClient.queryBeanByMap(DB_NAME, params, User.class);
    }

}
