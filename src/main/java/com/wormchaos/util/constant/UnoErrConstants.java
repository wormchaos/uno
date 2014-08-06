/*
 * FileName: UnoErrConstants.java
 * Author:   wormchaos
 * Date:     2014-8-5 下午4:45:48
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.util.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UnoErrConstants {

    /**
     * 系统异常
     */
    public static final String DEFAULT_ERROR = "U0001";

    /**
     * 用户鉴权异常
     */
    public static final String USER_TOKEN_ERROR = "U3001";

    /**
     * 用户已登录
     */
    public static final String USER_ALREADY_LOGIN = "U3002";

    /**
     * 错误码消息映射
     */
    public static final Map<String, String> ERROR_MSG_MAPPING = new HashMap<String, String>() {
        /**
         * serialVersionUID
         */
        private static final long serialVersionUID = -1299431555757561464L;
        {
            put(DEFAULT_ERROR, "系统异常");
            put(USER_TOKEN_ERROR, "用户鉴权异常");
            put(USER_ALREADY_LOGIN, "用户已登录");
        }
    };
}
