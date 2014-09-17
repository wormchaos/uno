/**
 * FileName: GameServiceImpl.java
 * Author:   wormchaos
 * Date:     2014-9-16 下午5:26:36
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wormchaos.dao.GameDao;
import com.wormchaos.service.GameService;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class GameServiceImpl implements GameService{
    
    @Autowired
    GameDao gameDao;
    
    /* (non-Javadoc)
     * @see com.wormchaos.service.GameService#createNewGame(java.lang.Long)
     */
    public Long createNewGame(Long roomId, Integer playerNum) {
        return gameDao.createGame(roomId, playerNum);
    }

}
