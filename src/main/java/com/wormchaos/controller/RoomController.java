/**
 * FileName: RoomController.java
 * Author:   wormchaos
 * Date:     2014-9-16 下午4:09:46
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.wormchaos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wormchaos.service.RoomService;
import com.wormchaos.util.GsonView;
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
@RequestMapping("room")
public class RoomController {
    
    @Autowired
    RoomService roomService;
    
    /**
     * 
     * 功能描述: <br>
     * 检查游戏是否开始
     *
     * @param request
     * @param response
     * @param roomId
     * @return
     * @throws UnoException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("check")
    public GsonView checkGameStart(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "roomId", required = false) Long roomId) throws UnoException {
        GsonView gv = new GsonView();
        // 根据roomId查询游戏状态
        Integer status = roomService.checkGameStatus(roomId);
        gv.addStaticAttribute("status", status);
        return gv;
    }

}
