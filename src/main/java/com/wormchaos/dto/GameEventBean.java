/**
 * FileName: GameEventBean.java
 * Author:   wormchaos
 * Date:     2014-8-8 上午10:27:05
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.dto;

import com.wormchaos.dto.enu.MessageEnum;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class GameEventBean {
    
    /**
     * 事件名
     */
    private MessageEnum message;
    
    /**
     * 发起者
     */
    private PlayerBean origin;
    
    /**
     * 事件涉及数量
     */
    private int num;
    
    /**
     * 事件涉及的具体卡牌
     */
    private CardBean card;

    /**
     * @return the message
     */
    public MessageEnum getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(MessageEnum message) {
        this.message = message;
    }

    /**
     * @return the origin
     */
    public PlayerBean getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(PlayerBean origin) {
        this.origin = origin;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * @return the card
     */
    public CardBean getCard() {
        return card;
    }

    /**
     * @param card the card to set
     */
    public void setCard(CardBean card) {
        this.card = card;
    }

}
