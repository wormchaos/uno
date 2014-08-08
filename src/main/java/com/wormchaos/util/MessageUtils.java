/**
 * FileName: MessageUtils.java
 * Author:   wormchaos
 * Date:     2014-8-8 上午10:17:40
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

import com.wormchaos.dto.GameEventBean;

/**
 * 〈一句话功能简述〉<br>
 * 消息传递机制
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MessageUtils {

    /**
     * key - gameId; value - mesaage
     */
    private static Map<Long, List<GameEventBean>> gameMsg = new ConcurrentHashMap<Long, List<GameEventBean>>();

    private static Map<String, Integer> unreadMsgMap = new ConcurrentHashMap<String, Integer>();

    /**
     * 
     * 功能描述: <br>
     * 添加事件
     * 
     * @param gameId
     * @param eventBean
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void addEvent(Long gameId, GameEventBean eventBean) {
        // 添加事件
        getGameMsgList(gameId).add(eventBean);
    }

    /**
     * 
     * 功能描述: <br>
     * 返回某场游戏的所有事件流
     * 
     * @param gameId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static List<GameEventBean> getAllMessage(Long gameId) {
        return gameMsg.get(gameId);
    }

    /**
     * 
     * 功能描述: <br>
     * 获取用户未读消息
     *
     * @param gameId
     * @param userId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static List<GameEventBean> getUnreadMessage(Long gameId, String userId) {
        Integer index = unreadMsgMap.get(userId);
        // if null, init
        if (null == index) {
            synchronized (MessageUtils.class) {
                if (null == index) {
                    unreadMsgMap.put(userId, new Integer(0));
                }
            }
        }
        List<GameEventBean> gameMsgList = getGameMsgList(gameId);
        List<GameEventBean> retList = new ArrayList<GameEventBean>();
        int count = 0;
        for (GameEventBean gameEventBean : gameMsgList) {
            if(count > index){
                retList.add(gameEventBean);
            }
            count++;
        }
        // 更新最近状态
        unreadMsgMap.put(userId, gameMsgList.size());
        return retList;
    }

    /**
     * 
     * 功能描述: <br>
     * 获取消息列表
     *
     * @param gameId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private static List<GameEventBean> getGameMsgList(Long gameId) {
        // if null init list
        if (null == gameMsg.get(gameId)) {
            synchronized (MessageUtils.class) {
                if (null == gameMsg.get(gameId)) {
                    gameMsg.put(gameId, new ArrayList<GameEventBean>());
                }
            }
        }
        return gameMsg.get(gameId);

    }
}
