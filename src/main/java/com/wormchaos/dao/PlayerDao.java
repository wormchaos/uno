/**
 * FileName: PlayerDao.java
 * Author:   wormchaos
 * Date:     2014-8-8 下午3:10:18
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.dao;

import java.util.List;
import java.util.Map;

import com.wormchaos.bean.Player;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface PlayerDao {
    
    /**
     * 
     * 功能描述: <br>
     * 根据主键查找bean
     *
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Player queryBeanByUserId(String userId);
    
    /**
     * 
     * 功能描述: <br>
     * 根据参数查找player
     *
     * @param params
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<Player> queryListByMap(Map<String, Object> params);
    
    /**
     * 
     * 功能描述: <br>
     * 查看当前用户状态
     *
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Integer queryStateByUserId(String userId);
}
