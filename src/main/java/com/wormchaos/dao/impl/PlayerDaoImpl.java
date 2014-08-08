/**
 * FileName: PlayerDaoImpl.java
 * Author:   wormchaos
 * Date:     2014-8-8 下午3:13:05
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wormchaos.bean.Player;
import com.wormchaos.dao.PlayerDao;
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
public class PlayerDaoImpl implements PlayerDao {

    private static final String DB_NAME = "uno_player";

    @Autowired
    JdbcClient jdbcClient;

    /*
     * (non-Javadoc)
     * @see com.wormchaos.dao.PlayerDao#queryBeanByUserId(java.lang.String)
     */
    public Player queryBeanByUserId(String userId) {
        Player player = jdbcClient.queryBeanByKey(DB_NAME, "userId", Long.parseLong(userId), Player.class);
        return player;
    }

    /*
     * (non-Javadoc)
     * @see com.wormchaos.dao.PlayerDao#queryListByMap(java.util.Map)
     */
    public List<Player> queryListByMap(Map<String, Object> params) {
        return jdbcClient.queryBeanListByMap(DB_NAME, params, Player.class);
    }

    /*
     * (non-Javadoc)
     * @see com.wormchaos.dao.PlayerDao#queryStateByUserId(java.lang.String)
     */
    public Integer queryStateByUserId(String userId) {
        Player player = queryBeanByUserId(userId);
        if (null == player) {
            return null;
        }
        return player.getState();
    }

}
