/**
 * FileName: CardService.java
 * Author:   wormchaos
 * Date:     2014-9-17 上午11:48:15
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.service;

import java.util.List;

import com.wormchaos.beans.entity.Card;
import com.wormchaos.beans.entity.Player;
import com.wormchaos.dto.CardBean;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CardService {
    /**
     * 
     * 功能描述: <br>
     * 插入卡牌
     *
     * @param roomId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void insertCard(Player player, Long cardId);

    /**
     * 
     * 功能描述: <br>
     * 批量插入卡牌
     *
     * @param roomId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void batchInsertCard(Player player, List<CardBean> cardList);
    
    /**
     * 
     * 功能描述: <br>
     * 删除卡牌
     *
     * @param roomId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void deleteCard(Card card);

}
