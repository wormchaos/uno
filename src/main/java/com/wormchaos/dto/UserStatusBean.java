/**
 * FileName: UserStatusBean.java
 * Author:   wormchaos
 * Date:     2014-8-6 上午10:35:54
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.dto;

import java.util.Date;


/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UserStatusBean {
    
    /**
     * 
     */
    public UserStatusBean() {
        this.timestamp = new Date().getTime();
    }
    
    /**
     * 
     */
    public UserStatusBean(String userId) {
        this.userId = userId;
        this.timestamp = new Date().getTime();
    }
    
    /**
     * 用户id
     */
    private String userId;
    
    /**
     * 最后激活时间戳
     */
    private Long timestamp;

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the timestamp
     */
    public Long getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    
}
