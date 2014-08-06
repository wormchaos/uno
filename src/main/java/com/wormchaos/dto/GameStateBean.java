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
    private int turnInPos;
    
    /**
     * 牌堆的牌
     */
    private List<CardBean> cardList;
    
    /**
     * 卡牌数
     */
    private int cardNum;

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
     * @return the cardList
     */
    public List<CardBean> getCardList() {
        return cardList;
    }

    /**
     * @param cardList the cardList to set
     */
    public void setCardList(List<CardBean> cardList) {
        this.cardList = cardList;
    }

    /**
     * @return the cardNum
     */
    public int getCardNum() {
        return cardNum;
    }

    /**
     * @param cardNum the cardNum to set
     */
    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }
    
}
