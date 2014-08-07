/**
 * FileName: Card.java
 * Author:   wormchaos
 * Date:     2014-8-6 下午5:49:14
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.dto;

import java.io.Serializable;

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
public class CardBean implements Serializable {

    /**
     */
    private static final long serialVersionUID = -1920995063675132246L;

    public CardBean() {

    }

    public CardBean(int cardId, CardName cardName, CardColor cardColor) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.cardColor = cardColor;
    }

    /**
     * id，唯一标识码
     */
    private int cardId;

    /**
     * 枚举
     */
    private CardName cardName;

    /**
     * 卡片颜色 (枚举)
     */
    private CardColor cardColor;

    /**
     * 重写比较
     */
    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof CardBean) && obj != null) {
            CardBean card = (CardBean) obj;
            if(card.getCardId() == this.cardId){
                return true;
            }
        }
        return false;
    }

    /**
     * @return the cardName
     */
    public CardName getCardName() {
        return cardName;
    }

    /**
     * @param cardName the cardName to set
     */
    public void setCardName(CardName cardName) {
        this.cardName = cardName;
    }

    /**
     * @return the cardColor
     */
    public CardColor getCardColor() {
        return cardColor;
    }

    /**
     * @param cardColor the cardColor to set
     */
    public void setCardColor(CardColor cardColor) {
        this.cardColor = cardColor;
    }

    /**
     * @return the cardId
     */
    public int getCardId() {
        return cardId;
    }

    /**
     * @param cardId the cardId to set
     */
    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

}
