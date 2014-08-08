/**
 * FileName: PlayerServiceImpl.java
 * Author:   wormchaos
 * Date:     2014-8-8 下午3:19:07
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wormchaos.bean.Player;
import com.wormchaos.dao.PlayerDao;
import com.wormchaos.service.PlayerService;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerDao playerDao;

    /*
     * (non-Javadoc)
     * @see com.wormchaos.service.PlayerService#queryBeanByUserId(java.lang.String)
     */
    public Player queryBeanByUserId(String userId) {
        return playerDao.queryBeanByUserId(userId);
    }

    /*
     * (non-Javadoc)
     * @see com.wormchaos.service.PlayerService#queryBeanByMap(java.lang.Long)
     */
    public List<Player> queryListByRoomId(Long roomId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roomId", roomId);
        return playerDao.queryListByMap(params);
    }

}
