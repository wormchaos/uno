/**
 * FileName: RoomDaoImpl.java
 * Author:   wormchaos
 * Date:     2014-9-16 下午4:51:33
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wormchaos.beans.entity.Room;
import com.wormchaos.dao.RoomDao;
import com.wormchaos.util.jdbc.JdbcClient;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class RoomDaoImpl implements RoomDao {

    @Autowired
    JdbcClient jdbcClient;

    private static final String DB_NAME = "sgs_room";

    /*
     * (non-Javadoc)
     * @see com.wormchaos.dao.RoomDao#queryRoomById(java.lang.String)
     */
    public Room queryRoomById(String roomId) {
        return jdbcClient.queryBeanByKey(DB_NAME, "roomId", roomId, Room.class);
    }

}
