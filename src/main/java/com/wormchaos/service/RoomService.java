/**
 * FileName: RoomService.java
 * Author:   wormchaos
 * Date:     2014-9-16 下午3:26:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.service;


/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface RoomService {
    
    /**
     * 
     * 功能描述: <br>
     * 根据roomId查询当前状态
     *
     * @param roomId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    
    Integer checkGameStatus(Long roomId);
    
    /**
     * 
     * 功能描述: <br>
     * 更新状态
     *
     * @param roomId
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void updateStatus(Long roomId, String status, Long gameId);
    
}
