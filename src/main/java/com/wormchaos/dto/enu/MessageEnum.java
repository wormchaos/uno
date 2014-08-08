/**
 * FileName: MessageEnum.java
 * Author:   wormchaos
 * Date:     2014-8-8 上午10:19:57
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.dto.enu;

import java.util.HashMap;
import java.util.Map;

import com.wormchaos.util.constant.UnoConstants;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum MessageEnum {
    
    start("start", "game start"),
    
    end("end", "game end"),
    
    draw("start"),
    
    use("use");
    
    private String code;
    
    private String message;
    
    /**
     * 空constructor
     */
    MessageEnum() {
    }
    
    /**
     * 构造
     */
    MessageEnum(String code) {
        this.code = code;
        this.message = EVENT_MSG_MAPPING.get(code);
    }
    
    /**
     * 构造
     */
    MessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * 事件映射
     */
    private final Map<String, String> EVENT_MSG_MAPPING = new HashMap<String, String>() {
        /**
         * serialVersionUID
         */
        private static final long serialVersionUID = -1299431555757561464L;
        {
            put(UnoConstants.EVENT_DRAW, "#o#抽了#n#张牌");
            put(UnoConstants.EVENT_THROW, "#o#打出了#c#");
        }
    };
    
}
