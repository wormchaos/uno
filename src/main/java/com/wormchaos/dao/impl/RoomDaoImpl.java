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

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
@Repository
public class RoomDaoImpl implements RoomDao {

    @Autowired
    JdbcClient jdbcClient;

    private static final String DB_NAME = "uno_room";

    /*
     * (non-Javadoc)
     * @see com.wormchaos.dao.RoomDao#queryRoomById(java.lang.String)
     */
    public Room queryRoomById(Long roomId) {
        return jdbcClient.queryBeanByKey(DB_NAME, "roomId", roomId, Room.class);
    }

    /*
     * (non-Javadoc)
     * @see com.wormchaos.dao.RoomDao#updateByParams(java.util.Map, java.util.Map)
     */
    public void updateByParams(Map<String, Object> condition, Map<String, Object> params) {
        jdbcClient.updateByParams(DB_NAME, condition, params);
    }

    /* (non-Javadoc)
     * @see com.wormchaos.dao.RoomDao#updateByKey(java.lang.String, java.lang.String, java.util.Map)
     */
    public void updateByKey(String keyName, Long keyValue, Map<String, Object> params) {
        jdbcClient.updateByKey(DB_NAME, keyName, keyValue, params);
    }

}
