/**
 * FileName: UnoJsonErrConstants.java
 * Author:   wormchaos
 * Date:     2014-8-7 下午7:49:00
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
public class UnoJsonErrConstants {

    /**
     * 系统异常
     */
    public static final String DEFAULT_ERROR = "J0001";

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
        }
    };
}
