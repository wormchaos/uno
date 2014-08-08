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
import com.wormchaos.dto.GameStateBean;
import com.wormchaos.util.CardUtils;
import com.wormchaos.util.GameStateUtils;
import com.wormchaos.util.GsonView;
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
public class GameController extends BaseController{

    private static final String INDEX_PAGE = "game/index";

    /**
     * 
     * 功能描述: <br>
     * 进入游戏页面
     * 通过cookie获得用户id并取得卡牌信息
     *
     * @param request
     * @param response
     * @param playerNum
     * @return
     * @throws UnoException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "playerNum", required = false) Integer playerNum) throws UnoException {
        ModelAndView model = new ModelAndView(INDEX_PAGE);
        // String userId = UserUtils.queryUserId(request);
        // TODO
        // gameId = queryGameIdByUser
        Long gameId = 1L;
        GameStateUtils.initGameState(gameId, playerNum, null);
        List<CardBean> cardList = CardUtils.draw(gameId, 6);
        int cardListNum = cardList.size();

        model.addObject("cardList", cardList);
        List<CardBean> cemeteryList = GameStateUtils.queryGameState(gameId).getCemeteryList();
        model.addObject("deckListNum", GameStateUtils.queryGameState(gameId).getDeckList().size());
        model.addObject("cemeteryNum", cemeteryList.size());
        // model.addObject("lastCemetery", cemeteryList.get(cemeteryList.size() - 1));
        model.addObject("deckNum", cardListNum);
        return model;
    }
    
    /**
     * 
     * 功能描述: <br>
     * 当前场上情况
     *
     * @param request
     * @param response
     * @param gameId
     * @return
     * @throws UnoException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("ajax/fieldState")
    public GsonView queryGameState(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "gameId", required = false) String gameId) throws UnoException {
        Long gId = null;
        try {
            gId = Long.parseLong(gameId);
        } catch (Exception e) {
            // 抛出异常
        }
        GsonView gv = new GsonView();
        GameStateBean gameState = GameStateUtils.queryGameState(gId);

        gv.addStaticAttribute("deckListNum", gameState.getDeckList().size());
        gv.addStaticAttribute("cemeteryNum", gameState.getCemeteryList().size());
        gv.addStaticAttribute("lastCemetery", gameState.getLastCard());
        gv.addStaticAttribute("players", gameState.getPlayers());
        
        // 上面是整个场地的情况
        // 下面是对当前用户的信息
        String userId = UserUtils.queryUserId(request);
        // TODO 根据用户Id获取当前手牌信息
        
        return gv;
    }
    
    /**
     * 
     * 功能描述: <br>
     * 创建游戏
     *
     * @param request
     * @param response
     * @param gameId
     * @throws UnoException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("createGame")
    public GsonView createGame(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "roomId", required = false) String roomId) throws UnoException {
        GsonView gv = createGson();
        // TODO 数据库操作创建游戏
        // TODO 获取所有房间等待中玩家并把状态改为游戏中
        // TODO 初始化gamestate状态
        // TODO 所有玩家抽牌，并在gamestate里更新
        // 如果失败，把异常返回
        return gv;
    }
    
    @RequestMapping("ajax/checkGameStart")
    public GsonView checkGameStart(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "roomId", required = false) String roomId) throws UnoException {
        GsonView gv = createGson();
        // TODO 数据库获取当前是否游戏开始
        // 如果开始，返回默认的gv，否则返回successFlg=0
        return gv;
    }
}
