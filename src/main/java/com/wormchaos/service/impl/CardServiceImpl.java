/**
 * FileName: CardServiceImpl.java
 * Author:   wormchaos
 * Date:     2014-9-17 上午11:50:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wormchaos.beans.entity.Card;
import com.wormchaos.beans.entity.Player;
import com.wormchaos.dao.CardDao;
import com.wormchaos.dto.CardBean;
import com.wormchaos.service.CardService;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CardServiceImpl implements CardService {

    @Autowired
    CardDao cardDao;

    /*
     * (non-Javadoc)
     * @see com.wormchaos.service.CardService#insertCard(com.wormchaos.beans.entity.Card)
     */
    public void insertCard(Player player, Long cardId) {
        Card card = new Card();
        card.setCardId(cardId);
        card.setUserId(player.getUserId());
        card.setGameId(player.getGameId());
        cardDao.insertCard(card);
    }

    /*
     * (non-Javadoc)
     * @see com.wormchaos.service.CardService#deleteCard(com.wormchaos.beans.entity.Card)
     */
    public void deleteCard(Card card) {
        cardDao.deleteCard(card);
    }

    /*
     * (non-Javadoc)
     * @see com.wormchaos.service.CardService#batchInsertCard(com.wormchaos.dto.PlayerBean, java.util.List)
     */
    public void batchInsertCard(Player player, List<CardBean> cardList) {
        for (CardBean cardBean : cardList) {
            Long cardId = cardBean.getCardId();
            insertCard(player, cardId);
        }

    }

}
