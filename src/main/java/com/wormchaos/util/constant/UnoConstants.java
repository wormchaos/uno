/**
 * FileName: UnoConstants.java
 * Author:   wormchaos
 * Date:     2014-8-6 上午9:58:36
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
public class UnoConstants {
    /**
     * 用户鉴权token
     */
    public static final String TOKEN = "token";
    
    /**
     * 空string
     */
    public static final String EMPTY_STR = "";
    
    /**
     * successFlg
     */
    public static final String SUCCESS_FLG = "successFlg";
    
    /**
     * errorCode
     */
    public static final String ERROR_CODE = "errorCode";
    
    /**
     * errorMsg
     */
    public static final String ERROR_MSG = "errorMsg";
    /**
     * 成功返回码
     */
    public static final int SUCCESS = 1;
    /**
     * 失败返回码
     */
    public static final int FAILED = 0;
    
    /**
     * 起始摸牌数
     */
    public static final int DEFAULT_DRAW = 6;

    /**
     * 事件 - 抽牌
     */
    public static final String EVENT_DRAW = "draw";

    /**
     * 事件 - 扔牌
     */
    public static final String EVENT_THROW = "use";
}
