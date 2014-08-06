/**
 * FileName: CardUtils.java
 * Author:   wormchaos
 * Date:     2014-8-6 下午6:53:56
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wormchaos.dto.CardBean;
import com.wormchaos.dto.GameStateBean;
import com.wormchaos.dto.enu.CardColor;
import com.wormchaos.dto.enu.CardName;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CardUtils {

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
    public static void initGameState(Long gameId) {
        GameStateBean gameBean = new GameStateBean();
        List<CardBean> cardList = initCardList(gameId);
        gameBean.setCardList(cardList);
        gameBean.setTurnInPos(1);
        gameBean.setCardNum(cardList.size());
        gameState.put(gameId, gameBean);
    }
    
    /**
     * 
     * 功能描述: <br>
     * 新建卡组
     *
     * @param gameId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static List<CardBean> initCardList(Long gameId) {
        List<CardBean> cardList = new ArrayList<CardBean>();
        // 1-9,跳过,翻转,+2 每种颜色有两张,但是0和万能牌只有一张
        for (CardColor color : CardColor.values()) {
            for (CardName name : CardName.values()) {
                cardList.add(new CardBean(name, color));
                // 如果是0-9，再加一张
                if (!name.equals(CardName.n0) && !name.equals(CardName.wild) && !name.equals(CardName.draw4)) {
                    cardList.add(new CardBean(name, color));
                }
            }
        }
        // 洗牌
        Collections.shuffle(cardList);
        return cardList;
    }
}
