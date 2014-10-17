/**
 * FileName: RoomDao.java
 * Author:   wormchaos
 * Date:     2014-9-16 下午4:41:26
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.dao;

import java.util.Map;

import com.wormchaos.beans.entity.Room;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface RoomDao {
    
    /**
     * 
     * 功能描述: <br>
     * 根据roomId查找room信息
     *
     * @param roomId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Room queryRoomById(Long roomId);
    
    /**
     * 
     * 功能描述: <br>
     * 根据入参更新表
     *
     * @param condition
     * @param params
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void updateByParams(Map<String, Object> condition, Map<String, Object> params);
    
    /**
     * 
     * 功能描述: <br>
     * 根据入参更新表
     *
     * @param condition
     * @param params
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    void updateByKey(String keyName, Long keyValue, Map<String, Object> params);
}
