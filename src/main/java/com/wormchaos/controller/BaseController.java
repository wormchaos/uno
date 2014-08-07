/**
 * FileName: BaseController.java
 * Author:   wormchaos
 * Date:     2014-8-7 下午7:38:15
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.controller;

import org.springframework.stereotype.Controller;

import com.wormchaos.util.GsonView;
import com.wormchaos.util.constant.UnoConstants;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
public class BaseController {
    
    /**
     * 
     * 功能描述: <br>
     * 创建默认成功的gsonView
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public GsonView createGson(){
        GsonView gv = new GsonView();
        gv.addStaticAttribute(UnoConstants.SUCCESS_FLG, UnoConstants.SUCCESS);
        gv.addStaticAttribute(UnoConstants.ERROR_CODE, UnoConstants.EMPTY_STR);
        gv.addStaticAttribute(UnoConstants.ERROR_MSG, UnoConstants.EMPTY_STR);
        return gv;
    }
}
