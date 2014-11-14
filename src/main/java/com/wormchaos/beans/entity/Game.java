/**
 * FileName: Game.java
 * Author:   wormchaos
 * Date:     2014-8-8 下午3:01:55
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.beans.entity;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Game {
    
    /**
     * 主键
     */
    private Long gameId;
    
    /**
     * 主键
     */
    private Long roomId;
    
    /**
     * 主键
     */
    private Integer playerNum;
    
    /**
     * 创建时间
     */
    private Date createDttm;

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
     * @return the createDttm
     */
    public Date getCreateDttm() {
        return createDttm;
    }

    /**
     * @param createDttm the createDttm to set
     */
    public void setCreateDttm(Date createDttm) {
        this.createDttm = createDttm;
    }

    /**
     * @return the playerNum
     */
    public Integer getPlayerNum() {
        return playerNum;
    }

    /**
     * @param playerNum the playerNum to set
     */
    public void setPlayerNum(Integer playerNum) {
        this.playerNum = playerNum;
    }

    /**
     * @return the roomId
     */
    public Long getRoomId() {
        return roomId;
    }

    /**
     * @param roomId the roomId to set
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

}
