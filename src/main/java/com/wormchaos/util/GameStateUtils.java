/**
 * FileName: GameStateUtils.java
 * Author:   wormchaos
 * Date:     2014-8-7 下午4:47:59
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wormchaos.dto.CardBean;
import com.wormchaos.dto.GameStateBean;
import com.wormchaos.dto.PlayerBean;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class GameStateUtils {

    /**
     * key - gameId; value - GameState
     */
    private static Map<Long, GameStateBean> gameState = new ConcurrentHashMap<Long, GameStateBean>();

    /**
     * 
     * 功能描述: <br>
     * 初始化游戏状态
     * 
     * @param gameId
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void initGameState(Long gameId, int playerNum, List<PlayerBean> players) {
        GameStateBean gameBean = new GameStateBean();
        List<CardBean> cardList = CardUtils.shuffleDeck(gameId, null);
        gameBean.setDeckList(cardList);
        gameBean.setTurnInPos(0);
        gameBean.setCemeteryList(new ArrayList<CardBean>());
        gameBean.setPlayers(players);
        GameStateUtils.gameState.put(gameId, gameBean);
    }

    public static GameStateBean queryGameState(Long gameId) {
        return gameState.get(gameId);
    }

}
