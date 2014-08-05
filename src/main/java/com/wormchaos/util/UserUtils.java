/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: UserUtils.java
 * Author:   13071604
 * Date:     2014-8-5 下午7:27:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.util;

import java.security.interfaces.RSAPublicKey;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wormchaos.util.tool.RSACoder;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author 13071604
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UserUtils {

    private static Map<String, String> tokenMap = new ConcurrentHashMap<String, String>();

    /**
     * 
     * 功能描述: <br>
     * 根据userId生成token
     * 
     * @param request
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String createToken(String userId) throws Exception {
        // TODO 多线程
        Map<String, Object> keyMap = RSACoder.initKey();
        String token = RSACoder.encryptByPublicKey(userId, RSACoder.getPublicKey(keyMap));
        return token;
    }

    /**
     * 
     * 功能描述: <br>
     * 根据token获取userId
     * 
     * @param token
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String queryUserId(String token) {
        // IF none, return null
        return tokenMap.get(token);
    }
}
