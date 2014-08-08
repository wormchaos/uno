/*
 * FileName: UserUtils.java
 * Author:   wormchaos
 * Date:     2014-8-5 下午7:27:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.util;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.wormchaos.dto.UserStatusBean;
import com.wormchaos.util.constant.UnoConstants;
import com.wormchaos.util.constant.UnoErrConstants;
import com.wormchaos.util.exception.UnoException;
import com.wormchaos.util.tool.RSACoder;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UserUtils {

    /**
     * key - token; value - userId
     */
    private static Map<String, UserStatusBean> tokenMap = new ConcurrentHashMap<String, UserStatusBean>();

    /**
     * token失效时间 单位:毫秒
     */
    private static int DELAY_TIME = 1 * 60 * 1000;

    /**
     * 
     * 功能描述: <br>
     * 用户登录，返回鉴权token
     * 
     * @param request
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String login(String userId) throws Exception {
        // 如果用户已登录，抛出异常
        if (checkUserLogin(userId)) {
            throw new UnoException(UnoErrConstants.USER_ALREADY_LOGIN);
        }
        // 生成RSA密钥
        Map<String, Object> keyMap = RSACoder.initKey();
        String token = RSACoder.encryptByPublicKey(userId, RSACoder.getPublicKey(keyMap));
        tokenMap.put(token, new UserStatusBean(userId));
        return token;
    }
    
    /**
     * 
     * 功能描述: <br>
     * 判断用户是否登录
     * 如果登录，返回userId
     * 如果没登录，抛出异常（异常处理控制跳转重定向）
     *
     * @param request
     * @return
     * @throws UnoException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String queryUserId(HttpServletRequest request) throws UnoException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals(UnoConstants.TOKEN)){
                return queryUserId(cookie.getValue());
            }
        }
        // TODO 
        throw new UnoException(UnoErrConstants.USER_NEED_LOGIN);
    }

    /**
     * 
     * 功能描述: <br>
     * 根据token获取userId
     * 
     * @param token
     * @return
     * @throws UnoException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String queryUserId(String token) throws UnoException {

        UserStatusBean bean = tokenMap.get(token);
        // 查不到数据返回null
        if (null == bean) {
            return null;
        }

        // 检验是否过期
        if (isDelay(bean.getTimestamp())) {
            // 删除token
            logout(token);
        } else {
            // 更新时间戳
            bean.setTimestamp(new Date().getTime());
            return token;
        }

        return null;
    }

    /**
     * 
     * 功能描述: <br>
     * 删除该token对应用户的所有登录信息
     * 
     * @param token
     * @return
     * @throws UnoException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void logout(String token) throws UnoException {
        try {
            UserStatusBean bean = tokenMap.get(token);
            if (null == bean) {
                throw new UnoException(UnoErrConstants.USER_ALREADY_LOGIN);
            }
            String userId = bean.getUserId();
            for (Entry<String, UserStatusBean> entry : tokenMap.entrySet()) {
                if (entry.getValue().getUserId().equals(userId)) {
                    tokenMap.remove(entry.getKey());
                }
            }

        } catch (Exception e) {
            throw new UnoException(UnoErrConstants.USER_TOKEN_ERROR);
        }
    }

    /**
     * 
     * 功能描述: <br>
     * 检查用户是否是已登录状态 true: 已登录, false: 未登录
     * 
     * @param userId
     * @return
     * @throws UnoException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static boolean checkUserLogin(String userId) throws UnoException {
        for (Entry<String, UserStatusBean> entry : tokenMap.entrySet()) {
            if (entry.getValue().getUserId().equals(userId)) {
                if (isDelay(entry.getValue().getTimestamp())) {
                    logout(entry.getKey());
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     * 功能描述: <br>
     * 检验用户token是否过期 true:过期, false:在有效期内
     * 
     * @param timestamp
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private static boolean isDelay(Long timestamp) {
        Long now = new Date().getTime();
        if (now > timestamp + DELAY_TIME) {
            return true;
        }
        return false;
    }

}
