/**
 * FileName: RoomServiceImpl.java
 * Author:   wormchaos
 * Date:     2014-9-16 下午4:39:53
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wormchaos.beans.entity.Room;
import com.wormchaos.dao.RoomDao;
import com.wormchaos.service.RoomService;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomDao roomDao;

    /*
     * (non-Javadoc)
     * @see com.wormchaos.service.RoomService#checkGameStatus(java.lang.String)
     */
    public Integer checkGameStatus(Long roomId) {
        Room room = roomDao.queryRoomById(roomId);
        if (null == room || null == room.getStatus()) {
            return null;
        } else {
            return room.getStatus();
        }
    }

}
