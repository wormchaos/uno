/**
 * FileName: GameStateBean.java
 * Author:   wormchaos
 * Date:     2014-8-6 下午6:55:57
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class GameStateBean implements Serializable{
    
    /**
     */
    private static final long serialVersionUID = -6712398555306961915L;

    /**
     * 当前回合内玩家序号
     */
    private Integer turnInPos;
    
    /**
     * 卡牌堆
     */
    private List<CardBean> deckList;
    
    /**
     * 弃牌堆
     */
    private List<CardBean> cemeteryList;
    
    /**
     * 弃牌堆最后一张牌
     */
    private CardBean lastCard;
    
    /**
     * 每个玩家的手牌数
     */
    private List<PlayerBean> players;

    /**
     * @return the turnInPos
     */
    public int getTurnInPos() {
        return turnInPos;
    }

    /**
     * @param turnInPos the turnInPos to set
     */
    public void setTurnInPos(int turnInPos) {
        this.turnInPos = turnInPos;
    }

    /**
     * @return the deckList
     */
    public List<CardBean> getDeckList() {
        return deckList;
    }

    /**
     * @param deckList the deckList to set
     */
    public void setDeckList(List<CardBean> deckList) {
        this.deckList = deckList;
    }

    /**
     * @return the cemeteryList
     */
    public List<CardBean> getCemeteryList() {
        return cemeteryList;
    }

    /**
     * @param cemeteryList the cemeteryList to set
     */
    public void setCemeteryList(List<CardBean> cemeteryList) {
        this.cemeteryList = cemeteryList;
    }

    /**
     * @return the lastCard
     */
    public CardBean getLastCard() {
        return lastCard;
    }

    /**
     * @param lastCard the lastCard to set
     */
    public void setLastCard(CardBean lastCard) {
        this.lastCard = lastCard;
    }

    /**
     * @return the players
     */
    public List<PlayerBean> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(List<PlayerBean> players) {
        this.players = players;
    }
    
}
