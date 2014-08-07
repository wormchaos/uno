/**
 * FileName: GameController.java
 * Author:   wormchaos
 * Date:     2014-8-7 下午4:37:44
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wormchaos.dto.CardBean;
import com.wormchaos.util.CardUtils;
import com.wormchaos.util.GameStateUtils;
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
@RequestMapping("game")
public class GameController {
    
    private static final String INDEX_PAGE = "game/index";
    
    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value="playerNum", required = false) String playerNum) throws UnoException{
        ModelAndView model = new ModelAndView(INDEX_PAGE);
        // String userId = UserUtils.queryUserId(request);
        // TODO 
        // gameId = queryGameIdByUser
        Long gameId = 1L;
        GameStateUtils.initGameState(gameId);
        List<CardBean> cardList = CardUtils.draw(gameId, 4);
        model.addObject("cardList", cardList);
        return model;
    }
}
