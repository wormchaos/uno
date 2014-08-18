/**
 * FileName: UserServiceImpl.java
 * Author:   wormchaos
 * Date:     2014-8-18 上午10:42:31
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wormchaos.bean.User;
import com.wormchaos.dao.UserDao;
import com.wormchaos.service.UserService;
import com.wormchaos.util.constant.UnoConstants;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    /*
     * (non-Javadoc)
     * @see com.wormchaos.service.UserService#checkUserExists(java.lang.String, java.lang.String)
     */
    public Long checkUserExists(String userName, String password) {
        
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put(UnoConstants.USERNAME, userName);
        params.put(UnoConstants.PASSWORD, password);
        
        User user = userDao.queryUser(params);
        
        if (user == null) {
            return null;
        } else {
            return user.getUserId();
        }
    }

}
