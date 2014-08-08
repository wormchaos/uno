/**
 * FileName: EventController.java
 * Author:   wormchaos
 * Date:     2014-8-8 上午11:25:53
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wormchaos.dto.GameEventBean;
import com.wormchaos.util.GsonView;
import com.wormchaos.util.MessageUtils;
import com.wormchaos.util.UserUtils;
import com.wormchaos.util.exception.UnoException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author wormchaos
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("event")
public class EventController extends BaseController{
    
    @RequestMapping("ajax/unReadMsg")
    public GsonView queryUnReadEvent(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "gameId", required = false) Long gameId) throws UnoException{
        GsonView gv = createGson();
        String userId = UserUtils.queryUserId(request);
        List<GameEventBean> unreadMessage = MessageUtils.getUnreadMessage(gameId, userId);
        gv.addStaticAttribute("msgList", unreadMessage);
        return gv;
    }
}
