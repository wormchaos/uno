/**
 * FileName: Card.java
 * Author:   wormchaos
 * Date:     2014-9-17 上午11:12:32
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.beans.entity;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Card {

    /**
     * 游戏Id
     */
    private Long gameId;

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 卡牌Id
     */
    private Long cardId;

    /**
     * @return the gameId
     */
    public Long getGameId() {
        return gameId;
    }

    /**
     * @param gameId the gameId to set
     */
    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the cardId
     */
    public Long getCardId() {
        return cardId;
    }

    /**
     * @param cardId the cardId to set
     */
    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

}
