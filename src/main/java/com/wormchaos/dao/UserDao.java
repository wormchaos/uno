/**
 * FileName: UserDao.java
 * Author:   wormchaos
 * Date:     2014-8-18 上午10:35:31
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.dao;

import java.util.Map;

import com.wormchaos.bean.User;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface UserDao {

    /**
     * 
     * 功能描述: <br>
     * 查询用户
     *
     * @param params
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public User queryUser(Map<String, Object> params);
}
