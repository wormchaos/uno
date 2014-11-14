/**
 * FileName: CardDaoImpl.java
 * Author:   wormchaos
 * Date:     2014-9-17 上午11:15:25
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wormchaos.beans.entity.Card;
import com.wormchaos.dao.CardDao;
import com.wormchaos.util.BeanUtil;
import com.wormchaos.util.jdbc.JdbcClient;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Repository
public class CardDaoImpl implements CardDao {

    @Autowired
    JdbcClient jdbcClient;

    private static final String DB_NAME = "uno_card";

    /*
     * (non-Javadoc)
     * @see com.wormchaos.dao.CardDao#insertCard(com.wormchaos.beans.entity.Card)
     */
    public void insertCard(Card card) {
        Map<String, Object> params = new HashMap<String, Object>();
        BeanUtil.copyProperties(card, params);
        jdbcClient.insertByMap(DB_NAME, params);
    }

    /*
     * (non-Javadoc)
     * @see com.wormchaos.dao.CardDao#deleteCard(com.wormchaos.beans.entity.Card)
     */
    public void deleteCard(Card card) {
        Map<String, Object> params = new HashMap<String, Object>();
        BeanUtils.copyProperties(card, params);
        jdbcClient.deleteByMap(DB_NAME, params);
    }

}
