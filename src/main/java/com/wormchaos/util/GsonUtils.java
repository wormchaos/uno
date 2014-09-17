/**
 * FileName: GsonUtils.java
 * Author:   wormchaos
 * Date:     2014-9-16 下午5:13:34
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.util;

import com.wormchaos.util.constant.UnoConstants;
import com.wormchaos.util.constant.UnoErrConstants;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class GsonUtils {

    /**
     * 
     * 功能描述: <br>
     * 添加错误信息
     *
     * @param gv
     * @param errorCode
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void addErrCode(GsonView gv, String errorCode) {
        gv.addStaticAttribute(UnoConstants.SUCCESS_FLG, UnoConstants.FAILED);
        gv.addStaticAttribute(UnoConstants.ERROR_CODE, errorCode);
        gv.addStaticAttribute(UnoConstants.ERROR_MSG, UnoErrConstants.ERROR_MSG_MAPPING.get(errorCode));
    }

    /**
     * 
     * 功能描述: <br>
     * 添加错误信息
     *
     * @param gv
     * @param errorCode
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void addErrInfo(GsonView gv, String errorInfo) {
        gv.addStaticAttribute(UnoConstants.SUCCESS_FLG, UnoConstants.FAILED);
        gv.addStaticAttribute(UnoConstants.ERROR_MSG, errorInfo);
    }
}
