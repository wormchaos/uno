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
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.util.CollectionUtils;

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

    private static List<CardBean> cardList;

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
        // 初始化卡组
        List<CardBean> cardList = shuffleDeck(gameId, null);
        gameBean.setCardList(cardList);
        gameBean.setTurnInPos(1);
        gameBean.setCardNum(cardList.size());
        gameState.put(gameId, gameBean);
    }

    /**
     * 
     * 功能描述: <br>
     * 新建卡组，逻辑上只会调用一次
     * 
     * @param gameId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static List<CardBean> initCardList(Long gameId) {
        List<CardBean> cards = new ArrayList<CardBean>();
        int cardId = 0;
        // 1-9,跳过,翻转,+2 每种颜色有两张,但是0和万能牌只有一张
        for (CardColor color : CardColor.values()) {
            for (CardName name : CardName.values()) {
                cardList.add(new CardBean(cardId, name, color));
                cardId++;
                // 如果是0-9，再加一张
                if (!name.equals(CardName.n0) && !name.equals(CardName.wild) && !name.equals(CardName.draw4)) {
                    cards.add(new CardBean(cardId, name, color));
                    cardId++;
                }
            }
        }
        // 洗牌
        // Collections.shuffle(cardList);
        return cards;
    }

    /**
     * 
     * 功能描述: <br>
     * 牌组洗牌
     *
     * @param gameId
     * @param extendCards
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static List<CardBean> shuffleDeck(Long gameId, List<CardBean> extendCards) {
        if (null == cardList) {
            synchronized (CardUtils.class) {
                if (null == cardList) {
                    cardList = initCardList(gameId);
                }
            }
        }
        
        if(!CollectionUtils.isEmpty(extendCards)){
            // bean方法里有equals匹配
            cardList.removeAll(extendCards);            
        }
        return cardList;
    }
}
